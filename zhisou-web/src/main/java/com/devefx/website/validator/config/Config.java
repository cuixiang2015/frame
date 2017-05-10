package com.devefx.website.validator.config;

import com.devefx.validation.web.config.Modules;
import com.devefx.validation.web.config.Routes;
import com.devefx.validation.web.config.ValidatorConfig;
import com.devefx.website.validator.RegisterValidator;
import com.devefx.website.validator.constraints.CodeValidator;

public class Config implements ValidatorConfig {

    public void configModules(Modules modules) {
        // 这里可以添加自定义验证组件
        
    	modules.add(CodeValidator.class);
    }

    public void configRoute(Routes routes) {
        // 这里配置验证器的访问路线

        // 设置基准路径
        routes.setBasePath("/validator");

        // 注册验证器
        routes.add("/registerValidator.js", RegisterValidator.class);

    }

}
