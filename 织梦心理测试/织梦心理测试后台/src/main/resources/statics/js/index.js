
//iframe自适应
$(window).on('resize', function() {
	var $content = $('.content');
	$content.height($(this).height() - 120);
	$content.find('iframe').each(function() {
		$(this).height($content.height());
	});
}).resize();



//使用vue
var vm = new Vue({
	el:'#rrapp',
	data:{
		user:{},

		main:"main.html",
		password:'',
		newPassword:'',
        navTitle:"控制台"
	},
	methods: {

		getUser: function(){
			$.getJSON("sys/user/info?_"+$.now(), function(r){
				vm.user = r.user;
			});
		},
		//修改密码
		updatePassword: function(){
			layer.open({
				type: 1,
				skin: 'layui-layer-molv',
				title: "修改密码",
				area: ['550px', '270px'],
				shadeClose: false,
				content: jQuery("#passwordLayer"),
				btn: ['修改','取消'],
				btn1: function (index) {
					var data = "password="+vm.password+"&newPassword="+vm.newPassword;
					$.ajax({
						type: "POST",
					    url: "sys/user/password",
					    data: data,
					    dataType: "json",
					    success: function(result){
							if(result.code == 0){
								layer.close(index);
								layer.alert('修改成功', function(index){
									location.reload();
								});
							}else{
								layer.alert(result.msg);
							}
						}
					});
	            }
			});
		}
	},
	created: function(){

		this.getUser();
	},
	updated: function(){
		var router = new Router();
		routerList(router);
		router.start();
	}
});


//
function routerList(router){
    $(".treeview-menu li a").each(function(){
        router.add($(this).attr("href"), function() {
        	//console.log(this);
            var url = window.location.hash;
			//console.log(url);
            //替换iframe的url
			//console.log(url.replace('#', ''));

           // http://127.0.0.1:8080/index.html#/modules/sys/user.html
            //http://127.0.0.1:8080/modules/sys/user.html


			//iframe路径
            vm.main = url.replace('#', '');

            //导航菜单展开
            $(".treeview-menu li").removeClass("active");
            $("a[href='"+url+"']").parents("li").addClass("active");

            vm.navTitle = $("a[href='"+url+"']").text();

        })


    })

}
