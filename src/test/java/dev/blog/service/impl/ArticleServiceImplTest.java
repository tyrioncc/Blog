package dev.blog.service.impl;

import dev.blog.service.ArticleService;
import org.jooq.example.db.mysql.tables.records.ArticleRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceImplTest {
    @Autowired
    ArticleService articleService;

    @Test
    public void getArticleTitleById() {
        System.out.println(articleService.getArticleTitleById(1));
    }

    @Test
    public void addArticle() {
        ArticleRecord article = new ArticleRecord();
        article.setTitle("test");
        article.setDescription("");
        article.setContent("test\ncontent");
        article.setCreateTime(new Timestamp(System.currentTimeMillis()));

        try{
            articleService.addArticle(article);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}