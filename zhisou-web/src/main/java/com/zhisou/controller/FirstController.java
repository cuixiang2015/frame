package com.zhisou.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.devefx.validation.annotation.Valid;
import com.devefx.website.validator.RegisterValidator;

import net.sf.json.JSONObject;

@Controller
public class FirstController {

    @RequestMapping("/index.action")
    public String index() {
        return "index";
    }
    
    @RequestMapping("/register.action")
    public String register() {
        return "register";
    }
    
    /**
     * 处理注册请求
     */
    @Valid(RegisterValidator.class)
    @ResponseBody
    @RequestMapping(value="/do/register.action", method=RequestMethod.POST)
    public String doregister(HttpServletResponse response) {
        
    	System.out.println("处理注册请求");

        JSONObject obj = new JSONObject();
        obj.put("success", "123");
        return obj.toString();
    }
}
