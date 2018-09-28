<!-- 

菜单编辑页面
Li Dehuan

 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>新增菜单</title>
	<link rel="shortcut icon" href="favicon.ico">
	<link rel="stylesheet" href="${contextPath}/static/Hplus/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
	<link rel="stylesheet" href="${contextPath}/static/Hplus/css/font-awesome.min.css?v=4.4.0">

</head>
<body style="padding-top: 10px;">
	<form class="form-horizontal m-t" id="signupForm">
        <div class="form-group">
            <label class="col-sm-3 control-label">姓氏：</label>
            <div class="col-sm-8">
                <input id="firstname" name="firstname" class="form-control" type="text">
                <span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 这里写点提示的内容</span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">名字：</label>
            <div class="col-sm-8">
                <input id="lastname" name="lastname" class="form-control" type="text" aria-required="true" aria-invalid="false" class="valid">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">用户名：</label>
            <div class="col-sm-8">
                <input id="username" name="username" class="form-control" type="text" aria-required="true" aria-invalid="true" class="error">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">密码：</label>
            <div class="col-sm-8">
                <input id="password" name="password" class="form-control" type="password">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">确认密码：</label>
            <div class="col-sm-8">
                <input id="confirm_password" name="confirm_password" class="form-control" type="password">
                <span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 请再次输入您的密码</span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">E-mail：</label>
            <div class="col-sm-8">
                <input id="email" name="email" class="form-control" type="email">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-8 col-sm-offset-3">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" class="checkbox" id="agree" name="agree">
                        我已经认真阅读并同意《H+使用协议》
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-8 col-sm-offset-3">
                <button class="btn btn-primary" type="submit">提交</button>
            </div>
        </div>
    </form>
                    
    
    <!-- js -->
	<script src="${contextPath}/static/Hplus/js/jquery.min.js?v=2.1.4"></script>
	<script src="${contextPath }/static/Hplus/js/plugins/layer/layer.min.js"></script>
	<script src="${contextPath }/static/Hplus/js/plugins/validate/jquery.validate.min.js"></script>
	<script src="${contextPath }/static/Hplus/js/plugins/validate/messages_zh.min.js"></script>
	<script src="${contextPath }/static/Hplus/js/demo/form-validate-demo.js"></script>
	
	<script type="text/javascript">
	
	</script>
</body>
</html>