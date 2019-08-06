$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'mis/misnote/list',
        datatype: "json",
        colModel: [
            { label: 'ID', name: 'id', index: "id", width: 25, key: true },
            { label: '足迹', name: 'footmark',index:"footmark", width: 75 },
            { label: '收藏', name: 'collect',index:"collect", width: 75 },
            { label: '喜欢', name: 'like',index:"like", width: 75 },
            { label: '测试', name: 'tname',index:"tname", width: 75 },
            { label: '用户', name: 'uname',index:"uname", width: 75 }

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
        misNote:{}
    },
    methods: {
        query: function () {
            vm.reload();
        },

        getInfo: function(id){
            $.get(baseURL + "mis/misnote/info/"+id, function(r){
                vm.misNote = r.misNote;
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