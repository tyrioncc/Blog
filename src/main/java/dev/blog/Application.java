package dev.blog;

import dev.blog.service.ArticleMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("dev.blog.service")
public class Application implements CommandLineRunner {

    @Autowired
    private final ArticleMapper articleMapper;

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    public Application(ArticleMapper articleMapper){
        this.articleMapper = articleMapper;
    }


    @Override
    public void run(String... args) throws Exception {
       System.out.println(this.articleMapper.findById(1));
    }
}
