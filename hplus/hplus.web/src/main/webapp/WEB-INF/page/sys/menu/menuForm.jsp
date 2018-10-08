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
	<link rel="stylesheet" href="${contextPath}/static/Hplus/css/style.css?v=4.1.0" >

	<style type="text/css">
		.ldh_childmenu_group{
			display: none;
		}
	</style>
</head>
<body style="padding-top: 10px;">
	<form class="form-horizontal m-t" id="signupForm">
        <div class="form-group">
            <label class="col-sm-3 control-label">菜单名称：</label>
            <div class="col-sm-8">
                <input id="menuName" name="menuName" class="form-control" data-minlength="2" type="text" value="${menuEntity.menuName }" required>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">菜单编码：</label>
            <div class="col-sm-8">
                <input id="menuCode" name="menuCode" class="form-control" type="text" value="${menuEntity.menuCode }" aria-required="true" aria-invalid="false" class="valid" required>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">菜单类型：</label>
            <div class="col-sm-8">
            	<select id="menuType" name="menuType" class="form-control" aria-required="true" aria-invalid="true" class="error" required>
            		<option value="1">目录</option>
            		<option value="2">菜单</option>
            	</select> 
            </div>
        </div>
        
        <div class="form-group ldh_parentmenu_group">
            <label class="col-sm-3 control-label">菜单样例：</label>
            <div class="col-sm-8">
                <input id="icon" name="icon" class="form-control" type="text" value="${menuEntity.icon }">
                <span class="m-b-none" onclick="lookIconClick()" style="cursor: pointer;"><i class="fa fa-info-circle"></i> 点击查看样例</span>
            </div>
        </div>
        
        <div class="form-group ldh_childmenu_group">
            <label class="col-sm-3 control-label">菜单url：</label>
            <div class="col-sm-8">
                <input id="url" name="url" class="form-control" type="text" value="${menuEntity.url }">
            </div>
        </div>
        
        <div class="form-group ldh_childmenu_group">
            <label class="col-sm-3 control-label">上级菜单：</label>
            <div class="col-sm-8">
                <input id="pcode" name="pcode" class="form-control" type="text" value="${menuEntity.pcode }">
            </div>
        </div>
        
		<!-- 打开方式 -->
		<div class="form-group ldh_childmenu_group">
		<label class="col-sm-3 control-label">打开方式：</label>
			<div class="col-sm-8">
                <input id="openType" name="openType" class="form-control" type="text" value="${menuEntity.openType }">
            </div>
        </div>
        
        <!-- 菜单顺序 -->
        <div class="form-group">
            <label class="col-sm-3 control-label">菜单顺序：</label>
            <div class="col-sm-8">
                <input id="menuOrder" name="menuOrder" class="form-control" type="text" value="${menuEntity.menuOrder }" required>
            </div>
        </div>
        
        <!-- 菜单描述 -->
        <div class="form-group">
            <label class="col-sm-3 control-label">菜单描述：</label>
            <div class="col-sm-8">
                <input id="describe" name="describe" class="form-control" type="text" value="${menuEntity.describe }">
            </div>
        </div>
       
        <div class="form-group">
            <div class="col-sm-8 col-sm-offset-3">
                <button class="btn btn-primary" type="submit">添加</button>
            </div>
        </div>
    </form>
                    
    
    <!-- js -->
	<script src="${contextPath}/static/Hplus/js/jquery.min.js?v=2.1.4"></script>
	<script src="${contextPath}/static/js/jquery.form.js"></script>
	<script src="${contextPath }/static/Hplus/js/plugins/layer/layer.min.js"></script>
	<script src="${contextPath }/static/Hplus/js/plugins/validate/jquery.validate.min.js"></script>
	<script src="${contextPath }/static/Hplus/js/plugins/validate/messages_zh.min.js"></script>
	
	<!-- 公共js -->
	<script src="${contextPath}/static/js/common.js?v=2.1.4"></script>
	<!-- menujs 一般放在最后-->
	<script src="${contextPath }/static/js/web/sys/menu/menuForm.js"></script>
</body>
</html>