<%--
       菜单授权
  User: Li Dehuan
  Date: 2018/9/21
  Time: 11:02
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>菜单授权</title>

	<link rel="stylesheet" href="${contextPath }/static/Hplus/css/plugins/jsTree/style.min.css">
	<link rel="stylesheet" href="${contextPath}/static/Hplus/css/style.css?v=4.1.0" >
</head>
<body>
	<!-- 树 -->
	<div id="jstree_menu_div"></div>
	
	<button onclick="saveTree">确定</button>

	<script src="${contextPath}/static/Hplus/js/jquery.min.js?v=2.1.4"></script>
	<script src="${contextPath }/static/Hplus/js/plugins/layer/layer.min.js"></script>
	<script src="${contextPath }/static/Hplus/js/plugins/jsTree/jstree.js"></script>
	
	<script type="text/javascript">
	
	function saveTree(){
		alert(1);
	}
	
	$(function() {
		$('#jstree_menu_div').jstree({
			"plugins" : ["checkbox","contextmenu","dnd"],
			'core' : {
				"multiple" : true,
				"check_callback" : true,
				'data' : {
					"url" : "https://www.jstree.com/fiddle/",
					"dataType" : "json" // needed only if you do not supply JSON headers
				}
			}
		});
	});
	</script>
</body>
</html>