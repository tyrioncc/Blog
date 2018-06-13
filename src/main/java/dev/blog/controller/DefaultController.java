package dev.blog.controller;

import dev.blog.dao.Page;
import dev.blog.service.ArticleService;
import org.jooq.example.db.mysql.tables.records.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
        List<Article> list = articleService.getAvaliableArticleList(0, Page.itemNumPerPage);
        Page page = new Page(1, articleService.getArticleNum());
        model.addAttribute("articleList", list);
        model.addAttribute("page", page);
        return "blog/index";
    }

    @RequestMapping("/article/{id}")
    public String article(Model model, @PathVariable int id){
        Article article = articleService.getArticleById(id);
        model.addAttribute("article", article);
        return "blog/article";
    }

    @RequestMapping("/page/{pageNum}")
    public String page(Model model, @PathVariable int pageNum){
        List<Article> list = articleService.getAvaliableArticleList((pageNum - 1) * Page.itemNumPerPage, Page.itemNumPerPage);
        Page page = new Page(pageNum, articleService.getArticleNum());
        model.addAttribute("articleList", list);
        model.addAttribute("page", page);
        return "blog/index";
    }

    @RequestMapping("/home")
    public String admin(Model model){
        return "admin/starter";
    }
}