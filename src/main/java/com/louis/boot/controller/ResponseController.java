package com.louis.boot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.louis.boot.bean.Louis;
import com.louis.boot.bean.Slave;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
@Controller
public class ResponseController {

    @ResponseBody   //导入json场景之后，自动返回json数据
    @GetMapping("resplouis")
    public Louis respLouis(){
        Louis louis = new Louis();
        louis.setName("louis");
        louis.setSlave(new Slave("satomi","louis"));
        return louis;
    }

    @GetMapping("http")
    @ResponseBody
    public Map<String,Object> testHttpEntity(HttpEntity<String> body){
        Map<String,Object> map = new HashMap<>();
        map.put("httpBody",body);
        System.out.println(body);
        return map;
    }

    @GetMapping("file")
    @ResponseBody
    public FileSystemResource test(){
        return null;
    }


}
