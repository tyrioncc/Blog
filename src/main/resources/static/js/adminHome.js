function deleteArticle() {

    var r=confirm("确定要删除文章吗？");
    if (r==true)
    {
        alert("删除成功！");
        return true;
    }
    else
    {
        return false;
    }
}