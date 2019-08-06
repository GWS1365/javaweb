var Search = new Vue({
    el:'#searchlist',
    data:{
        SList:[],
        show1:false,
    },
    methods:{
        post:function () {
            axios.post('../../mis/mistest/list1',{title:vue.searchVal}).then(function (response) {
                Search.SList=response.data.misTest;
            })
        }
    }
})

var vue = new Vue({
    el:'#ssr',
    data:{
        //搜索展示数据
        searchVal:'',
    },
    methods:{
        search1(){
            Search.post();
            if(this.searchVal==''){
                JX.show=true;
                Search.show1=false;
            }else {
                JX.show = false;
                Search.show1 = true;
            }
        },
    }
})

var JX = new Vue({
    el:'#jingxuan',
    data:{
        JXTest:[],
        show:true,
    },
    mounted:function () {
        this.get();
    },
    methods:{
        get:function () {
            axios.get('../../mis/mistest/listAll?t=testnumber&y=desc&u=4').then(function (response) {
                JX.JXTest = response.data.c;
            })
        }
    }
})