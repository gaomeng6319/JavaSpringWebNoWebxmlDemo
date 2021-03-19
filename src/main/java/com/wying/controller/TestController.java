package com.wying.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * description:测试controller
 * date: 2021/3/19
 * author: gaom
 * version: 1.0
 */
@Controller
public class TestController {
    @RequestMapping(value="test.do")
    public String testjsp(){
        return  "test";
    }
}
