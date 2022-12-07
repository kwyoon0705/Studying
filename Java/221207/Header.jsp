<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- request객체를 이용하면 HTTP Header 정보를 얻을 수 있다. --%>
	<h2>모든 헤더 정보 보기</h2>
	<%
	Enumeration<String> headerNames = request.getHeaderNames();
	while (headerNames.hasMoreElements()) {
		String headerName = headerNames.nextElement();
		Enumeration<String> header = request.getHeaders(headerName);
		while (header.hasMoreElements()) {
			String headerValue = header.nextElement();
			out.println(headerName + " : " + headerValue + "<br>");
		}
		out.println("<hr>");
	}
	%>
</body>
</html>