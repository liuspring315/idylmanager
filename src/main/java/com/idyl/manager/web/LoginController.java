package com.idyl.manager.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 *
 * 作成日期： 2012-8-16 
 * <p>功能描述:LoginController负责打开登录页面(GET请求)和登录出错页面(POST请求)，
 * 真正登录的POST请求由Filter完成</p>
 * @author  liuzhaochun
 * @version 0.1
 */
@Controller
public class LoginController  {


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,Model model,
                        HttpServletRequest request,HttpSession session) {

        Subject currentUser = SecurityUtils.getSubject();
        String result = "login";
        if (!currentUser.isAuthenticated()) {
            result = login(currentUser,username,password,model);
        }else{//重复登录
            Map<String,Object> user = (Map<String,Object>) currentUser.getPrincipal();
            if(!user.get("USER_NAME").toString().equalsIgnoreCase(username)){//如果登录名不同
                currentUser.logout();
                result = login(currentUser,username,password,model);
            }else{
                result = "redirect:/main";
            }
        }
        return result;


    }

    private String login(Subject currentUser,String username,String password,Model model){
        String result = "login";
        UsernamePasswordToken token = new UsernamePasswordToken(username,
                password);
        token.setRememberMe(false);
        try {
            currentUser.login(token);
            result = "redirect:/main";
        } catch (UnknownAccountException uae) {
            model.addAttribute("message","用户不存在");
            result = "login";
        } catch (IncorrectCredentialsException ice) {
            model.addAttribute("message","用户不存在");
            result = "login";
        } catch (LockedAccountException lae) {
            model.addAttribute("message","用户不存在");
            result = "login";
        } catch (AuthenticationException ae) {
            model.addAttribute("message","用户不存在");
            result = "login";
        }catch (Exception ae) {
            model.addAttribute("message","用户不存在");
            result = "login";
        }
        return result;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {

        Subject currentUser = SecurityUtils.getSubject();
        String result = "login";
        currentUser.logout();
        return result;
    }





}
