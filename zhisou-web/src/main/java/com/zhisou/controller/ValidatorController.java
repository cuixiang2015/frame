package com.zhisou.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.devefx.validation.ConstraintValidator;
import com.devefx.website.validator.constraints.CodeValidator;

@Controller
@RequestMapping("/module")
public class ValidatorController {
    
	/**
     * 检测验证码是否输入正确
     * 
     * @param sessionKey 会话中验证码对应的key
     * @return String
     */
    @ResponseBody
    @RequestMapping(value="/code.action")
    public String codeValidate(HttpServletRequest request,
            @RequestParam("sessionKey") String sessionKey) {
        try {
        	System.out.println("sessionKey:"+sessionKey);
            ConstraintValidator validator = new CodeValidator("code", sessionKey, null, null);
            // 如果验证通过
            if (validator.isValid(request)) {
                return "success";
            }
        } catch (Exception e) {
            // ignore
        }
        return "fail";
    }
}
