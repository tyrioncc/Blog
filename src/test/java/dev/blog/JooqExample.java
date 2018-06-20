package dev.blog;

import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.example.db.mysql.tables.records.ArticleRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

import static org.jooq.example.db.mysql.tables.Article.ARTICLE;
import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JooqExample
{
    @Autowired
    private  DSLContext create;


    private String getArticleTitle(int id) {
        Result<Record1<Object>> result =
                create.select(field("title")).from(table("article")).where(field("id").eq(id)).fetch();
        return result.getValues(0).toString();
    }

    private String getArticleTitle2(int id) {
        Result<Record1<String>> result =
                create.select(ARTICLE.TITLE).from(ARTICLE).where(ARTICLE.ID.eq(id)).fetch();
        return result.getValues(0).toString();
    }



    @Test
    public void testGetArticleTitle(){
        System.out.println(getArticleTitle(1));
        System.out.println(getArticleTitle2(1));
    }

    @Test
    public void testAddArticle(){
        ArticleRecord article = new ArticleRecord();
        article.setTitle("test");
        article.setDescription("");
        article.setContent("test\ncontent");
        article.setCreateTime(new Timestamp(System.currentTimeMillis()));

        try {
            create.insertInto(ARTICLE, ARTICLE.TITLE, ARTICLE.DESCRIPTION, ARTICLE.CONTENT, ARTICLE.CREATE_TIME)
                    .values(article.getTitle(), article.getDescription(), article.getContent(), article.getCreateTime())
                    .execute();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
