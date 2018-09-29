$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/sysclientreward/list',
        datatype: "json",
        colModel: [			
			{ label: '主键', name: 'id', index: 'id', width: 50, key: true },
			{ label: '用户id', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '金额', name: 'money', index: 'money', width: 50 },
			{ label: '获取方式', name: 'type', index: 'type', width: 80 },
			{ label: '是否使用', name: 'isUse', index: 'is_use', width: 50 },
			{ label: '红包过期时间', name: 'timeout', index: 'timeout', width: 80 },
			{ label: '获取红包时间', name: 'addtime', index: 'addtime', width: 80 }, 			
			{ label: '用户名', name: 'username', index: 'username', width: 80 }, 			
			{ label: '被推荐人id', name: 'recommendedId', index: 'recommended_id', width: 80 }, 			
			{ label: '红包使用时间', name: 'usetime', index: 'usetime', width: 80 }, 			
			{ label: '红包编号', name: 'rewardNo', index: 'reward_no', width: 80 }, 			
			{ label: '红包类型', name: 'rewardStyle', index: 'reward_style', width: 80 },
			{ label: '红包名称', name: 'rewardName', index: 'reward_name', width: 80 }, 			
			{ label: '是否可叠加使用', name: 'useTogether', index: 'use_together', width: 80 },
			{ label: '满多少可使用', name: 'moneyLimit', index: 'money_limit', width: 80 }, 			
			{ label: '到期提醒', name: 'sign', index: 'sign', width: 80 }
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
		sysClientReward: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.sysClientReward = {sign:0};
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
			var url = vm.sysClientReward.id == null ? "sys/sysclientreward/save" : "sys/sysclientreward/update";

			vm.sysClientReward.timeout = vm.sysClientReward.timeout+' 23:59:59';

			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.sysClientReward),
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
				    url: baseURL + "sys/sysclientreward/delete",
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
			$.get(baseURL + "sys/sysclientreward/info/"+id, function(r){
                vm.sysClientReward = r.sysClientReward;
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