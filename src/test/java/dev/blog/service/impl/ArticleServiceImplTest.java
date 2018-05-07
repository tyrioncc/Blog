package dev.blog.service.impl;

import dev.blog.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceImplTest {
    @Autowired
    ArticleService articleService;

    @Test
    public void getArticleTitleById() {
        System.out.println(articleService.getArticleTitleById(1));
    }
}