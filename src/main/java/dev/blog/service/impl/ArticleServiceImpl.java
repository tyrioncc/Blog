package dev.blog.service.impl;

import dev.blog.dao.Article;
import dev.blog.service.ArticleService;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.jooq.example.db.mysql.tables.Article.ARTICLE;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    private final DSLContext create;

    @Autowired
    public ArticleServiceImpl(DSLContext create){
        this.create = create;
    }

    public String getArticleTitleById(int id){
        Record1<String> result = create.select(ARTICLE.TITLE).from(ARTICLE).where(ARTICLE.ID.eq(id)).fetchOne();
        return result.value1();
    }


}
