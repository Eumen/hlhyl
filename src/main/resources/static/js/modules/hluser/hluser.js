$(function () {
	
	function awardFmatter(cellvalue, options, rowObject){
		if(1 == cellvalue){
			return '锁仓奖励';
		}else {
			return '直推奖励';
		}
	}
	function transactionFmatter(cellvalue, options, rowObject){
		if(1 == cellvalue){
			return '对私交易';
		}else {
			return '对公交易';
		}
	}
	
    $("#transaction").jqGrid({
        url: baseURL + 'hladmin/hltransaction/list',
        datatype: "json",
        colModel: [			
        	{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '用户登陆名', name: 'userName', index: 'user_name', width: 80 }, 			
			{ label: '姓名', name: 'name', index: 'name', width: 80 }, 			
			{ label: '转账账号', name: 'targetUserName', index: 'target_user_name', width: 80 }, 			
			{ label: '转账姓名', name: 'targetName', index: 'target_name', width: 80 }, 			
			{ label: '交易类型', name: 'type', index: 'type', width: 80, formatter: transactionFmatter  }, 			
			{ label: '交易数量', name: 'amount', index: 'amount', width: 80 }, 			
			{ label: '交易时间', name: 'tranDate', index: 'tran_date', width: 80 }, 			
			{ label: '对公账户收取手续费', name: 'realAmount', index: 'real_amount', width: 80 }, 			
			{ label: '备注', name: 'comment', index: 'comment', width: 80 }					
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#transactionGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#transaction").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
    
    $("#reward").jqGrid({
        url: baseURL + 'hladmin/hlreward/list',
        datatype: "json",
        colModel: [			
        	{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '用户登陆名', name: 'userName', index: 'user_name', width: 80 }, 			
			{ label: '姓名', name: 'name', index: 'name', width: 80 }, 			
			{ label: '金额', name: 'amount', index: 'amount', width: 80 }, 			
			{ label: '日期', name: 'awardDate', index: 'award_date', width: 80 }, 			
			{ label: '类型', name: 'awardType', index: 'award_type', width: 80, formatter: awardFmatter }, 			
			{ label: '备注', name: 'comment', index: 'comment', width: 80 }		
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#rewardGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#reward").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		hlUser: {
			price : '',
			amount : '',
			lockAmount : '',
			recUser : '',
			willLockAmount : ''
		},
		recLink: null,
		imgUrl: null
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
		},
		saveOrUpdate: function (event) {
			var url = vm.hlUser.id == null ? "hluser/hluser/save" : "hluser/hluser/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.hlUser),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		getInfo: function(id){
			$.get(baseURL + "hluser/hluser/info/"+id, function(r){
                vm.hlUser = r.hlUser;
            });
		},
		reload: function (event) {
			var url = "/sys/hluser/list";
			$.get(url, function(r){
			    vm.hlUser = r.hlUser;
			});
		},
		lockAmount: function(event){
			if(!/^\d+$/.test(vm.hlUser.willLockAmount)){
				alert("请输入正确的数字")
				return false;
			}else{
				var url = "sys/hluser/lock/" + vm.hlUser.willLockAmount;
				$.ajax({
					type: "POST",
				    url: baseURL + url,
	                contentType: "application/json",
				    success: function(r){
				    	if(r.code === 0){
							alert('操作成功', function(index){
								vm.reload();
							});
						}else{
							alert(r.msg);
						}
					}
				});
			}
		}
	}
});
var url = "/sys/hluser/list";
$.get(url, function(r){
    vm.hlUser = r.hlUser;
    vm.recLink = "www.hl518.top:88/register.html?userName=" + r.hlUser.userName;
    var qrcode= $('#qrDiv').qrcode(vm.recLink).hide();   
    var canvas=qrcode.find('canvas').get(0);  
	$('#imagQrDiv').attr('src',canvas.toDataURL('image/png')) ; 
});
