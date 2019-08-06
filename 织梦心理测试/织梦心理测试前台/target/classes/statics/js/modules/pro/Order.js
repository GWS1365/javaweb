var order = new Vue({
    el:'#card',
    data:{
        orders:[]
    },
    mounted:function () {
        this.get();
    },
    methods:{
        get:function () {
            axios.get('../../mis/misorder/listAll/'+a).then(function (response) {
                order.orders=response.data.misOrder;
            })
        }
    }
});