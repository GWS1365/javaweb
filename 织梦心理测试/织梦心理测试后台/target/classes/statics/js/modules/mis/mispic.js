var id = 1;
var cname = ['性格', '情感', '职场', '健康', '人际', '亲子', '能力', '趣味H5'];
var number = [0, 0, 0, 0, 0, 0, 0, 0];
var vue = new Vue({
    el: '#box',
    data: {
        test: [],

    },
    mounted: function () {
        this.get();
    },
    methods: {
        get: function () {
            axios.get('../../mis/mistest/list10').then(function (response) {
                vue.test = response.data.misTest;
                for (i = 0; i < cname.length; i++) {
                    for (j = 0; j < vue.test.length; j++) {
                        if (cname[i] == (vue.test[j].cname)) {
                            console.log(vue.test[j].testnumber);
                            number[i] += vue.test[j].testnumber;
                        }
                    }
                }
                //第一个
                var dom = document.getElementById("container");

// 基于准备好的dom，初始化echarts实例
                var myChart = echarts.init(dom);
// var app = {};
                option = null;
// app.title = '嵌套环形图';

// 指定图表的配置项和数据
                option = {
                    title: {
                        text: '各分类访问情况',
                        subtext: '虚构数据',
                        left: 'center'
                    },
                    // 气泡提示框（鼠标悬浮时出现）
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b}: {c} ({d}%)"
                    },

                    // 图例，表述数据和图形的关联
                    legend: {
                        orient: 'vertical',
                        x: 'left',
                        data: ['性格', '情感', '职场', '健康', '人际', '亲子', '能力', '趣味H5']
                    },

                    //数据系列，一个图表可能包含多个系列，每一个系列可能包含多个数据
                    series: [
                        {
                            name: '分类',
                            type: 'pie',
                            selectedMode: 'single',//选中模式，表示是否支持多个选中，默认关闭，支持布尔值和字符串，字符串取值可选'single'，'multiple'，分别表示单选还是多选。
                            radius: [0, '30%'],//半径，支持绝对值（px）和百分比，百分比计算比，min(width, height) / 2 * 75%， 传数组实现环形图，[内半径，外半径]

                            label: {
                                normal: {
                                    position: 'inner'//饼图扇区内部 'inner' 同 'inside'
                                }
                            },
                            labelLine: {
                                normal: {
                                    show: false//是否显示视觉引导线
                                }
                            },
                            data: [      //待传值
                                {value: number[0]+number[1]+number[2]+number[3]+number[4]+number[5]+number[6]+number[7], name: '总测试人数'},//单个数据项
                            ]
                        },
                        {
                            name: '具体分类',
                            type: 'pie',
                            radius: ['40%', '55%'],
                            label: {
                                normal: {
                                    //标签内容格式器，支持字符串模板和回调函数两种形式，字符串模板与回调函数返回的字符串均支持用 \n 换行 :{a}：系列名  {b}：数据名  {c}：数据值
                                    formatter: '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}  ',
                                    backgroundColor: '#eee',
                                    borderColor: '#aaa',
                                    borderWidth: 1,
                                    borderRadius: 4,
                                    shadowBlur: 3,
                                    shadowOffsetX: 2,
                                    shadowOffsetY: 2,
                                    shadowColor: '#999',
                                    padding: [0, 7],
                                    rich: {//可以自定义富文本样式。利用富文本样式，可以在标签中做出非常丰富的效果
                                        a: {//系列名
                                            color: '#999',
                                            lineHeight: 22,
                                            align: 'center'
                                        },
                                        hr: {//标签里面的线
                                            borderColor: '#aaa',
                                            width: '100%',
                                            borderWidth: 0.5,
                                            height: 0
                                        },
                                        b: {//数据名
                                            fontSize: 16,
                                            lineHeight: 33
                                        },
                                        per: {//%分数的背景框
                                            color: '#eee',
                                            backgroundColor: '#334455',
                                            padding: [2, 4],
                                            borderRadius: 2
                                        }
                                    }
                                }
                            },
                            data: [      //待传值
                                {value: number[0], name: '性格'},
                                {value: number[1], name: '情感'},
                                {value: number[2], name: '职场'},
                                {value: number[3], name: '健康'},
                                {value: number[4], name: '人际'},
                                {value: number[5], name: '亲子'},
                                {value: number[6], name: '能力'},
                                {value: number[7], name: '趣味H5'}
                            ]
                        }
                    ]
                };
                if (option && typeof option === "object") {
                    myChart.setOption(option, true);//使用  setOption 方法生成一个饼图
                }
            })
        },
        geic() {
            //第二个

            var dom = document.getElementById("container1");
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(dom);
            // var app = {};
            option = null;
            option = {
                title: {
                    text: '某分类题目具体测试情况',
                    subtext: '虚构数据',
                    left: 'center'
                },
                xAxis: {
                    type: 'category',
                    data: [cname[0], cname[1],cname[2],cname[3], cname[4], cname[5],cname[6],cname[7]]
                },
                yAxis: {
                    type: 'value'
                },
                series: [{      //待传值
                    data: [number[0], number[1], number[2],number[3], number[4], number[5], number[6], number[7]],
                    type: 'bar'
                }]
            };

            if (option && typeof option === "object") {
                myChart.setOption(option, true);
            }
        }
    }
});










