var vm = new Vue({
    el:'#sc',
    data:{
        test:{},
    },
    methods:{
        getTest:function(){
            $.getJSON("../../mis/mistest/getTestBut?uid="+a,function(r){
                vm.test = r.j;
            })
         }
     },
    created:function(){
        this.getTest();
    }

})
