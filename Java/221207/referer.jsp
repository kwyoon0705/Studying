<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 어디서 접속했는지 정보를 수집하면 아주 요긴하게 사용할 수 있다. --%>
	어디에서 왔을까?
	<%=request.getHeader("referer")%>
</body>
</html>