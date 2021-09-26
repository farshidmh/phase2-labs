<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%


if(request.getParameter("error")!=null){
	
	out.print("<h1> ERRRRRORRR </h1> ");
	
}



%>




<form method="post" action="login.jsp">


	Name: <input type="text" name="name">
	<br>
	Password: <input type="password" name="pwd">
	<br>
	<button type="submit"> Send </button>
	

</form>



</body>
</html>