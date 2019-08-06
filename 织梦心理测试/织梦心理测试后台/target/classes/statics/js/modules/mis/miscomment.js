$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'mis/miscomment/list',
        datatype: "json",
        colModel: [
            { label: 'ID', name: 'id', index: "id", width: 25, key: true },
            { label: '创建时间', name: 'createtime',index:"createtime", width: 75 },
            { label: '内容', name: 'content',index:"content", width: 75 },
            { label: '易懂性', name: 'testunderstand',index:"testunderstand", width: 75 },
            { label: '准确性', name: 'testexact',index:"testexact", width: 75 },
            { label: '实用性', name: 'testpractical',index:"testpractical", width: 75 },
            { label: '用户', name: 'uname',index:"uname", width: 75 },
            { label: '测试', name: 'tname',index:"tname", width: 75 }
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
            uname: null,
            tname: null
        },
        showList: true,
        title:null,
        misComment:{}
    },
    methods: {
        query: function () {
            vm.reload();
        },

        getInfo: function(id){
            $.get(baseURL + "mis/miscomment/info/"+id, function(r){
                vm.misComment = r.misComment;
            });
        },

        reload: function () {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'uname': vm.q.uname,'tname':vm.q.tname},
                page:page
            }).trigger("reloadGrid");
        }

    }
});