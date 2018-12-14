function getContextPath(){
	
	return $("#contextPath_input").val();
}

// 页面弹出层
function openWindow(url,title){
	
	var index = layer.open({
		type: 2,
		title: title,
		closeBtn: 1, //不显示关闭按钮
		shadeClose: true,
		shade: 0.6,
		area: ['800px', '600px'],
		content: [url, 'no']
	});
	
	return index;
}

//退出
function exitLogin() {

	layer.confirm('是否退出本系统？', {
		btn: ['确定','取消'] //按钮
	}, function(){
		window.location.href = getContextPath() + '/sys/user/exit';
		
	}, function(){
		
	});
}