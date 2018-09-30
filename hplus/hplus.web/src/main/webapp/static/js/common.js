

// 页面弹出层
function openWindow(url,title){
	
	layer.open({
		type: 2,
		title: title,
		closeBtn: 1, //不显示关闭按钮
		shadeClose: true,
		shade: 0.6,
		area: ['800px', '600px'],
		content: [url, 'no']
	});
}