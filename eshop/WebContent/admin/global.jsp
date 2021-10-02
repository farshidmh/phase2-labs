<%@page import="com.simplilearn.model.User"%>
<%@page import="com.simplilearn.util.HibernateUtil"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%

Session se = HibernateUtil.getSessionFactory().openSession();

int userId = (int) session.getAttribute("userId");


User adminUser = se.load(User.class, userId);


out.print("Welcom, "+adminUser.getName()+" "+adminUser.getFamily());





%>
<hr>

<a href="list_product.jsp"> Dashboard </a> | 

<a href="new_product.jsp"> New Product </a> | 

<a href="logout"> Logout </a>

<hr>