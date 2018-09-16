$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'hladmin/hltransaction/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '转账账号', name: 'userName', index: 'user_name', width: 80 }, 			
			{ label: '转账姓名', name: 'name', index: 'name', width: 80 }, 			
			{ label: '收款账号', name: 'targetUserName', index: 'target_user_name', width: 80 }, 			
			{ label: '收款姓名', name: 'targetName', index: 'target_name', width: 80 }, 			
			{ label: '交易类型', name: 'type', index: 'type', width: 80, formatter: customFmatter }, 			
			{ label: '交易数量', name: 'amount', index: 'amount', width: 80 }, 			
			{ label: '实际到账数量（对公账户收取手续费）', name: 'realAmount', index: 'real_amount', width: 80 }, 			
			{ label: '交易日期', name: 'tranDate', index: 'tran_date', width: 80 }, 			
			{ label: '货币价格', name: 'price', index: 'price', width: 80 }, 			
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
    
    function customFmatter(cellvalue, options, rowObject){
    	if(cellvalue == '1'){
    		return '对私交易';
    	}else{
    		return '对公交易';
    	}
    }
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		hlTransaction: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.hlTransaction = {};
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
			var url = vm.hlTransaction.id == null ? "hladmin/hltransaction/save" : "hladmin/hltransaction/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.hlTransaction),
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
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "hladmin/hltransaction/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "hladmin/hltransaction/info/"+id, function(r){
                vm.hlTransaction = r.hlTransaction;
            });
		},
		exportExcel: function(){
			location.href = baseURL + "hladmin/hltransaction/export";
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});