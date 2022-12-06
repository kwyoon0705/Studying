<%@page import="kr.study.poll.TripUtil"%>
<%@page import="kr.study.poll.TripVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
TripVO vo = TripUtil.readVO(application.getRealPath("./json/poll03.json"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=vo%>
</body>
</html>