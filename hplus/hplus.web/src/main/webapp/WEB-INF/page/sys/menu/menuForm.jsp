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
            <label class="col-sm-3 control-label">菜单名称：</label>
            <div class="col-sm-8">
                <input id="menuName" name="menuName" class="form-control" data-minlength="2" type="text" required>
                <span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 这里写点提示的内容</span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">菜单编码：</label>
            <div class="col-sm-8">
                <input id="menuCode" name="menuCode" class="form-control" type="text" aria-required="true" aria-invalid="false" class="valid" required>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">菜单类型：</label>
            <div class="col-sm-8">
                <input id="menuType" name="menuType" class="form-control" type="text" aria-required="true" aria-invalid="true" class="error">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">菜单url：</label>
            <div class="col-sm-8">
                <input id="url" name="url" class="form-control" type="text">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">菜单样例：</label>
            <div class="col-sm-8">
                <input id="icon" name="icon" class="form-control" type="text">
                <span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 请再次输入您的密码</span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">上级菜单：</label>
            <div class="col-sm-8">
                <input id="pcode" name="pcode" class="form-control" type="email">
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
	<script src="${contextPath}/static/Hplus/js/jquery.form.js?v=2.1.4"></script>
	<script src="${contextPath }/static/Hplus/js/plugins/layer/layer.min.js"></script>
	<script src="${contextPath }/static/Hplus/js/plugins/validate/jquery.validate.min.js"></script>
	<script src="${contextPath }/static/Hplus/js/plugins/validate/messages_zh.min.js"></script>
	
	<!-- menujs 一般放在最后-->
	<script src="${contextPath }/static/js/web/sys/menu/menuForm.js"></script>
</body>
</html>