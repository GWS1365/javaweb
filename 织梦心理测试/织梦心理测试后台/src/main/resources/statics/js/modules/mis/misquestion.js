$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'mis/misquestion/list',
        datatype: "json",
        colModel: [
            { label: 'ID', name: 'id', index: "id", width: 25, key: true },
            { label: '题目', name: 'question',index:"question", width: 75 },
            { label: '选择A', name: 'choicea',index:"choicea", width: 75 },
            { label: '选择B', name: 'choiceb',index:"choiceb", width: 75 },
            { label: '选择C', name: 'choicec',index:"choicec", width: 75 },
            { label: '选择D', name: 'choiced',index:"choiced", width: 75 },
            { label: '选择E', name: 'choicee',index:"choicee", width: 75 },
            { label: '选择F', name: 'choicef',index:"choicef", width: 75 },
            { label: '选择G', name: 'choiceg',index:"choiceg", width: 75 },
            { label: '选择H', name: 'choiceh',index:"choiceh", width: 75 },
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
            question: null,
            tname:null
        },
        showList: true,
        title:null,
        misQuestion:{}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function(){
            vm.showList = false;
            vm.title = "新增";

            vm.misQuestion= {};


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
            var questionIds = getSelectedRows();
            if(questionIds == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "mis/misquestion/delete",
                    contentType: "application/json",
                    data: JSON.stringify(questionIds),
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

            var url = vm.misQuestion.id == null ? "mis/misquestion/save" : "mis/misquestion/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.misQuestion),
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
            $.get(baseURL + "mis/misquestion/info/"+id, function(r){
                vm.misQuestion = r.misQuestion;
            });
        },

        reload: function () {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'question': vm.q.question,'tname':vm.q.tname},
                page:page
            }).trigger("reloadGrid");
        }

    }
});