$(function () {
	
	function statusFmatter(cellvalue, options, rowObject){
		if(1 == cellvalue){
			return '申请';
		}else {
			return '已购买';
		}
	}
	
    $("#jqGrid").jqGrid({
        url: baseURL + 'hladmin/hlpurchase/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '登陆名', name: 'userName', index: 'user_name', width: 80 }, 			
			{ label: '用户姓名', name: 'name', index: 'name', width: 80 }, 			
			{ label: '购买数量', name: 'amount', index: 'amount', width: 80 }, 			
			{ label: '购买状态', name: 'status', index: 'status', width: 80, formatter: statusFmatter }, 			
			{ label: '申请日期', name: 'applyDate', index: 'apply_date', width: 80 }, 			
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
});


var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		hlPurchase: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		audit: function(){
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			var url = "hladmin/hlpurchase/audit/"+id;
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
			var url = vm.hlPurchase.id == null ? "hladmin/hlpurchase/save" : "hladmin/hlpurchase/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.hlPurchase),
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
				    url: baseURL + "hladmin/hlpurchase/delete",
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
			$.get(baseURL + "hladmin/hlpurchase/info/"+id, function(r){
				if(vm.hlPurchase.status == 2){
					alert('不允许修改已审核的数据', function(index){
						vm.reload();
					});
					return false;
				}
                vm.hlPurchase = r.hlPurchase;
            });
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