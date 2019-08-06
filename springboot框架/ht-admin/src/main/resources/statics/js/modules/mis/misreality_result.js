$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'mis/misreality_result/list',
        datatype: "json",
        colModel: [
            { label: 'ID', name: 'id', index: "id", width: 25, key: true },
            { label: '创建时间', name: 'testtime',index:"testtime", width: 75 },
            { label: '状态', name: 'status', width: 60, formatter: function(value, options, row){
                    return value === 0 ?
                        '<span class="label label-danger">测试中</span>' :
                        '<span class="label label-success">已测试</span>';
                }},
            { label: '成绩', name: 'scoresum',index:"scoresum", width: 75 },
            { label: '用户', name: 'uname',index:"uname", width: 75 },
            { label: '测试', name: 'tname',index:"tname", width: 75 },
            { label: '预存结果', name: 'pname',index:"pname", width: 75 }
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
            tname:null
        },
        showList: true,
        title:null,
        misReality_result:{}
    },
    methods: {
        query: function () {
            vm.reload();
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