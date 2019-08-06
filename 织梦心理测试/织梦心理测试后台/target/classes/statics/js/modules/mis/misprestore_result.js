$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'mis/misprestore_result/list',
        datatype: "json",
        colModel: [
            { label: 'ID', name: 'id', index: "id", width: 25, key: true },
            { label: '结果', name: 'result',index:"result", width: 75 },
            { label: '详情', name: 'details',index:"details", width: 75 },
            { label: '最大分数', name: 'maxscore',index:"maxscore", width: 75 },
            { label: '最小分数', name: 'minscore',index:"minscore", width: 75 },
            { label: '所属测试', name: 'tname',index:"tname", width: 75 }

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
        q:{
            tname: null
        },
        showList: true,
        title:null,
        misPrestore_result:{}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function(){
            vm.showList = false;
            vm.title = "新增";

            vm.misPrestore_result= {};


        },

        update: function () {
            var id = getSelectedRow();
            if(id == null){
                return ;
            }

            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id);

        },
        del: function () {
            var prestore_resultIds = getSelectedRows();
            if(prestore_resultIds == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "mis/misprestore_result/delete",
                    contentType: "application/json",
                    data: JSON.stringify(prestore_resultIds),
                    success: function(r){
                        if(r.code == 0){
                            alert('操作成功', function(){
                                vm.reload();
                            });
                        }else{
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        saveOrUpdate: function () {

            var url = vm.misPrestore_result.id == null ? "mis/misprestore_result/save" : "mis/misprestore_result/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.misPrestore_result),
                success: function(r){
                    if(r.code === 0){
                        alert('操作成功', function(){
                            vm.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
        getInfo: function(id){
            $.get(baseURL + "mis/misprestore_result/info/"+id, function(r){
                vm.misPrestore_result = r.misPrestore_result;
            });
        },

        reload: function () {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'tname': vm.q.tname},
                page:page
            }).trigger("reloadGrid");
        }

    }
});