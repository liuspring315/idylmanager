package com.idyl.manager.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by spring on 15-3-4.
 */
@Controller
public class MainController {


    @RequestMapping("main")
    public String index(Model model){
        return "main";
    }
}
