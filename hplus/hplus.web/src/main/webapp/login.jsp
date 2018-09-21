<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>登录</title>
</head>
<body>

	<form action="">
		用户：<input name="account" id="account" /><br>
		密码：<input name="pwd" id="pwd" /><br>
		<button type="button" id="login_btn">登录</button>
	</form>
	
	<script src="static/js/jquery.min.js"></script>
	
	<script type="text/javascript">
		
		$("#login_btn").click(function(){
			
			var account = $("#account").val();
			var pwd = $("#pwd").val();
			
			$.ajax({
				url: "sys/user/login",
				data: {account: account, pwd: pwd},
				type: "post",
				dataType: "json",
				success: function(res){

					if(res.isSuccess == 1){
						window.location.href = "/hplus/main";
					}else{
						alert(res.msg);
					}
					
				}
			});	
		});
		
	
	</script>
</body>
</html>