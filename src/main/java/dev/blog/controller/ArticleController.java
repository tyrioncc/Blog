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
import java.util.List;
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
    public String ArticleAdd(){
        return "admin/article/articleAdd";
    }

    @RequestMapping(value = "/home/articleEdit")
    public String ArticleEdit(Model model, @RequestParam("id") int id){
        ArticleRecord article = articleService.getArticleById(id);
        model.addAttribute("article", article);
        return "admin/article/articleEdit";
    }

    @RequestMapping(value = "/home/articleDelete")
    public String ArticleDelete(Model model, @RequestParam("id") int id){
        articleService.deleteArticleById(id);
        List<ArticleRecord> list = articleService.getAvaliableArticleList(0, Integer.MAX_VALUE);
        model.addAttribute("articleList", list);
        return "admin/home";
    }

    @RequestMapping(value = "home/add", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String Add(@RequestBody Map<String,String> map){
        //System.out.println(map.get("title"));
        //System.out.println(map.get("content"));

        String s;
        try {
            ArticleRecord article = new ArticleRecord();
            article.setTitle(map.get("title"));
            article.setDescription(map.get("description"));
            article.setUpdateTime(Timestamp.valueOf(map.get("updateTime")));
            article.setCreateTime(Timestamp.valueOf(map.get("updateTime")));
            article.setContent(map.get("content"));
            articleService.addArticle(article);
            System.out.println("articleService.addArticle(article);");
            s = "{\"message\":\"add success\"}";
        }
        catch (Exception e){
           e.printStackTrace();
           s = "{\"message\":\"" + e.getMessage() + "\"}";
        }
        return s;
    }

    @RequestMapping(value = "home/save", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String Save(@RequestBody Map<String,String> map){
        //System.out.println(map.get("title"));
        //System.out.println(map.get("content"));
        String s;
        try {
            ArticleRecord article = new ArticleRecord();
            article.setTitle(map.get("title"));
            article.setDescription(map.get("description"));
            article.setUpdateTime(Timestamp.valueOf(map.get("updateTime")));
            article.setContent(map.get("content"));
            int id = Integer.valueOf(map.get("id"));
            articleService.saveArticleById(article, id);
            System.out.println("articleService.saveArticle(article);");
            s = "{\"message\":\"save success\"}";
        }
        catch (Exception e){
            e.printStackTrace();
            s = "{\"message\":\"" + e.getMessage() + "\"}";
        }
        return s;
    }
}
