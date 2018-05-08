package dev.blog.controller;

import dev.blog.service.ArticleService;
import org.jooq.example.db.mysql.tables.records.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
