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

	<link rel="stylesheet" href="${contextPath}/static/plugins/ztree/zTreeStyle.css">
	<link rel="stylesheet" href="${contextPath}/static/Hplus/css/style.css?v=4.1.0" >
</head>
<body>
	<!-- 树 -->
	<input id="roleId" value="${roleEntity.id }" type="hidden" autocomplete="off">
	<div>
		<ul id="treeDemo" class="ztree" style=""></ul>
	</div>
	
	<button onclick="saveRoleMenu()">报存</button>

<script src="${contextPath}/static/Hplus/js/jquery.min.js?v=2.1.4"></script>
<script src="${contextPath }/static/Hplus/js/plugins/layer/layer.min.js"></script>
<script src="${contextPath}/static/plugins/ztree/jquery.ztree.core.js"></script>
<script src="${contextPath}/static/plugins/ztree/jquery.ztree.excheck.js"></script>
	
<script type="text/javascript">
	
function saveRoleMenu() {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	nodes = zTree.getCheckedNodes(true);

	var mids = "" ;
	for(var i in nodes){
		mids += nodes[i].id + "," ;
	}
	
	$.ajax({
		url: "${contextPath}/authority/role/updateRoleMenus",
		data: {mids : mids,rid : $("#roleId").val()},
		type: "post",
		dataType: "json",
		success: function(res) {
			parent.layer.msg("操作成功");
			var mylay = parent.layer.getFrameIndex(window.name);
        	parent.layer.close(mylay);

		}
	});
}
	
$(function() {
	var setting = {
		check: {
			enable: true,
			chkDisabledInherit: true
		},
		data: {
			key: {
				name: "menuName",
				title:"id",
				url:"id"
			},
			simpleData: {
				enable: true,
				idKey: "menuCode",
				pIdKey: "pcode"
				
			}
		}
	};
		
	$.ajax({
		url: "${contextPath}/authority/role/authorityMenuTree/" + $("#roleId").val(),
		type: "get",
		dataType: "json",
		success: function(res){
			
			$(document).ready(function(){
				$.fn.zTree.init($("#treeDemo"), setting, eval(res));		
			});
				
		}
	});
});
</script>
</body>
</html>