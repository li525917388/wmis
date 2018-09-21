<%--
       菜单管理（menu）
  User: Li Dehuan
  Date: 2018/9/21
  Time: 11:02
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>菜单管理</title>

	<!-- 外联样式表 -->
	<link rel="shortcut icon" href="favicon.ico">
	<link rel="stylesheet" href="${contextPath}/static/Hplus/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
	<link rel="stylesheet" href="${contextPath }/static/Hplus/css/plugins/jqgrid/ui.jqgrid.css">
	<link rel="stylesheet" href="${contextPath}/static/Hplus/css/style.css?v=4.1.0" >
	
</head>
<body style="width: 100%;">
	<!-- 你的HTML代码 -->
	<table id="table_list_1"></table>   
    <div id="gridpager"></div>
	
	
	<!-- js -->
	<script src="${contextPath}/static/Hplus/js/jquery.min.js?v=2.1.4"></script>
	<script src="${contextPath }/static/Hplus/js/plugins/jqgrid/jquery.jqGrid.min.js"></script>
	<!-- 国际化jqGrid  js -->
	<script src="${contextPath }/static/Hplus/js/plugins/jqgrid/i18n/grid.locale-cn.js"></script>
	
	<script>
	$.jgrid.defaults.styleUI = "Bootstrap";
	  
	$("#table_list_1").jqGrid({
        url: "${contextPath }/sys/menu",
        datatype: "json",
        height: 250,
        autowidth: true,
        shrinkToFit: true,
        rowNum: 14,
        rowList: [10, 20, 30],
        colNames: ["id", "菜单编码", "菜单名称", "菜单类型", "url", "样例","上级菜单","顺序","描述"],
        colModel: [
        	{name: "id", index: "id", width: 60, sorttype: "int"},
        	{name: "menuCode",index: "menuCode",width: 90 },
        	{name: "menuName", index: "menuName", width: 100 }, 
        	{name: "menuType", index: "menuType", width: 80  }, 
        	{name: "url", index: "url", width: 80 }, 
        	{name: "icon",index: "icon",width: 80}, 
        	{name: "pcode",index: "pcode",width: 80}, 
        	{name: "menuOrder",index: "menuOrder",width: 80}, 
        	{name: "describe",index: "describe",width: 80}
        ],
        pager: "#gridpager",
        viewrecords: true,
        multiselect: true,	//多选
        hidegrid: false
    });
	</script>
</body>
</html>
