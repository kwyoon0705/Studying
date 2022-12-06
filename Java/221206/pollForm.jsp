<%@page import="kr.human.poll.PollUtil"%>
<%@page import="kr.human.poll.PollVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// 투표하기 파일을 읽어온다.
PollVO pollVO = PollUtil.readPoll(application.getRealPath("./json/poll01.json"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사 만들기</title>
<style type="text/css">
table {
	width: 400px;
	margin: auto;
	border: 1px solid gray;
}

.head {
	text-align: center;
	background-color: black;
	color: white;
	font-weight: bold;
	padding: 5px;
}

.title {
	font-weight: bold;
	padding: 10px;
}
</style>
</head>
<body>
	<form action="pollOk.jsp" method="post">
		<table>
			<tr>
				<td class="head">온라인 설문조사하기 ver.0.9</td>
			</tr>
			<tr>
				<td class="title">제목 : <%=pollVO.getTitle()%></td>
			</tr>
			<%
			for (int i = 0; i < pollVO.getItems().length; i++) {
			%>
			<tr>
				<td><label> <input type="radio" name="poll" value="<%=i%>" <%=i == 0 ? "checked='checked'" : ""%> /><%=pollVO.getItems()[i]%>
				</label></td>
			</tr>
			<%
			}
			%>
			<tr>
				<td style="text-align: center;"><input type="submit" value="투 표 하 기 "> <input type="button" value="결 과 보 기 " onclick="location.href='pollResult.jsp'"></td>
			</tr>
		</table>
	</form>
</body>
</html>