<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="global.jsp"></jsp:include>


<br>


<form method="post" action="newProduct">

Name: <input type="text" name="pName">


<br>

Price: <input type="price" name="pPrice" >


<br>


Image URL: <input type="price" name="pImg" >


<br>


Image Height: <input type="price" name="imgH" >


<br>


Image Width: <input type="price" name="imgW" >


<br>






<button type="submit"> Save </button>


</form>











</body>
</html>