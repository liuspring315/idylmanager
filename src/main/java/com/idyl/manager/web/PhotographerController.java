package com.idyl.manager.web;

import com.idyl.manager.data.PhotographerExtra;
import com.idyl.manager.service.account.PhotographerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by spring on 15-3-6.
 */
@Controller
@RequestMapping("photographer")
public class PhotographerController extends BaseController {

	@Autowired
	private PhotographerService photographerService;

    @RequestMapping("/photographer_view")
    public String index(Model model){
        List<PhotographerExtra> list = photographerService.findList(0, 100);
	    model.addAttribute("photographerList", list);
        return "photographer/photographer_view";
    }


}
