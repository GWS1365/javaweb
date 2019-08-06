var vm = new Vue({
    el:"#wode",
    data:{
        user:{},
    },
    methods:{
        getUser:function(){
            $.getJSON("../../../sys/user/info", function(r){
                vm.user = r.user;
            })
        }
    },
    created: function(){
        this.getUser();
    }
})