package dev.blog.controller;

import dev.blog.service.ArticleService;
import org.jooq.example.db.mysql.tables.records.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
