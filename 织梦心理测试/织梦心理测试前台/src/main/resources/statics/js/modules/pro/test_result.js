function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}
var tid = getUrlParam("tid");
var cid = getUrlParam("cid");
var pid = getUrlParam("pid");
var vue = new Vue({
    el:'#test_result_div',
    data:{
        result:{
            //相关推荐
            recommend:[],
            //结果
            results:[],
        }
    },
    mounted:function () {
        this.getcomment();
        this.getresults();
    },
    methods:{
        getcomment:function () {
            axios.get('../../mis/mistest/info1/' + cid).then(function (response) {
                vue.result.recommend = response.data.misTest;
            })
        },
        getresults:function () {
            axios.get('../../mis/misreality_result/infoResult/'+a+'/'+pid+'/'+tid).then(function (response) {
                vue.result.results=response.data.misResult;
            })
        }
    }
});