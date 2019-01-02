//获取菜单
var id=$("#userId").val();
$.ajax({
    type: "post",
    dataType: "json",
    data:{userId:id},
    url: "/getUserMenu",
    success: function (data) {
        if (data.code == 200) {
            //alert(data.data.username);
        	var menus=data.data;
        	var menuUl=$("#menu");
        	menuUl.html("");
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

//判断是否有消息
$.ajax({
    type: "post",
    dataType: "json",
    data:{userId:id},
    url: "/message/getUserMessage",
    success: function (data) {
        if (data.code == 200) {
            var msg=data.data;
            for(var m in msg){
            	if(msg[m].isRead=="0")
            		$("#redSpot").show();
            }
/*        	if(msg!=''){
        		$("#redSpot").show();
        	}else{
        		$("#redSpot").hide();
        	}*/
        }
    },
    error: function (data) {
        alert("服务器出错！");
    }
});



