package com.crazy18.marketgoods.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {


    @RequestMapping("/")
//    @ResponseBody
<<<<<<< HEAD
    String index(){
=======
    String index() {
>>>>>>> 94cbe5bb11ab078f253300ea864bdf1a46ef2afc
        return "index";
    }
}
