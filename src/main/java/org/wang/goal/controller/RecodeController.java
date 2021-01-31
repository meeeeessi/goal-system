package org.wang.goal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recode")
public class RecodeController {

    //日志
    @GetMapping("/showAllRecode")
    public String showAllRecode(){
        return "record";
    }

}
