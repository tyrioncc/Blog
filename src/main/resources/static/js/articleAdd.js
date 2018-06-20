$(document).ready(function() {
    $("#save").click(function () {
        save();
    });
}
);

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function(e, xhr, options) {
    xhr.setRequestHeader(header, token);
});

function save() {
    var title = $("#articleTitle").val();
    var content = $("#articleText").val();
    var description = $("#articleDes").val();
    var createTime = Date.parse(new Date());

    if(title == ""){
        alert("请输入标题");
        return;
    }

    var article = {
        "title":title,
        "content":content,
        "description":description,
        "createTime":createTime
        }

    $.ajax({
        type: "POST",
        url: '/home/saveArticle',
        dataType:"json",
        data: JSON.stringify(article),
        contentType:"application/json",
        success:function (result) {
            alert("收到响应");
            console.log(result);
        },
        error:function(e) {
        //出错时回调该函数
            alert("error");
            console.log("ERROR : ", e);
        }
    });
}