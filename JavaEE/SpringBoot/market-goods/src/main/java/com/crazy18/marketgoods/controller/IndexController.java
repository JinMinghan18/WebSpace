package com.crazy18.marketgoods.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {


    @RequestMapping("/")
//    @ResponseBody
    String index() {
        return "index";
    }
}
