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
<link rel="stylesheet"
	href="${contextPath}/static/Hplus/css/bootstrap.min.css?v=3.3.6"
	rel="stylesheet">
<link rel="stylesheet"
	href="${contextPath}/static/Hplus/css/font-awesome.min.css?v=4.4.0">
<link rel="stylesheet"
	href="${contextPath}/static/Hplus/css/style.css?v=4.1.0">

<style type="text/css">
.ldh_childbutton_group {
	display: none;
}
</style>
</head>
<body style="padding-top: 10px;">
	<form class="form-horizontal m-t" id="signupForm" method="post">

		<!-- 隐藏域 -->
		<input id="btnid" name="btnid" type="hidden" autocomplete="off" value="${buttonEntity.id }"> 
		<input type="hidden" id="oper" name="oper" value="${oper}" />

		<!-- <input type="hidden" name="_method" value="put" /> -->

		<div class="form-group">
			<label class="col-sm-3 control-label">按钮名称：</label>
			<div class="col-sm-8">
				<input id="btnName" name="btnName" class="form-control"
					data-minlength="2" type="text" value="${buttonEntity.btnName }"
					required>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">按钮编码：</label>
			<div class="col-sm-8">
				<input id="btnCode" name="btnCode" class="form-control"
					type="text" value="${buttonEntity.btnCode }"
					aria-required="true" aria-invalid="false" class="valid" required>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">按钮样式：</label>
			<div class="col-sm-8">
				<input id="btnClass" name="btnClass" class="form-control"
					type="text" value="${buttonEntity.btnClass }"
					aria-required="true" aria-invalid="false" class="valid">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">按钮事件：</label>
			<div class="col-sm-8">
				<input id="btnEvent" name="btnEvent" class="form-control"
					type="text" value="${buttonEntity.btnEvent }"
					aria-required="true" aria-invalid="false" class="valid">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">顺序：</label>
			<div class="col-sm-8">
				<input id="btnOrder" name="btnOrder" class="form-control"
					type="text" value="${buttonEntity.btnOrder }"
					aria-required="true" aria-invalid="false" class="valid" required>
			</div>
		</div>

		<!-- 按钮描述 -->
		<div class="form-group">
			<label class="col-sm-3 control-label">按钮描述：</label>
			<div class="col-sm-8">
				<input id="btnDescribe" name="btnDescribe" class="form-control"
					type="text" value="${buttonEntity.btnDescribe }">
			</div>
		</div>

		<div class="form-group">

			<c:if test="${oper != 'view' }">
				<div class="col-sm-8 col-sm-offset-3">
					<button class="btn btn-primary" type="submit">保存</button>
				</div>

			</c:if>

		</div>
	</form>


	<!-- js -->
	<script src="${contextPath}/static/Hplus/js/jquery.min.js?v=2.1.4"></script>
	<script src="${contextPath}/static/js/jquery.form.js"></script>
	<script
		src="${contextPath }/static/Hplus/js/plugins/layer/layer.min.js"></script>
	<script
		src="${contextPath }/static/Hplus/js/plugins/validate/jquery.validate.min.js"></script>
	<script
		src="${contextPath }/static/Hplus/js/plugins/validate/messages_zh.min.js"></script>

	<!-- 公共js -->
	<script src="${contextPath}/static/js/common.js?v=2.1.4"></script>
	<!-- buttonjs 一般放在最后-->
	<script
		src="${contextPath }/static/js/web/authority/button/buttonForm.js"></script>
</body>
</html>