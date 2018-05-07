package dev.blog;


import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import static org.jooq.example.db.mysql.tables.Articles.ARTICLES;
import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;


@RunWith(SpringRunner.class)
@SpringBootTest
@Component
public class JooqExample
{
    @Autowired
    private  DSLContext create;


    private String getArticleTitle(int id) {
        Result<Record1<Object>> result =
                create.select(field("title")).from(table("articles")).where(field("id").eq(id)).fetch();
        return result.getValues(0).toString();
    }

    private String getArticleTitle2(int id) {
        Result<Record1<String>> result =
                create.select(ARTICLES.TITLE).from(ARTICLES).where(ARTICLES.ID.eq(id)).fetch();
        return result.getValues(0).toString();
    }


    @Test
    public void testGetArticleTitle(){
        System.out.println(getArticleTitle(1));
        System.out.println(getArticleTitle2(1));
    }
}
