function CodeValidator(field, sessionKey, errorCode, errorMessage) {
    FieldValidator.apply(this, [field, errorCode, errorMessage]);
    this.isValid = function (request, control) {
        var value = request.getParameter(field);
        if (!isEmpty(value)) {
            // 使用异步
            control.async();
            // ajax异步请求
            $.ajax({
                url: "/WebProject/module/code.action", // 验证接口访问地址
                type: "post", // 请求方式
                data: {"sessionKey": sessionKey, "code": value},
                success: function (result) {
                    // 根据接口返回结果再同步到验证器
                    if (result == "success") {
                        return control.sync(true);
                    }
                    control.sync(false);
                }
            });
        }
        return true;
    };
}