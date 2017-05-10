package com.devefx.website.validator.constraints;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.devefx.validation.Script;
import com.devefx.validation.annotation.BindScript;
import com.devefx.validation.constraints.FieldValidator;
import com.devefx.validation.kit.StrKit;
import com.devefx.validation.script.JavaScript;

/**
 * 自定义验证码验证器.
 */
@BindScript("com/devefx/website/validator/constraints/js/CodeValidator.js")
public class CodeValidator extends FieldValidator implements Script {

    private final Script script;
    private final String sessionKey;

    public CodeValidator(String field, String sessionKey, String errorCode, String errorMessage) {
        super(field, errorCode, errorMessage);
        this.sessionKey = sessionKey;
        script = JavaScript.create(this, field, sessionKey, errorCode, errorMessage);
    }

    @Override
    public boolean isValid(HttpServletRequest request) throws Exception {
        String value = request.getParameter(field);
        System.out.println("value:"+value);
        // 如果是空，就交个NotEmptyValidator组件
        if (!StrKit.isEmpty(value)) {
            HttpSession session = request.getSession();
            // 为了讲解方便（实际项目中可不能这么干），我直接把‘1234’当做正确的验证码
            System.out.println(value.equals(/*session.getAttribute(sessionKey)*/"1234"));
            
            return value.equals(/*session.getAttribute(sessionKey)*/"1234");
        }
        return true;
    }

    public void output(Writer out) throws IOException {
        script.output(out);
    }
}