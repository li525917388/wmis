<!-- 
-
-用户管理（user）
-User: Li Dehuan
-Date: 2018/9/21
-Time: 11:02
-
 -->
 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
    
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	
	<!-- 外联样式表 -->
	<link rel="shortcut icon" href="favicon.ico">
	<link href="${contextPath}/static/Hplus/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
	<link rel="stylesheet" href="${contextPath }/static/Hplus/css/plugins/jqgrid/ui.jqgrid.css">
	<%-- <link href="${contextPath}/static/Hplus/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
	<link href="${contextPath}/static/Hplus/css/animate.css" rel="stylesheet"> --%>
	<link href="${contextPath}/static/Hplus/css/style.css?v=4.1.0" rel="stylesheet">
	
	
</head>
<body>
	
	<div class="btn_panel">
		 <button class="btn btn-default  dim " type="button">1<i class="fa fa-star"></i></button>
	</div>
	
	<table id="table_list_1"></table>   
    <div id="gridpager"></div>
	
	
	<!-- js -->
	<script src="${contextPath}/static/Hplus/js/jquery.min.js?v=2.1.4"></script>
	<script src="${contextPath }/static/Hplus/js/plugins/jqgrid/jquery.jqGrid.min.js"></script>
	<!-- 国际化jqGrid  js -->
	<script src="${contextPath }/static/Hplus/js/plugins/jqgrid/i18n/grid.locale-cn.js"></script>
	
	<script type="text/javascript">
	$.jgrid.defaults.styleUI = "Bootstrap";
  
    $("#table_list_1").jqGrid({
        url: "${contextPath }/sys/user",
        datatype: "json",
        height: 250,
        autowidth: true,
        shrinkToFit: true,
        rowNum: 14,
        rowList: [10, 20, 30],
        colNames: ["id", "account", "name", "pwd", "sex", "icon"],
        colModel: [
        	{name: "id", index: "id", width: 60, sorttype: "int"},
        	{name: "account",index: "account",width: 90 },
        	{name: "name", index: "name", width: 100 }, 
        	{name: "pwd", index: "pwd", width: 80  }, 
        	{name: "sex", index: "sex", width: 80, align: "right", sorttype: "float"}, 
        	{name: "icon",index: "icon",width: 80}
        ],
        pager: "#gridpager",
        multiselect: true,	//多选
        viewrecords: true,
        caption: '用户管理 <button>新增</button>',
        hidegrid: false
    });
		
	</script>
</body>
</html>