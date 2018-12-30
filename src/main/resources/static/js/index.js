$.ajax({
    type: "post",
    dataType: "json",
    data:{userId:1},
    url: "/getUserMenu",
    success: function (data) {
        if (data.code == 200) {
            alert(data.data.username);
        }else{
            alert("保存失败！"+data.msg);
        }
    },
    error: function (data) {
        alert("服务器出错！");
    }
});