package dev.blog.controller;

import dev.blog.service.ArticleService;
import org.jooq.example.db.mysql.tables.records.Article;
import org.jooq.tools.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.net.URLEncoder;

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

    @RequestMapping(value = "/home/saveArticle", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public JSONObject SaveArticle(Model model, @RequestBody Article article){
        JSONObject jsonObject = new JSONObject();

        try {
            articleService.saveArticle(article);

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