<#setting classic_compatible=true>
<!DOCTYPE HTML>
<html>
    <head>
        <title>注册</title>
        <!-- Validator前端验证功能依赖jQuery库 -->
        <script src="/zhisou-web/assets/js/jquery-2.1.4.js" type="text/javascript"></script>
        <!-- Validator前端验证功能的核心js -->
        <script src="/zhisou-web/validator/validator.js" type="text/javascript"></script>
        <!-- 用户配置的验证器 -->
        <script src="/zhisou-web/validator/registerValidator.js" type="text/javascript"></script>
        <style type="text/css">
            .error { color: red; padding-left: 5px }
        </style>
        <script type="text/javascript">
            $(function () {
            	var selector = $("#registerForm");
                selector.validator({
                    success: function () {
                        // 删除页面全部的错误提示
                        $("#registerForm .error").remove();
                        // 错误处理方法
                        var errorMethod = this.error;
                        // 提交表单到后台
                        selector.commit(function (result) {
                            // 判断后台是否验证通过
                            if (result.success) {
                                alert("提交成功！");
                            } else if (result.data) {
                                // 重新处理错误
                                errorMethod(result.data, null);
                            }
                        });
                    },
                    error: function (error, field) {
                        // 处理submit动作的错误
                        if (field == null) {
                            // 删除页面全部的错误提示
                            $("#registerForm .error").remove();
                            // 根据错误信息，重新显示错误信息
                            for (var code in error) {
                                selector.findInputByName(code).after('<span class="error">' + error[code] + '</span>');
                            }
                            return;
                        }
                        // 处理field验证的错误
                        // 根据field删除相关错误提示
                        selector.findInputByName(field).next().remove();
                        // 如果field验证失败
                        if (error != null) {
                            // 在页面显示field的错误信息
                            selector.findInputByName(error.code).after('<span class="error">' + error.message + '</span>');
                        }
                    }
                });
            });
            
            function submitForm(){
            	$("#registerForm").submit();
            }
        </script>
    </head>
    <body>
        <form id="registerForm" action="/zhisou-web/do/register.action" method="post">
            <table>
                <tr>
                    <td>用户名：</td>
                    <td><input name="username" value="seller1"/></td>
                </tr>
                <!--  -->
                <tr>
                    <td>密码：</td>
                    <td><input name="password" type="password" value="seller1"/></td>
                </tr>
                <tr>
                    <td>确认密码：</td>
                    <td><input name="password_safe" type="password" value="seller1"/></td>
                </tr>
                <tr>
                    <td>手机号：</td>
                    <td><input name="phoneno" value="15395112118"/></td>
                </tr>
                <tr>
                    <td>邮箱：</td>
                    <td><input name="email" value="123@qq.com"/></td>
                </tr>
                <tr>
                    <td>出生日期：</td>
                    <td><input name="birthday" type="date"/></td>
                </tr>
                <tr>
                    <td>个人主页：</td>
                    <td><input name="homepage"></td>
                </tr>
                <!-- 验证码输入框 -->
                <tr>
                    <td>验证码：</td>
                    <td><input name="code" placeholder="请输入1234"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="button" value="注册" onclick="submitForm();"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="reset" value="重置" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>