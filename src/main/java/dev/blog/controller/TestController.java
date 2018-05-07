package dev.blog.controller;

import dev.blog.dao.PostReview;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")//正式上线时要注解掉这个类
public class TestController {
    @RequestMapping("")
    public ModelAndView index(){
        List<PostReview> postReviewList =new ArrayList<PostReview>();

        PostReview bean = new PostReview("文章一", "副标题", "2017");
        postReviewList.add(bean);
        bean = new PostReview("文章二", "副标题", "2018");
        postReviewList.add(bean);
        bean = new PostReview("文章三", "副标题", "2018");
        postReviewList.add(bean);
        bean = null;

        ModelAndView modelAndView = new ModelAndView("html/index");
        modelAndView.addObject("postReviewList", postReviewList);
        return modelAndView;
    }
}
