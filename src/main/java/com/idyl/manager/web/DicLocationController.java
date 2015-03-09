package com.idyl.manager.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by spring on 15-3-5.
 */

@Controller
@RequestMapping("dic")
public class DicLocationController extends BaseController {


    @RequestMapping("/dic_location_view")
    public String index(Model model){
        return "dic/dic_location_view";
    }


}
