package dev.blog.service.impl;

import dev.blog.service.ArticleService;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.example.db.mysql.tables.records.ArticleRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

import static org.jooq.example.db.mysql.tables.Article.ARTICLE;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    private final DSLContext create;

    @Autowired
    public ArticleServiceImpl(DSLContext create){
        this.create = create;
    }

    @Override
    public ArticleRecord getArticleById(int id){
        ArticleRecord  result = create.selectFrom(ARTICLE).where(ARTICLE.ID.eq(id)).fetchOne();
        return result;
    }

    @Override
    public String getArticleTitleById(int id){
        ArticleRecord  result = getArticleById(id);
        return result.getTitle();
    }

    @Override
    public int getArticleNum() {
        return create.fetchCount(create.selectFrom(ARTICLE));
    }

    @Override
    public void addArticle(ArticleRecord article) {
        create.insertInto(ARTICLE, ARTICLE.TITLE, ARTICLE.DESCRIPTION, ARTICLE.CONTENT, ARTICLE.CREATE_TIME)
                .values(article.getTitle(), article.getDescription(), article.getContent(), article.getCreateTime())
                .execute();
    }

    @Override
    public void saveArticleById(ArticleRecord article, int id){
        create.update(ARTICLE).set(ARTICLE.TITLE, article.getTitle()).set(ARTICLE.DESCRIPTION, article.getDescription())
                .set(ARTICLE.CONTENT, article.getContent()).set(ARTICLE.UPDATE_TIME, article.getUpdateTime())
                .where(ARTICLE.ID.eq(id)).execute();
    }

    @Override
    public void updateStatue(int id, int status) {
        create.update(ARTICLE).set(ARTICLE.STATUS, status).where(ARTICLE.ID.eq(id)).execute();
    }

    @Override
    public void addArticleCount(int id) {
        create.update(ARTICLE).set(ARTICLE.SHOW_COUNT, ARTICLE.SHOW_COUNT.add(1))
                .where(ARTICLE.ID.eq(id)).execute();
    }

    @Override
    public List<ArticleRecord> getAvaliableArticleList(int offset, int limit) {
        return create.selectFrom(ARTICLE).where(ARTICLE.STATUS.eq(0)).orderBy(ARTICLE.CREATE_TIME.desc()).limit(limit).offset(offset).fetch();
    }

    @Override
    public List<ArticleRecord> getArticleList(int offset, int limit) {
        return create.selectFrom(ARTICLE).orderBy(ARTICLE.CREATE_TIME.desc()).limit(limit).offset(offset).fetch();
    }

    @Override
    public void deleteArticleById(int id){
        create.delete(ARTICLE).where(ARTICLE.ID.eq(id));
    }

}
