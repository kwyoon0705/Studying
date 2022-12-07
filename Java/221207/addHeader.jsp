<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- request객체의 반대개념이 response객체이다. --%>
	<%
	response.addHeader("name", URLEncoder.encode("kimc 한글을 넣으려면 인코딩해야해", "UTF-8") );
	response.addDateHeader("today", new Date().getTime());
	response.addIntHeader("age", 37);
	%>
</body>
</html>