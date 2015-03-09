package com.idyl.manager.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by spring on 15-3-6.
 */
@Controller
@RequestMapping("photographer")
public class PhotographerController extends BaseController {


    @RequestMapping("/photographer_view")
    public String index(Model model){
        return "photographer/photographer_view";
    }


}
