package dev.blog.controller;

import dev.blog.service.ArticleService;

import org.jooq.example.db.mysql.tables.Article;
import org.jooq.example.db.mysql.tables.records.ArticleRecord;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Map;


@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping("/article/{id}")
    public String Article(Model model, @PathVariable int id){
        ArticleRecord article = articleService.getArticleById(id);
        model.addAttribute("article", article);
        return "blog/article";
    }

    @RequestMapping("/home/articleAdd")
    public String ArticleAdd(Model model){
        return "admin/article/articleAdd";
    }

    @RequestMapping(value = "home/saveArticle", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String SaveArticle(@RequestBody Map<String,String> map){
        //System.out.println(map.get("title"));
        //System.out.println(map.get("content"));

        String s;
        try {
            ArticleRecord article = new ArticleRecord();
            article.setTitle(map.get("title"));
            article.setDescription(map.get("description"));
            article.setCreateTime(Timestamp.valueOf(map.get("createTime")));
            article.setContent(map.get("content"));
            articleService.addArticle(article);
            System.out.println("articleService.addArticle(article);");
            s = "{\"message\":\"success\"}";
        }
        catch (Exception e){
           e.printStackTrace();
           s = "{\"message\":\"" + e.getMessage() + "\"}";
        }
        return s;
    }
}
