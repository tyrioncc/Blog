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
    var timestamp = Date.parse(new Date());

    if(title == ""){
        alert("请输入标题");
        return;
    }

    var article = {
        title: title,
        content:content,
        description:description,
        createTime:timestamp
    };

    $.ajax({
        type: "POST",
        url: '/home/saveArticle',
        data: JSON.stringify(article),
        success:function (result) {
            console.log(result);
        }
    });
}