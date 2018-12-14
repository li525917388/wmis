var oper = $("#oper").val();
if(oper == "view"){

	$("input").attr("readOnly","readOnly");
	$("select").attr("disabled","disabled");
}else{
	
	$("input").removeAttr("readOnly");
	$("select").removeAttr("disabled");
}

//以下为修改jQuery Validation插件兼容Bootstrap的方法，没有直接写在插件中是为了便于插件升级
$.validator.setDefaults({
    highlight: function (element) {
        $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
    },
    success: function (element) {
        element.closest('.form-group').removeClass('has-error').addClass('has-success');
    },
    errorElement: "span",
    errorPlacement: function (error, element) {
        if (element.is(":radio") || element.is(":checkbox")) {
            error.appendTo(element.parent().parent().parent());
        } else {
            error.appendTo(element.parent());
        }
    },
    errorClass: "help-block m-b-none",
    validClass: "help-block m-b-none",
    submitHandler: function(form) {
    	///这里写提交事件内容
    	
        var formData = new FormData(form);	//获取表单数据，并封装成FormData对象
        
        var menuid = formData.get("menuid");	//获取主键
        
        if(menuid == ""){
        	
        	menuid = 0;
        }
        
        //请求
        $.ajax({
        	url: "/hplus/sys/menu/" + menuid,
        	data: formData,
        	type: "post",
        	async: false,
        	processData:false,
        	contentType:false,
        	//dataType: "json",
        	success: function(res){

        		if(res > 0){
        			
        			window.parent.reloadGrid();//刷新表格数据
        			
        			layer.msg("操作成功");
        			
        			setTimeout(function(){
        				
        				var mylay = parent.layer.getFrameIndex(window.name);
        				parent.layer.close(mylay);
        			},1200);

        		}else{
        			
        			layer.msg("操作失败！！！");
        		}
        	}
        });
    }

});

//邮政编码验证   
jQuery.validator.addMethod("english", function(value, element) {   
    var tel = /^[a-zA-Z_]*$/;
    return this.optional(element) || (tel.test(value));
}, "只允许填写大小写英文字母");

//查看图标点击事件
function lookIconClick(){
	
	parent.layer.open({
		type: 2,
		title: true,
		closeBtn: 1, //不显示关闭按钮
		shadeClose: true,
		shade: 0.2,
		area: ['1200px', '700px'],
		content: ["http://fontawesome.dashgame.com/"]
	});
}

$().ready(function () {

    var icon = "<i class='fa fa-times-circle'></i> ";
    var validator = $("#signupForm").validate({
        rules: {
           /* menuName: "required",*/
            menuCode: {
            	english: true,
            	maxlength: 25
            },
            url: {
            	maxlength: 60
            },
            icon: {
            	maxlength: 60
            },
            menuOrder: {
                digits: true
            },
            describe: {
                maxlength: 100
            }
        },
        messages: {
           /* firstname: icon + "请输入你的姓",*/
            menuCode: {
                maxlength: icon + "不能超过25个字符"
            },
            url: {
                 maxlength: icon + "不能超过60个字符"
            },
            icon: {
                 maxlength: icon + "不能超过60个字符"
            },
            menuOrder: {
                digits: icon + "只能输入数字"
            },
            describe: {
            	maxlength: icon + "不能超过100个字符"
            }
        }
    });

    // propose username by combining first- and lastname
    $("#menuType").change(function () {
        
    	if($(this).val() == 1){
    		$(".ldh_parentmenu_group").show();
    		$(".ldh_childmenu_group").hide();
        }else{
        	$(".ldh_parentmenu_group").hide();
        	$(".ldh_childmenu_group").show();
        }
    });
 
    //重置
    $("#resetBtn").click(function(){
    	validator.resetForm();
    });
    
    
    ///加载玩之后执行的事件
    $("#menuType").change();		//改变菜单类型的事件
});