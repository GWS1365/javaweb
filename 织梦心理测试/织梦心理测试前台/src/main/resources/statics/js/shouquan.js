function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
        return null;
}

var appId = 'wx1cbbd5d116d2ebd0';
var oauth_url = '/ggg';
var backUrl = "http://www.memoryfile.top:8080/Wx_Login"
var url="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx1cbbd5d116d2ebd0"
//    + "&redirect_uri="+ location.href.split('#')[0]
    + "&redirect_uri="+encodeURIComponent(backUrl)
    + "&response_type=code"
    + "&scope=snsapi_userinfo"
    + "&state=STATE#wechat_redirect";
var code = getUrlParam("code");
if (!code) {
    window.location = url;
 }else{
    var vue = new Vue({
        el:'#workingArea',
        data:{
            beans:[],
        },
        mounted:function(){
                this.get();
        },
        methods:{
            get:function(){
                 axios.get('/ggg?code='+code).then(function(response){
                    vue.beans = response.data;
                 },function(){
                    alert("请求失败");
                 })
            }
        }
    })
}

$(".button2").click(function(){
    window.location.href="../../modules/pro/first2.html";
})
