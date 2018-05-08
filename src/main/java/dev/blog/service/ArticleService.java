package dev.blog.service;

import org.jooq.example.db.mysql.tables.Article;
import org.jooq.example.db.mysql.tables.records.ArticleRecord;

import java.util.List;

public interface ArticleService {
    /**
     * 通过id获取文章标题
     * @param id 文章id
     * @return 标题
     */
    String getArticleTitleById(int id);



    /**
     * 获取文章数量
     * @return 文章数量
     */
    int getArticleCount();


    /**
     * 保存文章
     * @param article 文章
     */
    void saveArticle(Article article);

    /**
     * 更新文章状态
     * @param id 文章id
     * @param status
     */
    void updateStatue(int id, int status);

    /**
     * 增加文章阅读数量
     * @param id 文章id
     */
    void addArticleCount(int id);

    /**
     * 获取文章列表
     * @param offset 偏移量
     * @param limit 文章数量
     */
    List<ArticleRecord> getArticleList(int offset, int limit);

}
