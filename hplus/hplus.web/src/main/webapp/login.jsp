<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="shortcut icon" href="favicon.ico">
<link rel="stylesheet"
	href="${contextPath}/static/Hplus/css/bootstrap.min.css?v=3.3.6"
	rel="stylesheet">
<link rel="stylesheet"
	href="${contextPath}/static/Hplus/css/font-awesome.min.css?v=4.4.0">
<link rel="stylesheet"
	href="${contextPath}/static/Hplus/css/style.css?v=4.1.0">

</head>
<body style="background-color: ">
	<img alt="" src="/dir/img/login/login_bg.jpg">
	<div style="position: absolute;width:400px;left:50%;top:50%; 
		margin-left:-200px;margin-top:-200px;border: 1px #ccc solid;background-color: white;">
		<div class="ibox float-e-margins">
			<div class="ibox-title"></div>
			<div class="ibox-content">
				<form class="form-horizontal">
					<p>欢迎登录本站(⊙o⊙)</p>
					<div class="form-group">
						<label class="col-sm-3 control-label">用户名：</label>

						<div class="col-sm-8">
							<input type="text" id="account" placeholder="用户名" class="form-control">
							
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">密码：</label>

						<div class="col-sm-8">
							<input type="password" id="pwd" placeholder="密码" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-8">
							<button class="btn btn-sm btn-white" type="button" id="login_btn">登 录</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- js  -->
	<script src="${contextPath}/static/Hplus/js/jquery.min.js?v=2.1.4"></script>
	<script src="${contextPath}/static/js/jquery.form.js"></script>
	<script
		src="${contextPath }/static/Hplus/js/plugins/layer/layer.min.js"></script>

	<script type="text/javascript">
		
		$("#login_btn").click(function(){
			
			var account = $("#account").val();
			var pwd = $("#pwd").val();
			
			$.ajax({
				url: "${contextPath }/sys/user/login",
				data: {account: account, pwd: pwd},
				type: "post",
				dataType: "json",
				success: function(res){

					if(res.isSuccess == 1){
						window.location.href = "/hplus/main";
					}else{
						layer.msg(res.msg);
					}
					
				}
			});	
		});
		
	
	</script>
</body>
</html>