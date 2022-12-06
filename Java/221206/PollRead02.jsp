<%@page import="kr.human.poll.PollVO"%>
<%@page import="java.io.FileReader"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// json파일을 읽어서 화면에 출력해보자.
Gson gson = new GsonBuilder().setPrettyPrinting().create();
FileReader fr = null;
PollVO pollVO = null;
try {
	fr = new FileReader(application.getRealPath("./json/poll01.json"));
	pollVO = gson.fromJson(fr, PollVO.class);
} catch (Exception e) {
	e.printStackTrace(); // 예외 추적
} finally {
	fr.close();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=pollVO%>
</body>
</html>