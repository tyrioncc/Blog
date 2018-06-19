package dev.blog.controller;

import dev.blog.service.ArticleService;
import org.apache.logging.log4j.MarkerManager;
import org.jooq.example.db.mysql.tables.records.Article;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@Controller
public class ArticleController {



    @Autowired
    ArticleService articleService;

    @RequestMapping("/article/{id}")
    public String Article(Model model, @PathVariable int id){
        Article article = articleService.getArticleById(id);
        model.addAttribute("article", article);
        return "blog/article";
    }

    @RequestMapping("/home/articleAdd")
    public String ArticleAdd(Model model){
        return "/admin/article/articleAdd";
    }

    @RequestMapping(value = "/home/saveArticle", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject SaveArticle(Model model, @RequestBody JSONObject info){
        JSONObject jsonObject = new JSONObject();

        try {
            Article article = new Article();
            article.setTitle(info.getString("title"));
            article.setDescription(info.getString("description"));
            article.setCreateTime(Timestamp.valueOf(info.getString("createTime")));
            article.setContent(info.getString("content"));

            articleService.addArticle(article);

            jsonObject.put("message", "保存成功");
            jsonObject.put("status", "success");
        }
        catch (Exception e){
            jsonObject.put("message", e.getMessage());
            jsonObject.put("status", "error");

        }
        return jsonObject;
    }
}
