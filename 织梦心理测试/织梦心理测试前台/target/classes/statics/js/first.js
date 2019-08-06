var remai = new Vue({
    el: "#remai1",
    data: {
        tests:[],
    },
    methods: {
        getTest: function(){
            $.getJSON("../../mis/mistest/listAll?t=testnumber&y=desc&u=3", function(r){
                remai.tests = r.c;
            });
        }
    },
    created: function(){
        this.getTest();
    }
})

//精选测评
var jingxuan = new Vue({
    el: "#jingxuan",
    data: {
        tests1:[],
    },
    methods: {
        getTests: function(){
            $.getJSON("../../mis/mistest/listAll?t=testnumber&y=desc&u=11", function(r){
                jingxuan.tests1 = r.c;
            });
        }                  //修改密码
    },
    created: function(){
        this.getTests();
    }
});

function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
        return null;
}




