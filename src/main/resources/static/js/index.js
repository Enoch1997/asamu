$.ajax({
    type: "post",
    dataType: "json",
    data:{userId:1},
    url: "/getUserMenu",
    success: function (data) {
        if (data.code == 200) {
            //alert(data.data.username);
        }
    },
    error: function (data) {
        alert("服务器出错！");
    }
});