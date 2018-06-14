package dev.blog.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception exception){
        ModelAndView mv = new ModelAndView("/error/error");
        mv.addObject("$errorMessage", exception.getMessage());
        mv.addObject("stackTrace", exception.getStackTrace());
        return mv;
    }


}
