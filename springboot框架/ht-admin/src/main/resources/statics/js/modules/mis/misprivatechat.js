$(function () {
	//jqgrid渲染
    $("#jqGrid").jqGrid({
        url: baseURL + 'mis/misprivatechat/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 20, key: true },
			{ label: '姓名', name: 'uname', width: 35 },
			{ label: '联系方式', name: 'contact', width: 60 },
			{ label: '私信内容', name: 'content', width: 500 },
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",   //分页div
         //PageUtils分页
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
        },
		showList: true,
		title: null,
		misprivatechat: {

		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
			    url: baseURL + 'mis/misprivatechat/list',
			    postData:{'uname':vm.q.uame},
                page:page,
            }).trigger("reloadGrid");

		},
	}
});