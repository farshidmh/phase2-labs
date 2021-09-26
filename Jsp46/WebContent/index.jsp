<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="handle-error.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%


String responseCheck = request.getParameter("office");

if(responseCheck!=null){	
	
	//response.setStatus(response.SC_MOVED_PERMANENTLY);
	//response.setHeader("Location", "response-redirect.jsp?office="+responseCheck);	
	
	response.sendRedirect("response-redirect.jsp?office="+responseCheck);
	
}


String errorCheck = request.getParameter("error");
if(errorCheck!=null){
	
	
	int x = 0;
	
	if(x==0){
		
		throw new RuntimeException("Sam has raised an exception!!!");
		
		
	}
	
	
	
	
}




%>



<a href="index.jsp?office=azhar"> Office </a>
<br>
<a href="index.jsp?error=1"> Error </a>



</body>
</html>