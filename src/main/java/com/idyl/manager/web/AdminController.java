package com.idyl.manager.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by spring on 15-3-8.
 */
@Controller
@RequestMapping("admin")
public class AdminController extends BaseController {
    @RequestMapping("/user")
    public String userIndex(Model model){
        return "admin/user_view";
    }
    @RequestMapping("/role")
    public String roleIndex(Model model){
        return "admin/role_view";
    }
    @RequestMapping("/access")
    public String accessIndex(Model model){
        return "admin/access_view";
    }

}
