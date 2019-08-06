$(function () {
	//jqgrid渲染
    $("#jqGrid").jqGrid({
        url: baseURL + 'mis/misuser/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 40, key: true },
			{ label: '姓名', name: 'name', width: 70 },
			{ label: '昵称', name: 'nickname', width: 70 },
			{ label: '年龄', name: 'age', width: 40 },
			{ label: '性别', name: 'sex',width: 40 },
			{ label: '城市', name: 'city', width: 70 },
			{ label: '国家', name: 'country', width: 70 },
			{ label: '联系号码', name: 'phone', width: 70 },
			{ label: '用户头像', name: 'headimgurl', width: 70 },
			{ label: '授权号', name: 'openid', width: 180 },
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
             name: null,
        },
		showList: true,
		title: null,
		misUser: {
		    nickname:"asdad",
		    age:123,
		    sex:"nan",
		    city:"ASDA",
		    country:"asda",
		    phone:"123",
		    openid:12,
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
			    url: baseURL + 'mis/misuser/list',
			    postData:{'name':vm.q.name},
                page:page,
            }).trigger("reloadGrid");

		},
	}
});