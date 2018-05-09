package dev.blog.controller;

import dev.blog.service.ArticleService;
import org.jooq.example.db.mysql.tables.records.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 首页入口controller
 *
 */
@Controller
public class DefaultController {

    @Autowired
    ArticleService articleService;

    @RequestMapping("/")
    public String home(Model model){
        List<Article> list = articleService.getArticleList(0, 6);
        model.addAttribute("articleList", list);
        return "blog/index";
    }

    @RequestMapping("/article/{id}")
    public String article(Model model, @PathVariable int id){
        Article article = articleService.getArticleById(id);
        model.addAttribute("article", article);
        return "blog/article";
    }
}
