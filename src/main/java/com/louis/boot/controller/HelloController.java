package com.louis.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("hello")
    public String hello(){
        return "hello,spring boot!";
    }
}
