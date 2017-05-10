package com.devefx.website.validator;

import com.devefx.validation.Validator;
import com.devefx.validation.constraints.impl.EmailValidator;
import com.devefx.validation.constraints.impl.EqualFieldValidator;
import com.devefx.validation.constraints.impl.LengthValidator;
import com.devefx.validation.constraints.impl.MobileValidator;
import com.devefx.validation.constraints.impl.NotBlankValidator;
import com.devefx.validation.constraints.impl.URLValidator;
import com.devefx.website.validator.constraints.CodeValidator;

public class RegisterValidator extends Validator {

    @Override
    public void setup() {
        // 用户名验证
        add(new NotBlankValidator("username", "username", "用户名不能为空"));
        add(new LengthValidator("username", 6, 20, "username", "用户名长度限制6至20位"));
        // 密码验证
        add(new NotBlankValidator("password", "password", "密码不能为空"));
        add(new LengthValidator("password", 6, 20, "password", "密码长度限制6至20位"));
        add(new EqualFieldValidator("password_safe", "password", "password_safe", "两次密码不一致"));
        // 手机号验证
        add(new NotBlankValidator("phoneno", "phoneno", "手机号不能为空"));
        add(new MobileValidator("phoneno", "phoneno", "请输入正确的手机号"));
        // 邮箱验证
        add(new NotBlankValidator("email", "email", "邮箱不能为空"));
        add(new EmailValidator("email", "email", "请输入正确的邮箱"));
        // 个人主页验证
        add(new URLValidator("homepage", "homepage", "请输入正确的主页地址"));
        // 验证码验证
        add(new NotBlankValidator("code", "code", "验证码不能为空"));
        add(new CodeValidator("code", "registerCode", "code", "请输入正确的验证码"));
    }

}
