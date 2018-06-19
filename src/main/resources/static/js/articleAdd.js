$(document).ready(function() {
    $("#save").click(save());
}
);

function save() {
    console.log("save article");
 ;   var title = $("#articleTitle").val();
    var content = $("#articleText").val();
    var description = $("#articleDes").val();

    if(title == ""){
        alert("请输入标题");
        return;
    }

    var article = {
        title: title,
        content:content,
        description:description
    };

    $.ajax({
        type: "POST",
        url: '/home/saveArticle',
        data: JSON.stringify(article),
        dataType:'json',
        contentType:'application/json;charset=UTF-8',
        success:function (result) {
            alert("保存成功");
            console.log(result);
        },
        error:function (result) {
            alert("出错啦");
            console.log(result);
        }
    });
}