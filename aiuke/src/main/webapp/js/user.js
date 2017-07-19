
function login(){
	var name = $("#count").val().trim();
	var password = $("#password").val().trim();
	//格式检查之前 先对内容进行清空
	$("#count_msg").html("");
	$("#password_msg").html("");
	//格式检测
	var ok=true;
	if(name==""){
		$("#count_msg").html("帐号不能为空");
		ok=false;
	}
	else if(password==""){
		$("#password_msg").html("密码不能为空");
		ok=false;
	}
	if(ok==true){  // 检测格式是否通过
		// 调用ajax发送请求
		$.ajax({
			url:"http://localhost:8080/aiuke/user/login.do",
			type:"post",
			data:{"name":name,"password":password},
			dataType:"json",
			success:function(res){
				if(res.status==0)
					$("#count_msg").html(res.msg);
				else if(res.status==1)
					$("#password_msg").html(res.msg);
				else{
					var name = res.data.name;
					var password = res.data.password;
					SetCookie("name",name);
					SetCookie("password", password);
					window.location.href="index.html";
					
				}
					
				
			},
			error:function(){
				alert("登录失败")
			}
		});
	}
	
}


function adduser(){
	//清空提示信息
	$("#warning_1").html("");
	$("#warning_2").html("");
	$("#warning_3").html("");
	var ok = true;
	var name = $("#name").val();
	var password = $("#password").val();
	var password_c = $("#password_c").val();
	var telephone = $("#tel").val();
	var email = $("#email").val();
	//alert(typeof quanxian);
	if(name==""){
		$("#warning_1").html("姓名不能为空");
		$("#warning_1").show();
		ok=false;
	}
	if(password==""){
		$("#warning_2").html("密码不能为空");
		$("#warning_2").show();
		ok=false;
	}else if(password.length>0&&password.length<6){
		$("#warning_2").html("密码少于6位");
		$("#warning_2").show();
		ok=false;
	}
	if(password!=password_c){
		$("#warning_3").html("密码不一致");
		$("#warning_3").show();
		ok=false;
	}
	if(ok){
	$.ajax({
		url:"http://localhost:8080/aiuke/user/save.do",
		dataType:"json",
		data:{"name":name,"password":password,"telephone":telephone,"email":email},
		type:"post",
		success:function(res){
			console.log(res);
			if(res.status==0){
				alert("添加成功");
				window.location.href="login.html";
			}
		},
		error:function(){
			alert("添加失败");
		}
	});
	}
}
function update(){
	//清空提示信息
	$("#warning_1").html("");
	$("#warning_2").html("");
	$("#warning_3").html("");
	var pass=getCookie("password");
	var ok=true;
	//获取密码
	var password=$("#pass").val();
	//获取确认密码
	var npsw=$("#pass1").val();
	//获取确认密码2
	var npsw1=$("#pass2").val();
	if(password==""){
		// 父子选择器 #warning父亲 span孩子(这里仅有一个不需要下标确定)
		$("#warning_1").html("密码不能为空");
		$("#warning_1").show();
		ok=false;
	}else if(pass!=password){
		$("#warning_1").html("原密码错误");
		$("#warning_1").show();
		ok=false;
	}
	if(npsw==""){
		$("#warning_2").html("密码不能为空");
		$("#warning_2").show();
		ok=false;
	}else if(npsw.length>0&&npsw.length<6){
		$("#warning_2").html("密码少于6位");
		$("#warning_2").show();
		ok=false;
	}
	if(npsw1!=npsw){
		$("#warning_3").html("密码不一致");
		$("#warning_3").show();
		ok=false;
	}
	var name = getCookie("name");
	if(ok){
		SetCookie("password", npsw);
	$.ajax({
		url:"http://localhost:8080/aiuke/user/update.do",
		dataType:"json",
		data:{"name":name,"password":npsw},
		type:"post",
		success:function(res){
			alert(res.msg);
			window.location.href="user.html";
		},
		error:function(){
			alert("添加失败");
		}
	});
	}
	
}