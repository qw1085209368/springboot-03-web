package com.zfk.springboot03web.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@Controller
public class LoginController {
    @RequestMapping("/index")
    public String login(@RequestParam("UserName") String UserName,
                         @RequestParam("Password") String Password,
                         Model model,HttpSession Session){
        System.out.println("UserName"+UserName);
        System.out.println("Password"+Password);
        if(!StringUtils.isEmpty(UserName)&&!StringUtils.isEmpty(Password)){
            Session.setAttribute("loginUser",UserName);
            System.out.println("Session:"+Session.getAttribute ("loginUser"));
            return "redirect:/tables";
        }
        else {
            model.addAttribute("msg","用户名或者密码错误");
            return "login.html";
        }

    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        System.out.println("woshi logout");
        session.invalidate();

        return "redirect:/";
    }
}
