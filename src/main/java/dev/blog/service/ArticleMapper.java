package dev.blog.service;

import dev.blog.domain.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ArticleMapper {

    @Select("select * from articles where id = #{id}")
    Article findById(@Param("id") int id);

}
