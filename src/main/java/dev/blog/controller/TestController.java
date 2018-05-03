package dev.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")//正式上线时要注解掉这个类
public class TestController {
    public ModelAndView index(){
        List<String> learnList =new ArrayList<String>();

        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("article", learnList);
        return modelAndView;
    }
}
