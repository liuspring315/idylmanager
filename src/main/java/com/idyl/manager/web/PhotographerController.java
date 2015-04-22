package com.idyl.manager.web;

import com.idyl.manager.data.PhotographerExtra;
import com.idyl.manager.data.RegisterCheckStateEnum;
import com.idyl.manager.data.UserTypeEnum;
import com.idyl.manager.service.account.PhotographerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping("/pass")
    public String pass(RedirectAttributes model,int userType,int personId){
        int i  = photographerService.upRegisterCheckState(userType,personId,RegisterCheckStateEnum.APPROVE_YES.getCode());
        model.addFlashAttribute("message", i == 1 ? "执行成功" : "执行失败");
        return "redirect:/photographer/photographer_view";
    }
    @RequestMapping("/over")
    public String over(RedirectAttributes model,int userType,int personId){
        int i  = photographerService.upRegisterCheckState(userType, personId, RegisterCheckStateEnum.APPROVE_NO.getCode());
        model.addFlashAttribute("message", i == 1 ? "执行成功" : "执行失败");
        return "redirect:/photographer/photographer_view";
    }
    @RequestMapping("/lock")
    public String lock(RedirectAttributes model,int userType,int personId){
        int i  = photographerService.upRegisterCheckState(userType, personId, RegisterCheckStateEnum.LOCK.getCode());
        model.addFlashAttribute("message", i == 1 ? "执行成功" : "执行失败");
        return "redirect:/photographer/photographer_view";
    }
    @RequestMapping("/rev")
    public String rev(RedirectAttributes model,int userType,int personId){
        int i  = photographerService.upRegisterCheckState(userType, personId, RegisterCheckStateEnum.WAIT_APPROVE.getCode());
        model.addFlashAttribute("message", i==1?"执行成功":"执行失败");
        return "redirect:/photographer/photographer_view";
    }


}
