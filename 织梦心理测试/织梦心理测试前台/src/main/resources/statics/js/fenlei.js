function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}
var cid = getUrlParam("cid");
var fen3 = new Vue({
    el: "#daohang",
    data: {
        categories:[],
    },
     mounted:function(){
          this.get();
     },
     methods:{
         get:function(){
            axios.get('../../mis/miscategory/list').then(function(response){
                 fen3.categories = response.data.page.list;
            })
         }
     }
})

var a = new Vue({
    el: "#fenlei",
    data: {
        tests:[],
    },
     mounted:function(){
          this.getTest();
     },
     methods:{
         getTest:function(){
            if(cid != null){
                axios.get('../../mis/mistest/getTestByCid/'+cid).then(function(response){
                     a.tests = response.data.b;
                })
            }else{
                axios.get('../../mis/mistest/getTests').then(function(response){
                     a.tests = response.data.h;
                })
            }
         },
     }
})
