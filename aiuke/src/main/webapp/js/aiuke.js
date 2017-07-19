function search(name){
	$.ajax({
		url:"http://localhost:8080/aiuke/search.do",
		data:{"name":name},
		dataType:"json",
		type:"post",
		success:function(res){
			if(res.status==1){
				for(var i=0;i<res.data.length;i++){
					var message =res.data[i];
					createTr(message);
				}	
			}
			$("#aiuke").on("click","input",look);
		},
		error:function(){
			alert("搜索失败");
		}
	});
}
function createTr(message){
	var $tr= " <tr>"
        +"<td>"+message.singname+"</td>"
        +"<td>"+message.singer+"</td>"
        +"<td><input type='button' value='查看' name="+message.addr+"></td>"
        +"<td>"+message.beizhu+"</td>"
        +"</tr>";
$("#aiuke").append($tr);
}
function look(){
	var addr = ($(this).prop("name"));
	window.location.href="subpage/"+addr;
}