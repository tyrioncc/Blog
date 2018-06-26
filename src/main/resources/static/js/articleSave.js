$(document).ready(function() {
    $("#save").click(function () {
        saveButton();
    });
    $("#saveAndExit").click(function () {
        saveAndExit();
    });
}
);

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function(e, xhr, options) {
    xhr.setRequestHeader(header, token);
});

function saveButton() {
    var id = $("#articleId").val();
    var title = $("#articleTitle").val();
    var content = $("#articleText").val();
    var description = $("#articleDes").val();
    var d = new Date()
    var updateTime = [d.getFullYear(), d.getMonth()+1,d.getDate()].join('-')+' '+
            [d.getHours(),d.getMinutes(), d.getSeconds()].join(':');

    if(title == ""){
        alert("请输入标题");
        return;
    }

    var article = {
        "title":title,
        "content":content,
        "description":description,
        "updateTime":updateTime
    };

    //console.log(article);
    //console.log(JSON.stringify(article));

    if (id !== -1) {
        saveAndAdd(article);
    }
    else{

    }
}

function saveAndAdd(article, select) {
    $.ajax({
        type: "POST",
        url: "/home/saveArticle",
        data: JSON.stringify(article),
        dataType:"JSON",
        contentType: "application/json",
        success:function (result) {
            alert("保存成功");
            //console.log(result);
        },
        error:function(e) {
            //出错时回调该函数
            alert("出错了");
            //console.log("ERROR : ", e);
        }
    });
}
