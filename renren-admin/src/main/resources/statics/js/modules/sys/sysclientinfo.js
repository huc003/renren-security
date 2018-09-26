$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/sysclientinfo/list',
        datatype: "json",
        colModel: [			
			{ label: '用户ID', name: 'userId', index: 'user_id', width: 50, key: true },
			{ label: '用户名', name: 'userName', index: 'user_name', width: 80 },
			{ label: '邀请用户ID', name: 'inviteUserid', index: 'invite_userid', width: 50 },
			{ label: '状态', name: 'status', index: 'status', width: 30 ,formatter: function(value, options, row){
                return value === 0 ?
                    '<span class="label label-danger">禁用</span>' :
                    '<span class="label label-success">正常</span>';
            }},
			{ label: '身份证', name: 'cardId', index: 'card_id', width: 80 },
			{ label: '姓名', name: 'realName', index: 'real_name', width: 80 },
			{ label: '昵称', name: 'nickName', index: 'nick_name', width: 80 },
			{ label: '生日', name: 'birthday', index: 'birthday', width: 80 },
			{ label: '手机号', name: 'phone', index: 'phone', width: 80 },
			{ label: '邮箱', name: 'email', index: 'email', width: 80 },
			{ label: '性别', name: 'sex', index: 'sex', width: 30,formatter: function(value, options, row){
                return value === 0 ?
                    '<span class="label label-danger">女</span>' :
                    '<span class="label label-success">男</span>';
            }},
			{ label: '注册时间', name: 'addTime', index: 'add_time', width: 80 },
			{ label: '修改时间', name: 'updateTime', index: 'update_time', width: 80 },
			{label:'操作',name:'userId',index:'user_id',formatter: function(value, options, row){
                return '<a class="btn btn-primary" onclick="vm.info('+value+')"><i class="fa fa-search"></i>&nbsp;查看</a>';
            }}
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
		sysClientInfo: {},
		userInfo:{}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.sysClientInfo = {status:1,sex:0};
		},
		update: function (event) {
			var userId = getSelectedRow();
			if(userId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(userId)
		},
		saveOrUpdate: function (event) {
            if(vm.validator()){
                return ;
            }
			var url = vm.sysClientInfo.userId == null ? "sys/sysclientinfo/save" : "sys/sysclientinfo/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.sysClientInfo),
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
			var userIds = getSelectedRows();
			if(userIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/sysclientinfo/delete",
                    contentType: "application/json",
				    data: JSON.stringify(userIds),
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
		getInfo: function(userId){
			$.get(baseURL + "sys/sysclientinfo/info/"+userId, function(r){
                vm.sysClientInfo = r.sysClientInfo;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		},
        validator: function () {
            if(isBlank(vm.sysClientInfo.userName)){
                alert("用户名不能为空");
                return true;
            }

            if(isBlank(vm.sysClientInfo.passWord)){
                alert("密码不能为空");
                return true;
            }

        },info: function(userId){
            $.get(baseURL + "sys/sysclientinfo/info/"+userId, function(r){
                vm.userInfo = r.sysClientInfo;
                layer.open({
                    title: '用户&nbsp;'+vm.userInfo.userName,
                    area: ['500px', '500px'],
                    content:
					'<div class="form-group">'+
					'<div class="col-sm-2 control-label">姓名:</div>'+
					'<div class="col-sm-10">'+vm.userInfo.realName+'</div>'+
					'</div>'+
                    '<div class="form-group">'+
                    '<div class="col-sm-2 control-label">注册时间:</div>'+
                    '<div class="col-sm-10">'+vm.userInfo.addTime+'</div>'+
                    '</div>'+
					'<div class="form-group">'+
					'<div class="col-sm-2 control-label">昵称:</div>'+
					'<div class="col-sm-10">'+vm.userInfo.nickName+'</div>'+
					'</div>'+
                    '<div class="form-group">'+
                    '<div class="col-sm-2 control-label">生日:</div>'+
                    '<div class="col-sm-10">'+vm.userInfo.birthday+'</div>'+
                    '</div>'+
                    '<div class="form-group">'+
                    '<div class="col-sm-2 control-label">手机号:</div>'+
                    '<div class="col-sm-10">'+vm.userInfo.phone+'</div>'+
                    '</div>'+
                    '<div class="form-group">'+
                    '<div class="col-sm-2 control-label">邮箱:</div>'+
                    '<div class="col-sm-10">'+vm.userInfo.email+'</div>'+
                    '</div>'+
                    '<div class="form-group">'+
                    '<div class="col-sm-2 control-label">性别:</div>'+
                    '<div class="col-sm-10">'+vm.userInfo.sex+'</div>'+
                    '</div>'+
                    '<div class="form-group">'+
                    '<div class="col-sm-2 control-label">邀请用户ID:</div>'+
                    '<div class="col-sm-10">'+vm.userInfo.inviteUserid+'</div>'+
                    '</div>'+
                    '<div class="form-group">'+
                    '<div class="col-sm-2 control-label">状态:</div>'+
                    '<div class="col-sm-10">'+vm.userInfo.status+'</div>'+
                    '</div>'
                });
            });


        }
	}
});