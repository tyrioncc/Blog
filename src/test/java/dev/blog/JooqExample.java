package dev.blog;


import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jooq.AutoConfigureJooq;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

//import static org.jooq.example.db.mysql.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@Component
@AutoConfigureJooq
public class JooqExample
{
    @Autowired
    private  DSLContext create;


    private String getArticleTitle(int id) {
        Result<Record1<Object>> result =
                create.select(field("title")).from(table("articles")).where(field("id").eq(id)).fetch();
        return result.getValues(0).toString();
    }
/*
    private String getArticleTitle2(int id) {
        Result<Record1<Object>> result =
                create.select(TITLE).from(ARTICLES).where(ID.eq(id)).fetch();
        return result.getValues(0).toString();
    }*/


    @Test
    public void testGetArticleTitle(){
        System.out.println(getArticleTitle(1));
        //System.out.println(getArticleTitle2(1));
    }
}
