$(document).ready(function() {
    $("#save").click(function () {
        saveButton(select="n");
    });
    $("#saveAndExit").click(function () {
        saveButton(select="r");
    });
}
);


var id = $("#articleId").val();

function saveButton(select) {
    var title = $("#articleTitle").val();
    var content = $("#articleText").val();
    var description = $("#articleDes").val();
    var d = new Date();
    var updateTime = [d.getFullYear(), d.getMonth()+1,d.getDate()].join('-')+' '+
            [d.getHours(),d.getMinutes(), d.getSeconds()].join(':');

    if(title == ""){
        alert("请输入标题");
        return;
    }

    var article = {
        "id":id,
        "title":title,
        "content":content,
        "description":description,
        "updateTime":updateTime
    };

    //console.log(article);
    //console.log(JSON.stringify(article));
    //console.log(id);
    if (id > 0) {
        save(article, select);
    }
    else{
        saveAndAdd(article, select);
    }
}

function saveAndAdd(article, select) {
    $.ajax({
        type: "POST",
        url: "/home/add",
        data: JSON.stringify(article),
        dataType:"JSON",
        contentType: "application/json",
        success:function (result) {
            alert("保存成功");
            //console.log(result);
            if(select === "r"){
                window.location.href="/home";
            }
            else{
                id = result.id;
            }
        },
        error:function(e) {
            //出错时回调该函数
            alert("出错了");
            //console.log("ERROR : ", e);
        }
    });
}

function save(article, select) {
    $.ajax({
        type: "POST",
        url: "/home/save",
        data: JSON.stringify(article),
        dataType:"JSON",
        contentType: "application/json",
        success:function (result) {
            alert("保存成功");
            //console.log(result);
            if(select === "r"){
                window.location.href="/home";
            }
        },
        error:function(e) {
            //出错时回调该函数
            alert("出错了");
            //console.log("ERROR : ", e);
        }
    });
}
