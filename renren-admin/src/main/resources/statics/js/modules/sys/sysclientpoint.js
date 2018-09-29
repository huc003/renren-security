$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/sysclientpoint/list',
        datatype: "json",
        colModel: [
            {label: '用户ID', name: 'userId', index: 'user_id', width: 50, key: true},
            {label: '拥有积分', name: 'point', index: 'point', width: 80},
            {label: '使用积分', name: 'pointUsed', index: 'point_used', width: 80},
            {label: '过期积分', name: 'pointExpired', index: 'point_expired', width: 80},
            {label: '冻结积分', name: 'pointFrozen', index: 'point_frozen', width: 80},
            {label: '修改时间', name: 'updateTime', index: 'update_time', width: 80},
            {
                label: '操作', name: 'userId', index: 'user_id', formatter: function (value, options, row) {
                return '<a class="btn btn-primary" onclick="vm.info(' + value + ')"><i class="fa fa-search"></i>&nbsp;详情</a>';
            }
            }
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });


    $("#jqGrid2").jqGrid({
        url: baseURL + 'sys/sysclientpointdetails/list',
        datatype: "json",
        colModel: [
            {label: '主键', name: 'id', index: 'id', width: 30, key: true},
            {label: '积分', name: 'point', index: 'point', width: 30},
            {label: '用户ID', name: 'userId', index: 'user_id', width: 30},
            {label: '积分来源', name: 'sourceType', index: 'source_type', width: 30},
            {label: '添加时间', name: 'addtime', index: 'addtime', width: 30},
            {label: '积分类型', name: 'pointType', index: 'point_type', width: 30},
            {label: '积分说明', name: 'source', index: 'source', width: 30},
            {label: '过期时间', name: 'expiredTime', index: 'expired_time', width: 30},
            {label: '剩余积分', name: 'overage', index: 'overage', width: 30},
            {label: '已使用积分', name: 'pointUsed', index: 'point_used', width: 30}
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        // multiselect: true,
        pager: "#jqGridPager2",
        jsonReader: {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid2").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });

    $('#point_detail').hide();
    $('#point').show();
});

var vm = new Vue({
    el: '#rrapp',
    data: {
        q: {
            userId: null
        },
        showList: true,
        title: null,
        sysClientPoint: {},
        pointInfo: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.sysClientPoint = {type: 0};
        },
        update: function (event) {
            var userId = getSelectedRow();
            if (userId == null) {
                return;
            }
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(userId)
        },
        saveOrUpdate: function (event) {
            var url = vm.sysClientPoint.userId == null ? "sys/sysclientpoint/save" : "sys/sysclientpoint/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.sysClientPoint),
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function (index) {
                            vm.reload();
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },
        del: function (event) {
            var userIds = getSelectedRows();
            if (userIds == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/sysclientpoint/delete",
                    contentType: "application/json",
                    data: JSON.stringify(userIds),
                    success: function (r) {
                        if (r.code == 0) {
                            alert('操作成功', function (index) {
                                $("#jqGrid").trigger("reloadGrid");
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        getInfo: function (userId) {
            $.get(baseURL + "sys/sysclientpoint/info/" + userId, function (r) {
                vm.sysClientPoint = r.sysClientPoint;
            });
        },
        reload: function (event) {
            vm.showList = true;
            $("#point_detail").hide();
            $("#point").show();
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {'userId': vm.q.userId},
                page: page
            }).trigger("reloadGrid");
        }, info: function (userId) {
            $("#point").hide();
            $("#point_detail").show();
            var page = $("#jqGrid2").jqGrid('getGridParam', 'page');
            $("#jqGrid2").jqGrid('setGridParam', {
                postData: {'userId': userId},
                page: page
            }).trigger("reloadGrid");
        }
    }
});
