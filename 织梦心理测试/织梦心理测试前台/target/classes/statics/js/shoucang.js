var vm = new Vue({
    el:'#sc',
    data:{
        test:{},
    },
    methods:{
        getTest:function(){
            $.getJSON("../../mis/mistest/listCollect?uid="+a,function(r){
                vm.test = r.e;
            })
        }
    },
    created:function(){
        this.getTest();
    }
})

$("#submit").click(function(){
    setTimeout(window.location.reload(),1000);
})