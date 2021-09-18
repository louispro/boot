package com.louis.boot.controller;

import com.louis.boot.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
@Slf4j  //日志功能
@Controller
public class HelloController {

    @Autowired
    Person person;

    @ResponseBody
    @RequestMapping("hello")
    public String hello(){
        log.info("日志进来了 ");
        return "hello,spring boot!";
    }

    @ResponseBody
    @RequestMapping("person")
    public Person person(){
        System.out.println(person);
        return person;
    }


}
