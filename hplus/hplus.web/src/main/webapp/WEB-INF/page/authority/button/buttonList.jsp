<%--
       角色管理（button）
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
	<title>角色管理</title>

	<!-- 外联样式表 -->
	<link rel="shortcut icon" href="favicon.ico">
	<link rel="stylesheet" href="${contextPath}/static/Hplus/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
	<link rel="stylesheet" href="${contextPath }/static/Hplus/css/plugins/jqgrid/ui.jqgrid.css">
	<link href="${contextPath}/static/Hplus/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
	<link rel="stylesheet" href="${contextPath}/static/Hplus/css/style.css?v=4.1.0" >
	
</head>
<body style="width: 100%;">

	<div class="btn_panel">
		<button type="button" onclick="addBase()" class="btn btn-sm btn-primary">新增</button>
		<button type="button" onclick="editBase()" class="btn btn-sm btn-info">编辑</button>
		<button type="button" onclick="delBase()" class="btn btn-sm btn-danger">删除</button>
		<button type="button" onclick="viewBase()" class="btn btn-sm btn-success">查看</button>
		<button type="button" onclick="reloadGrid()" class="btn btn-sm btn-success">刷新</button>
	</div>
	
	<!-- 你的HTML代码 -->
	<table id="menu_grid"></table>   
    <div id="gridpager"></div>
	
	
	<!-- js -->
	<script src="${contextPath}/static/Hplus/js/jquery.min.js?v=2.1.4"></script>
	<script src="${contextPath }/static/Hplus/js/plugins/layer/layer.min.js"></script>
	<script src="${contextPath }/static/Hplus/js/plugins/jqgrid/jquery.jqGrid.min.js"></script>
	<!-- 国际化jqGrid  js -->
	<script src="${contextPath }/static/Hplus/js/plugins/jqgrid/i18n/grid.locale-cn.js"></script>
	<!-- 公共js -->
	<script src="${contextPath}/static/js/common.js?v=2.1.4"></script>
	
	<script>
	$.jgrid.defaults.styleUI = "Bootstrap";

	$("#menu_grid").jqGrid({
        url: "${contextPath }/authority/button",
        datatype: "json",
        height: 250,
        autowidth: true,
        shrinkToFit: true,
        rowNum: 14,
        rowList: [10, 20, 30],
        colNames: ["id", "按钮名称", "按钮编码", "按钮样式", "按钮事件", "顺序", "描述"],
        colModel: [
        	{name: "id", index: "id", width: 50, sorttype: "int"},
        	{name: "btnCode",index: "btnCode",width: 90 },
        	{name: "btnName", index: "btnName", width: 100 }, 
        	{name: "btnClass", index: "btnClass", width: 150  }, 
        	{name: "btnEvent", index: "btnEvent", width: 100 }, 
        	{name: "btnOrder", index: "btnOrder", width: 50  }, 
        	{name: "btnDescribe",index: "btnDescribe",width: 150}
        ],
        pager: "#gridpager",
        viewrecords: true,
        multiselect: true,	//多选
       	multiboxonly: true, 
        hidegrid: false
    });
	
	//添加
	function addBase(){
		
		openWindow("${contextPath }/authority/button/edit/0");
	}
	
	//编辑
	function editBase(){
		
		var ids = $("#menu_grid").jqGrid("getGridParam","selarrrow");
		
		if(ids.length == 1){
			
			openWindow("${contextPath }/authority/button/edit/" + ids);
		}else if(ids.length == 0){
			
			layer.msg("请选择一条数据");
		}else{
			
			layer.msg("只能选择一条数据");
		}

	}
	
	//查看
	function viewBase(){
		
		var ids = $("#menu_grid").jqGrid("getGridParam","selarrrow");
		
		if(ids.length == 1){
			
			openWindow("${contextPath }/authority/button/edit/" + ids + "?oper=view");
		}else if(ids.length == 0){
			
			layer.msg("请选择一条数据");
		}else{
			
			layer.msg("只能选择一条数据");
		}

	}
	
	
	//删除
	function delBase(){
		
		var selects = $("#menu_grid").jqGrid("getGridParam","selarrrow");

		if(selects.length > 0){
			
			var id = "";
			
			for(var i in selects){
				
				id += selects[i] + "#";
			}
			
			$.ajax({
				url: "${contextPath }/authority/button/" + id,
				type: "DELETE",
				//data: {ids: ids},
				success: function(res){
					
					if(res > 0){
						
						layer.msg("删除成功");
						reloadGrid();
					}else{
						
						layer.msg("删除失败");
					}
					
				}
			});
		}else{
			
			layer.msg("请选择一条数据");
		}
	}
	
	//刷新数据表格
	function reloadGrid(){

		jQuery("#menu_grid").trigger("reloadGrid");
	}
	</script>
</body>
</html>
