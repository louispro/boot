package com.louis.boot.controller;

import com.louis.boot.bean.Louis;
import com.louis.boot.bean.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
@Controller
public class RequestController {

    @RequestMapping("/goto")
    public String toSuccess(HttpServletRequest request){
        request.setAttribute("msg","hello world");
        request.setAttribute("code",200);
        return "forward:/success";
    }


    @ResponseBody
    @RequestMapping("/success")
    public Map<String,Object> success(@RequestAttribute("msg") String msg,@RequestAttribute("code") Integer code){
        Map<String,Object> map = new HashMap<>();
        map.put("msg",msg);
        map.put("code",code);
        return map;
    }

    @GetMapping("/teacher/{path}")
    public Map<String,Object> matrix(@MatrixVariable("low") Integer low, @MatrixVariable("brand") List<String> brand,
                                     @PathVariable("path") String path){
        System.out.println(brand);
        Map<String,Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }

    @GetMapping("/teacher/{sell}/{sale}")
    public Map<String,Object> matrixs(@MatrixVariable(value = "age",pathVar = "sell") Integer sell,
                                      @MatrixVariable(value = "age",pathVar = "sale")Integer sale){
        Map<String,Object> map = new HashMap<>();
        map.put("sell",sell);
        map.put("sale",sale);
        return map;
    }

    @GetMapping("param")
    public String testParam(Map<String,Object> map, Model model, HttpServletRequest request, HttpServletResponse response){
        map.put("girl","satomi");
        model.addAttribute("music","sakura");
        request.setAttribute("msg","fuck");
        Cookie cookie = new Cookie("key1","values1");
        cookie.setDomain("localhost");
        response.addCookie(cookie);
        return "forward:/fromParam";
    }

    @ResponseBody
    @GetMapping("fromParam")
    public Map<String,Object> fromParam(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        String girl = (String)request.getAttribute("girl");
        String music = (String)request.getAttribute("girl");
        String msg = (String)request.getAttribute("fuck");
        map.put("girl",girl);
        map.put("music",music);
        map.put("msg",msg);
        return map;
    }

    @ResponseBody
    @PostMapping("bean")
    public Map<String,Object> getBean(Teacher teacher){
        Map<String,Object> map = new HashMap<>();
        map.put("teacher",teacher);
        return map;
    }

    @PostMapping("louis")
    @ResponseBody
    public Map<String,Object> getLouis(Louis louis){
        Map<String,Object> map = new HashMap<>();
        map.put("louis",louis);
        return map;
    }
}
