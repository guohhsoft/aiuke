function searchpinglun(addr){
	$.ajax({
		url:"http://localhost:8080/aiuke/pinglun/search.do",
		data:{"addr":addr},
		dataType:"json",
		type:"post",
		success:function(res){
			if(res.data.length!=null){
				for(var i=0;i<res.data.length;i++){
					var pinglun = res.data[i];
					createp(pinglun);
				}
			}
		},
		error:function(){
			alert("加载失败");
		}
	});
	
}

function createp(pinglun){
	var $p="<p>"
        +"<span class="+"username"+">"+pinglun.username+" :</span>"
        +"<span class="+"pinglun"+">"+pinglun.message+"</span>"
        +"<span class="+"time"+">"+pinglun.time+"</span>"
        +"<div class="+"clearfix"+"></div>"
        +"</p> "
        $("#pinglun").append($p);
}


function save(){
	var ok=true;
	var username= getCookie("name");
	if(username==""){
		alert("请先登录，在评论！");
		ok=false;
	}
	var message = $("#neirong").val();
	if(message==""){
		alert("评论不能为空");
		ok=false;
	}
	var addr = window.location.pathname.substring(19);
	if(ok){
		$.ajax({
			url:"http://localhost:8080/aiuke/pinglun/save.do",
			data:{"username":username,"message":message,"addr":addr},
			dataType:"json",
			type:"post",
			success:function(res){
			    alert(res.msg);
			    window.location.href=addr;
			},
		});
	}
}