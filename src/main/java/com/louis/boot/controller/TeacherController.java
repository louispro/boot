package com.louis.boot.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
@RestController
public class TeacherController {

    @ResponseBody
    @RequestMapping(value="teacher",method = RequestMethod.GET)
    @GetMapping("teacher")
    public String getTeacher(){
        return "获得老师";
    }

    @ResponseBody
    @RequestMapping(value="tacher",method = RequestMethod.DELETE)
    @DeleteMapping("teacher")
    public String deleteTeacher(){
        return "删除老师";
    }

    @ResponseBody
    @RequestMapping(value="tacher",method = RequestMethod.POST)
    @PostMapping("teacher")
    public String saveTeacher(){
        return "增加老师";
    }

    @ResponseBody
    @RequestMapping(value = "teacher",method = RequestMethod.PUT)
    @PutMapping("teacher")
    public String updateTeacher(){
        return "修改老师";
    }
}
