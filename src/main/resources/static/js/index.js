//获取菜单
$.ajax({
    type: "post",
    dataType: "json",
    data:{userId:1},
    url: "/getUserMenu",
    success: function (data) {
        if (data.code == 200) {
            //alert(data.data.username);
        	var menus=data.data;
        	var menuUl=$("#menu");
        	//menuUl.html("helll");
        	//第一层
        	for(var i in menus){
        		if(menus[i].menuLevel=='1'){
        			//menuUl.html("1");
        			menuUl.append("<li class=\"layui-nav-item\">" +
        					"<a href=\"javascript:;\">"+menus[i].name+"</a>" +
        							"<dl id='menu"+menus[i].id+"' class=\"layui-nav-child\">" +
        									"</dl></li>");
        		}
        	}
        	for(var i in menus){
        		if(menus[i].menuLevel=='2'){
        			//alert(menus[i].name);
        			$("#menu"+menus[i].pid).append("<dd><a href=\"javascript:;\" onclick=\"changeMenu('"+menus[i].uri+"')\">"+menus[i].name+"</a></dd>");
        		}
        	}
        	
        }
    },
    error: function (data) {
        alert("服务器出错！");
    }
});

/*<li class="layui-nav-item layui-nav-itemed">
<a class="layui-nav-item" href="javascript:;">项目</a>
<dl class="layui-nav-child">
  <dd><a href="javascript:;">项目列表</a></dd>
  <dd><a href="javascript:;" onclick="changeMenu('/welcome')">我的项目</a></dd>
</dl>
</li>
<li class="layui-nav-item"><a href="#">通知</a>
	 <dl class="layui-nav-child">
  	<dd><a href="javascript:;" onclick="changeMenu('/message')">我的消息</a></dd>
	 </dl>
</li>*/