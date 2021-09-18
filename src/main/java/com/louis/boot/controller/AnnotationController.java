package com.louis.boot.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
@RestController
public class AnnotationController {

    @RequestMapping("/teacher/{id}/info/{username}")
    public Map<String,Object> annotation(@PathVariable("id") Integer id, @PathVariable("username") String username,
                                   @PathVariable Map<String,String> kv, @RequestHeader("User-Agent") String agent,
                                   @RequestHeader Map<String,String> header,
                                    @RequestParam Map<String,String> params,
                                         @CookieValue("__gads") String gads){
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("username",username);
//        map.put("kv",kv);
        map.put("user-agent",agent);
//        map.put("header",header);
//        map.put("inters",params);
        map.put("_gads",gads);
        return map;
    }

    @RequestMapping("save")
    public Map<String,Object> save(@RequestBody String content){
        Map<String,Object> map = new HashMap<>();
        map.put("content",content);
        return map;
    }
}
