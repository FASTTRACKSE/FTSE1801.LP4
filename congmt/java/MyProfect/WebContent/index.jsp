<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mai Thành Công</title>
</head>
<body>
<%for(int i =0; i<1;i++){%>
	<h1><b><%=i+1%>. Hello Mai Thành Công.!!</b></h1>
	<h2>Hợi Là con heo cha</h2>
	<h3>Và là cha của con heo con</h3>
	<%} %>

	<h1>Login</h1></br></br>
	<form action="Login" method="post">
	Username: <input type="text" name="user" /></br></br>
	Password: <input type="password" name="pass" /></br></br>
	<input type="submit" value="Login" />
	</form>
</body>

</html>