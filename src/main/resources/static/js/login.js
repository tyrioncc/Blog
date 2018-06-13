$("input").keydown(function(e){
    if (e.keyCode==13) {
        $("form").submit();
    }
});

function loginSubmit(){

    var username = $("#username").val();
    var password = $("#password").val();
    if (username.length > 0 && password.length > 0) {
        $.ajax({
            type: "POST",
            url: '/login/auth',
            data: {username: username, password: password},
            success: function (data) {///去更新cookies
                if (data.resultCode == "success") {
                    window.location.href = "/admin/articleList";
                }else{
                    layer.alert('账号或者密码错误', {
                        icon: 2,
                    });
                    return;
                }
            }
        });
    } else {
        layer.alert('账号或者密码不能为空', {
            icon: 2,
        })
    }
}