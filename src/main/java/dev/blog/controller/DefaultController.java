package dev.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页入口controller
 *
 */
@Controller
public class DefaultController {
    @RequestMapping("/")
    public String home(Model model){
        return "blog/index";
    }
}
