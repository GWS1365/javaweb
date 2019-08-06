//重置表单
function resetForm(elem) {
    $(elem).parents('form')[0].reset();
}
//格式化时间
function formatDate(date,format) {
    if(date == null){
        return '';
    }
    if(!window.moment){
        throw new Error('请确保引用了moment.js！');
    }
    var f = format || ('YYYY-MM-DD HH:mm:ss');
    return window.moment(date).format(f);
}
//定义一个匿名函数并执行，传递的参数是jQuery对象
(function ($) {
    $.fn.serializeObject = function () {
        var obj = {};
        var arr = this.serializeArray();
        $.each(arr,function () {
            if(obj[this.name] !== undefined){
                if((obj[this.name] instanceof Array) == false ){
                    obj[this.name]=[obj[this.name]];
                }
                obj[this.name].push(this.value || '');
            }else{
                obj[this.name]=this.value || '';
            }
        });
        return obj;
    };
})(jQuery);

$(window).load(function(){
           if($(".uName").text() != ""){
               $("#log").addClass("login");
            }else{
               $("#log").removeClass("login");
            }
 });

