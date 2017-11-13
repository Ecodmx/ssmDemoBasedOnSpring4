package com.mcx.usr.controller;

import javax.annotation.Resource;


import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mcx.usr.entity.User;
import com.mcx.usr.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/test") 
public class LoginController {
	@Resource
	private UserServiceImpl userService;

@RequestMapping("/dologin.do") //url
public String dologin(User user, Model model){  
    if(userService.doUserLogin(user)){  
        model.addAttribute("successMsg", "鐧婚檰鎴愬姛锛�");//杩斿洖鍒伴〉闈㈡墍澶瑰甫鐨勫弬鏁�  
        model.addAttribute("name", user.getUsername());  
        return "/success";//杩斿洖鐨勯〉闈�  
    }else{  
        model.addAttribute("failMsg", "鐢ㄦ埛涓嶅瓨鍦ㄦ垨瀵嗙爜閿欒锛�");  
        return "/fail";  
    }     
}  
}
