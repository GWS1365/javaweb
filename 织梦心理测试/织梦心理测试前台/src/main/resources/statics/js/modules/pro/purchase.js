function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}
var tid = getUrlParam("tid");
var cid = getUrlParam("cid");

function back() {location.href="../../modules/pro/test1.html?id="+tid+"&cid="+cid;}

function go() {location.href="../../modules/pro/detail.html?tid="+tid+"&cid="+cid;}

axios.get("../../mis/misreality_result/add?scoresum=0&tid="+tid+"&status=0&pid=1&uid="+a).then(function (r) {})

