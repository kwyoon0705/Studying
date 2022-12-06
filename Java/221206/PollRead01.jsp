<%@page import="kr.human.poll.PollUtil"%>
<%@page import="kr.human.poll.PollVO"%>
<%@page import="java.io.FileReader"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// json파일을 읽어서 화면에 출력해보자.
PollVO pollVO = PollUtil.readPoll(application.getRealPath("./json/poll01.json"));

PollUtil.savePoll("./json/poll02.json", pollVO); // 이 파일을 서버에 저장된다.

System.out.print(application.getRealPath("./json/"));
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