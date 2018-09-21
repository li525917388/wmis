<%--
  Created by IntelliJ IDEA.
  User: Li Dehuan
  Date: 2017/3/14
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>开始使用layui</title>
<link rel="stylesheet" href="${contextPath }/static/layui/css/layui.css">
</head>
<body style="width: 100%;">
	<!-- 你的HTML代码 -->
	<table id="demo" lay-filter="test"></table>
	<script src="${contextPath }/static/layui/layui.js"></script>
	
	<script>
		layui.use('table', function() {

			var table = layui.table;

			//第一个实例
			table.render({
				elem : '#demo',
				height : "full-100",
				cellMinWidth: 80,
				url : '${contextPath }/sys/menu', //数据接口
				skin : "row",	//用于设定表格风格，若使用默认风格不设置该属性即可.line （行边框风格）  row （列边框风格）  nob （无边框风格）
				even : true,
				page : true,  //开启分页
				response: {
				    statusName: 'code' //规定数据状态的字段名称，默认：code
				    ,statusCode: 200 //规定成功的状态码，默认：0
				    ,msgName: 'msg' //规定状态信息的字段名称，默认：msg
				    ,countName: 'count' //规定数据总数的字段名称，默认：count
				    ,dataName: 'data' //规定数据列表的字段名称，默认：data
			  	},
				cols : [ [ //表头
				{
					field : 'id',
					title : 'ID',
					width : 80,
					sort : true
				}, 
				{
					field : 'menuName',
					title : '菜单名称',
					//fixed : 'left',
					width : 140
				}, 
				{
					field : 'menuCode',
					title : '菜单编码',
					width : 140,
					sort : true
				}, 
				{
					field : 'menuType',
					title : '菜单类型',
					width : 100,
					sort : true
				}, 
				{
					field : 'url',
					title : '地址',
					width : 200
				}, 
				{
					field : 'icon',
					title : '样式',
					width : 150
				}, 
				{
					field : 'pcode',
					title : '上级菜单',
					width : 140
				}, 
				{
					field : 'menuOrder',
					title : '顺序',
					width : 80
				}] ]
			});

		});
	</script>
</body>
</html>
