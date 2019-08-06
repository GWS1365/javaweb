function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}

var tid = getUrlParam("tid");
var cid = getUrlParam("cid");
var test = new Vue({
    el:'#test_detail',
    data:{
        title:{},
        questions:[],
        q:{},
        "i":1,
        score:{
            "A":4,
            "B":6,
            "C":8,
            "D":10,
        },
        "val":0,
    },
    methods: {
        getTests: function(){
            $.getJSON("../../mis/misquestion/getQuestion?tid="+tid, function(r){
                test.questions = r.d;
                test.title = r.d[0].tname;
                test.q = test.questions[0];
            });
        },           //修改密码
        getQuestion:function(){
            if(!$('input[name="option_value"]:checked').val()){
                alert('请选择其中一项');
            }else{
                test.val = test.val + parseInt($('input[name="option_value"]:checked').val());
                $('input[name="option_value"]:checked').prop("checked",false);
                test.q = test.questions[test.i];
                test.i++;
                var jslength=0;
                for(var js2 in test.questions){
                   jslength++;
                }
                if(test.i == jslength){
                    $("#submit").text("提交");
                }
                if(test.i>jslength){
                    var qid;
                    if(test.val <=40){
                        qid = 1;
                    }
                    if(test.val <=60 && test.val >40){
                        qid = 2;
                    }
                    if(test.val <=80 && test.val>60){
                        qid = 3;
                    }
                    if(test.val <=100 && test.val>80){
                        qid = 4;
                    }
                    $.getJSON("../../mis/misreality_result/add?scoresum="+test.val+"&tid="+tid+"&status=1&pid="+qid+"&uid="+a, function(r){
                        if(r.msg=="success"){
                             window.location.href="../../modules/pro/test_result.html?tid="+tid+"&cid="+cid+"&pid="+qid;
                             alert("提交成功");

                        }else{
                            alert("提交失败");
                        }
                    })
                 }
            }
        }
    },
    created: function(){
        this.getTests();
    }
});