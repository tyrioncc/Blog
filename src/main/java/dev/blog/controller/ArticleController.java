package dev.blog.controller;

import dev.blog.service.ArticleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jooq.example.db.mysql.tables.records.ArticleRecord;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@Controller
public class ArticleController {
    Logger logger = LogManager.getLogger();

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
        return "/admin/article/articleAdd";
    }

    @RequestMapping(value = "/home/saveArticle", method = RequestMethod.POST, consumes="application/json")
    @ResponseBody
    public String SaveArticle(@RequestBody JSONObject info){
        logger.debug("SaveArticle");
        logger.debug(info);
        String s;
        try {
            ArticleRecord article = new ArticleRecord();
            article.setTitle(info.getString("title"));
            article.setDescription(info.getString("description"));
            article.setCreateTime(Timestamp.valueOf(info.getString("createTime")));
            article.setContent(info.getString("content"));
            articleService.addArticle(article);

            System.out.println("System.out.println");

            s = "{" +
                    "\"message\":\"请求成功\"" +
                    "}";
        }
        catch (Exception e){
           s = "{" +
                    "\"message\":\"" + e.getMessage() + "\"," +
                    "\"cause\":\"" + e.getCause() + "\"" +
            "}";
           e.printStackTrace();
        }
        return s;
    }
}
