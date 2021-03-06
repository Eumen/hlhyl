$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'hladmin/hluser/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '', name: 'userName', index: 'user_name', width: 80 }, 			
			{ label: '', name: 'name', index: 'name', width: 80 }, 			
			{ label: '', name: 'idCard', index: 'id_card', width: 80 }, 			
			{ label: '', name: 'tel', index: 'tel', width: 80 }, 			
			{ label: '', name: 'bankName', index: 'bank_name', width: 80 }, 			
			{ label: '', name: 'bankNo', index: 'bank_no', width: 80 }, 			
			{ label: '流通货币数量', name: 'amount', index: 'amount', width: 80 }, 			
			{ label: '锁仓数量', name: 'lockAmount', index: 'lock_amount', width: 80 }, 			
			{ label: '推荐人账号', name: 'recUser', index: 'rec_user', width: 80 }, 			
			{ label: '推荐人姓名', name: 'recName', index: 'rec_name', width: 80 }, 			
			{ label: '', name: 'registerDate', index: 'register_date', width: 80 }, 			
			{ label: '', name: 'comment', index: 'comment', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
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
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		hlUser: {}
	},
	created: function() {
		$.get(baseURL + "sys/hluser/currentinfo", function(r){
            vm.hlUser = r.hlUser;
        });
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.hlUser = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			debugger
			var url = "sys/hluser/update";
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
			$.get(baseURL + "hladmin/hluser/info/"+id, function(r){
                vm.hlUser = r.hlUser;
            });
		},
		reload: function (event) {
			vm.showList = true;
		}
	}
});