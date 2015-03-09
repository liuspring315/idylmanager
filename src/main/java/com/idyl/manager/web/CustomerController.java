package com.idyl.manager.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by spring on 15-3-9.
 */
@Controller
@RequestMapping("customer")
public class CustomerController extends BaseController {


    @RequestMapping("/customer_view")
    public String index(Model model){
        return "customer/customer_view";
    }


}
