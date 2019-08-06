$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'mis/mistest/list',
        datatype: "json",
        colModel: [
            { label: 'id', name: 'id', index: 'id', width: 50, key: true },
            { label: '测试名', name: 'title', index: 'title', width: 80 },
            { label: '图片', name: 'imgsrc', index: 'imgsrc', width: 80 },
            { label: '价格', name: 'price', index: 'price', width: 80 },
            { label: '测试人数', name: 'testnumber', index: 'testnumber', width: 80 },
            { label: '测试介绍', name: 'testintroduce', index: 'testintroduce', width: 80 },
            { label: '创建时间', name: 'createtime', index: 'createtime', width: 80 },
            { label: '所属分类名', name: 'cname', index: 'cname', width: 80 }
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
            title: null,
            cname: null
        },
        showList: true,
        title:null,
        misTest:{}
    },
    methods: {
        excel:function(){
            window.location.href=baseURL+"mis/my/exportexcel";
        },
        query: function () {
            vm.reload();
        },
        add: function(){
            vm.showList = false;
            vm.title = "新增";

            vm.misTest= {};


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
            var testIds = getSelectedRows();
            if(testIds == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "mis/mistest/delete",
                    contentType: "application/json",
                    data: JSON.stringify(testIds),
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

            var url = vm.misTest.id == null ? "mis/mistest/save" : "mis/mistest/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.misTest),
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
            $.get(baseURL + "mis/mistest/info/"+id, function(r){
                vm.misTest = r.misTest;
            });
        },

        reload: function () {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'title': vm.q.title,'cname':vm.q.cname},
                page:page
            }).trigger("reloadGrid");
        }

    }
});