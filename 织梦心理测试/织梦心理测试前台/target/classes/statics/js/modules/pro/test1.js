$(function(){
    vue.get();
    vue.gettest();
    vue.gettoast();
    vue.getcomment();
})

var temp = 0;
var vue = new Vue({
    el: '#total_test',
    data: {
        msg: 'hello',
        subject: {
            //测试内容
            test: [],
            //评论
            evaluates: [],
            //相关推荐
            recommend: [],
            toast:[]
        },
    },
    mounted: function () {
    },
    methods: {
        get: function () {
            axios.get('../../mis/mistest/info/' + id).then(function (response) {
                vue.subject.test = response.data.misTest;
                vue.img = b;
            })
        },
        getcomment: function () {
            axios.get('../../mis/miscomment/info1/' + id).then(function (response) {
                vue.subject.evaluates = response.data.misComment;
                var understand=0;
                var exact=0;
                var practical=0;
                for (i = 0; i < vue.subject.evaluates.length; i++) {
                    understand += vue.subject.evaluates[i].testunderstand;
                    exact += vue.subject.evaluates[i].testexact;
                    practical += vue.subject.evaluates[i].testpractical;
                }
                if(understand==0||exact==0||practical==0){
                    understand=0;
                    exact=0;
                    practical=0;
                }else {
                    understand = understand / vue.subject.evaluates.length * 0.2;
                    exact = exact / vue.subject.evaluates.length * 0.2;
                    practical = practical / vue.subject.evaluates.length * 0.2;
                }
                var options = [
                    {
                        series: [{
                            type: 'liquidFill',
                            data: [understand,     //待传值
                                0.5,
                                0.4,
                                0.3],
                            radius: '90%',
                            itemStyle: {
                                shadowBlur: 0
                            },
                            backgroundStyle: {
                                borderWidth: 2,
                                borderColor: '#156ACF'
                            },
                            outline: {
                                show: false
                            },
                            label: {
                                shadowBlur: 0,
                                position: ['50%', '45%']
                            },
                            shape: 'pin',
                            center: ['50%', '40%']
                        }]
                    },
                    {
                        series: [{
                            type: 'liquidFill',
                            data: [exact,     //待传值
                                0.5,
                                0.4,
                                0.3],
                            radius: '90%',
                            itemStyle: {
                                shadowBlur: 0
                            },
                            backgroundStyle: {
                                borderWidth: 2,
                                borderColor: '#156ACF'
                            },
                            outline: {
                                show: false
                            },
                            label: {
                                shadowBlur: 0,
                                position: ['50%', '45%']
                            },
                            shape: 'pin',
                            center: ['50%', '40%']
                        }]
                    },
                    {
                        series: [{
                            type: 'liquidFill',
                            data: [practical,     //待传值
                                0.5,
                                0.4,
                                0.3],
                            radius: '90%',
                            itemStyle: {
                                shadowBlur: 0
                            },
                            backgroundStyle: {
                                borderWidth: 2,
                                borderColor: '#156ACF'
                            },
                            outline: {
                                show: false
                            },
                            label: {
                                shadowBlur: 0,
                                position: ['50%', '45%']
                            },
                            shape: 'pin',
                            center: ['50%', '40%']
                        }]
                    }
                ];
                for (var i = 0; i < options.length; ++i) {
                    var chart = echarts.init(containers[i]);

                    if (i > 0) {
                        options[i].series[0].silent = true;
                    }
                    chart.setOption(options[i]);
                    chart.setOption({
                        baseOption: options[i],
                        media: [{
                            query: {
                                maxWidth: 300
                            },
                            option: {
                                series: [{
                                    label: {
                                        fontSize: 26
                                    }
                                }]
                            }
                        }]
                    });
                    charts.push(chart);
                }
            })
        },
        gettest: function () {
            axios.get('../../mis/mistest/info1/' + cid).then(function (response) {
                vue.subject.recommend = response.data.misTest;
            })
        },
        gettoast:function(){
            var uid = this.uid;
            axios.get('../../mis/misnote/info1/'+a).then(function (response) {
                vue.subject.toast = response.data.misNote;
            })
        },
        post:function(){
            var uid = this.uid;
            axios.post('../../mis/misnote/add?tid='+id+'&uid='+a+'&collect=1').then(function (response) {
          })
        },
        postbuy:function(){
            var uid = this.uid;
            axios.post('../../mis/misorder/add?tid='+id+'&uid='+a).then(function (response) {
            })
        },
        buy(){
            this.postbuy();
            Toast("支付成功", 500);
        },
        toast(){
            var j = 0;
            for(i=0;i<vue.subject.toast.length;i++){
                if(id==vue.subject.toast[i].tid){
                    j=1;
                }
            }
            if(j==0){
                this.post();
                Toast("收藏成功", 500);
               setTimeout(window.location.reload(),1000);
            }else{
                Toast("已收藏", 500);
            }
        }
    },

});
//用户评价
var charts = [];
var containers = document.getElementsByClassName('chart');

window.onresize = function () {
    for (var i = 0; i < charts.length; ++i) {
        charts[i].resize();//对浏览器窗口调整大小进行计数：
    }
};







