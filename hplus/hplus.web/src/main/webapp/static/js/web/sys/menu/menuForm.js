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

        var formData = new FormData(form);	//获取表单数据，并封装成FormData对象
        
        $.ajax({
        	url: "/hplus/sys/menu",
        	data: formData,
        	type: "POST",
        	processData:false,
            contentType:false,
        	//dataType: "json",
        	success: function(res){
        		alert(res);
        		if(res == true){
        			debugger;
        			var index= parent.layer.getFrameIndex(Window.name);
        			parent.layer.close(index);
        		}
        	}
        });
    }

});

//邮政编码验证   
jQuery.validator.addMethod("english", function(value, element) {   
    var tel = /^[a-zA-Z]*$/;
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
    $("#signupForm").validate({
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
 
    
});