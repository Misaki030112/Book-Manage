package com.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
对外接口
controller层
 */
@Controller
public class EmployeeController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "ok";
    }
}
