$(function () {
	
	$(function () {
	    var picker1 = $('#datetimepicker1').datetimepicker({
	        format: 'YYYY-MM-DD',
	        locale: moment.locale('zh-cn'),
	        //minDate: '2016-7-1'
	    });
	    var picker2 = $('#datetimepicker2').datetimepicker({
	        format: 'YYYY-MM-DD',
	        locale: moment.locale('zh-cn')
	    });
	    //动态设置最小值
//	    picker1.on('dp.change', function (e) {
//	        picker2.data('DateTimePicker').minDate(e.date);
//	    });
//	    //动态设置最大值
//	    picker2.on('dp.change', function (e) {
//	        picker1.data('DateTimePicker').maxDate(e.date);
//	    });
	});

	
    $("#jqGrid").jqGrid({
        url: '/sys/hluser/listAll',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '用户账户', name: 'userName', index: 'user_name', width: 80 }, 			
			{ label: '姓名', name: 'name', index: 'name', width: 80 }, 			
			{ label: '密码', name: 'dePassword', index: 'name', width: 80 }, 			
			{ label: '身份证', name: 'idCard', index: 'id_card', width: 80 }, 			
			{ label: '电话', name: 'tel', index: 'tel', width: 80 }, 			
			{ label: '开户银行', name: 'bankName', index: 'bank_name', width: 80 }, 			
			{ label: '银行卡号', name: 'bankNo', index: 'bank_no', width: 80 }, 			
			{ label: '流通货币数量', name: 'amount', index: 'amount', width: 80 }, 			
			{ label: '锁仓数量', name: 'lockAmount', index: 'lock_amount', width: 80 }, 			
			{ label: '推荐人账号', name: 'recUser', index: 'rec_user', width: 80 }, 			
			{ label: '推荐人姓名', name: 'recName', index: 'rec_name', width: 80 }, 			
			{ label: '注册日期', name: 'registerDate', index: 'register_date', width: 80 }, 			
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
    
    $("#modifyRecUser").click(function(){
    	var id = getSelectedRow();
    	if(id == null){
			return ;
		}
    	$.get("/sys/hluser/info/"+id, function(r){
            vm.hlUser = r.hlUser;
            $('#myModal').modal('show');
        });
    });
    
});
//加载菜单树
var setting = {
	    data: {
	        simpleData: {
	            enable: true,
	            idKey: "regionCode",
	            pIdKey: "parentRegionCode",
	            rootPId: -1,
	        },
	        key: {
	            url:"nourl"
	        }
	    }
	};
var ztree;
var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		hlUser: {
			userName: null,
			parentRegionCode:0,
			regionCode: 0,
			regionName: null,
			startDate: null,
			endDate: null
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		regionTree: function(){
			$.get("/sys/hluser/listRegion", function(r){
		        ztree = $.fn.zTree.init($("#regionTree"), setting, r.allRegion);
		        var node = ztree.getNodeByParam("regionCode", vm.hlUser.regionCode);
		        ztree.selectNode(node);

		        vm.hlUser.regionName = node.regionName;
		        vm.hlUser.regionCode = node.regionCode;
				layer.open({
	                type: 1,
	                offset: '50px',
	                skin: 'layui-layer-molv',
	                title: "选择行政区划",
	                area: ['300px', '450px'],
	                shade: 0,
	                shadeClose: false,
	                content: jQuery("#regionLayer"),
	                btn: ['确定', '取消'],
	                btn1: function (index) {
	                	debugger
	                    var node = ztree.getSelectedNodes();
	                    //选择上级菜单
	                    vm.hlUser.regionName = node[0].name;
	                    vm.hlUser.regionCode = node[0].regionCode;
	
	                    layer.close(index);
	                }
	            });
		    });
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
		updateRecUser: function(event){
			var id = getSelectedRow();
	    	if(id == null){
				return ;
			}
	    	var data = {
	    		id : id,
	    		recNewUserName : vm.hlUser.recNewUserName,
	    		recNewName : vm.hlUser.recNewName
	    	}
	    	$.ajax({
				type: "POST",
			    url: "/sys/hluser/modifyRecUser",
                contentType: "application/json",
			    data: JSON.stringify(vm.hlUser),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							$('#myModal').modal('hide');
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		saveOrUpdate: function (event) {
			var url = vm.hlUser.id == null ? "/sys/hluser/save" : "/sys/hluser/update";
			$.ajax({
				type: "POST",
			    url: url,
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
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "/sys/hluser/delete",
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
			$.get("/sys/hluser/info/"+id, function(r){
                vm.hlUser = r.hlUser;
            });
		},
		resetPassword: function(id){
			var userId = getSelectedRow();
			if(userId == null){
				return ;
			}
			confirm('该操作将用户密码重置为（112233）？', function(){
				$.get("/sys/hluser/password/"+userId, function(r){
					if(r.code == 0){
						alert('操作成功，用户新密码为112233');
					}else{
						alert(r.msg);
					}
	            });
			});
		},
		exportExcel: function(){
			location.href = "/sys/hluser/export";
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:{
					'userName': vm.hlUser.userName,
					'regionCode': vm.hlUser.regionCode,
					'startDate': $("#startDate").val(),
					'endDate': $("#endDate").val()
				},
                page:page
            }).trigger("reloadGrid");
		}
	}
});

