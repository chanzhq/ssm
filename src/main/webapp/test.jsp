<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="/test/lei.do">
	<input name="id" value="haha"/>
	<input name="id" value="fuck"/>
	<input type="submit"/>
	<select id='select'></select>
</form>
<script src="assets/plugins/jquery-1.10.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		var res = $.ajax({
			data : "",
			dataType:"jsonp", 
			type:"get",
			jsonp:"callback",
			type:"text",
			url : "http://localhost:8080/eservice_mysql/ebiz/client/insInput.action?action=initCity&provinceCode=330000&&ajax=true",
		}
		);
		$("#select").html(res.responseText);
	})
</script>
</body>
</html>