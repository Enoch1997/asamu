var id=$("#userId").val();

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

//改变菜单跳转
window.onhashchange = function(){
    var hash = location.hash;
    hash = hash.substring(1,hash.length);
    $("#mainFrame").attr("src", hash);
}
function changeMenu(url){
	var u = window.location.href;
	var end = u.indexOf("#");
	var rurl = u.substring(0,end);
  	//设置新的锚点
  	window.location.href = rurl + "#" + url;
	//$("#mainFrame").attr("src",url);
}

document.addEventListener('DOMContentLoaded', function () {
     var hash = location.hash;
     var url = hash.substring(1,hash.length);
     if(url==='')
    	 url='/welcome';
     $("#mainFrame").attr("src", url);
}, false);


