<%@page import="java.util.List"%>
<%@page import="javax.persistence.criteria.Root"%>
<%@page import="com.simplilearn.model.Product"%>
<%@page import="javax.persistence.criteria.CriteriaQuery"%>
<%@page import="javax.persistence.criteria.CriteriaBuilder"%>
<%@page import="com.simplilearn.util.HibernateUtil"%>
<%@page import="org.hibernate.Session"%>
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





<table border="1" width="100%">

<tr>
	<td>Item Id</td>
	<td> Item Name </td>
	<td> Item Price </td>
	<td> Action </td>
</tr>



<%

Session se = HibernateUtil.getSessionFactory().openSession();

CriteriaBuilder cb = se.getCriteriaBuilder();

CriteriaQuery<Product> cr = cb.createQuery(Product.class);
	
Root<Product> root  = cr.from(Product.class);

//cr.select(root).where(   cb.ge(root.get("price") , (double) 200 )  );

org.hibernate.Query<Product> query = se.createQuery(cr);

List<Product> products = query.getResultList();


for( Product p : products ) {
	
	//out.print("<tr><td>"+p.getProductId()+"</td><td>...")
	%>
	
	<tr>
	<td><%=p.getProductId() %></td>
	<td><%=p.getName() %></td>
	<td><%=p.getPrice() %></td>
	<td> 

<a href="delete?pid=<%=p.getProductId() %>"> Delete </a>

|

<a href="update.jsp?pid=<%=p.getProductId() %>"> Update </a>


 </td>
</tr>
	
	<%
}
se.close();
%>





</table>









</body>
</html>