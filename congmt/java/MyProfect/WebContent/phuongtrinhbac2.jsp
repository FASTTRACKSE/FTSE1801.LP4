<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="phuongtrinhbac2" method="post">
	Số a: <input id="a" type="text" name="soA" /></br></br>
	Số b: <input id="b" type="text" name="soB" /></br></br>
	Số c: <input id="c" type="text" name="soC" /></br></br>
	<input type="submit" name="pheptinh" value="Giải:"/></br></br>
	
</form>
<script type="text/javascript">
		var rs =$("#form2").validate({
			rules:{
				soA:{
					required: true,
					number: true},
				soB:{
					required: true,
					number: true},
				soC:{
					required: true,
					number: true},
			},
			messages:{
				soA:{
					required: "Vui lòng nhập a",
					number:"Giá trị a chỉ được nhập số"},
				soB:{
					required:"Vui lòng nhập b",
					number:"Giá trị b chỉ được nhập số"},
				soC:{
					required:"Vui lòng nhập b",
					number:"Giá trị c chỉ được nhập số"},
			}
		});
		$("#form2").on("submit", function(){
			if (rs.valid()==true) {
				tinh();
			}
		})
	</script>
<% if(request.getAttribute("ketQua")!=null){
	String tinhToan= (String) request.getAttribute("ketQua"); %>
	Kết quả:<%=tinhToan %>
<% }%>
</body>
</html>