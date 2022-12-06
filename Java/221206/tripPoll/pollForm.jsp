<%@page import="kr.study.poll.TripUtil"%>
<%@page import="kr.study.poll.TripVO"%>
<%@page import="kr.human.poll.PollUtil"%>
<%@page import="kr.human.poll.PollVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// 투표할 파일의 이름을 받아오자
String fileName = request.getParameter("file");
if (fileName == null || fileName.trim().length() == 0) { // 파일이름이 넘어오지 않았다면
	fileName = "poll03";
}
// 투표하기 파일을 읽어온다.
TripVO vo = TripUtil.readVO(application.getRealPath("./json/" + fileName + ".json"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>어디로 여행을 갈까</title>
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
		<!-- 파일이름을 숨겨서 넘기자 -->
		<input type="hidden" name="file" value="<%=fileName%>">
		<table>
			<tr>
				<td class="head">온라인 설문조사하기 ver.0.9</td>
			</tr>
			<tr>
				<td class="title">제목 : <%=vo.getTitle()%></td>
			</tr>
			<%
			for (int i = 0; i < vo.getItems().length; i++) {
			%>
			<tr>
				<td><label> <input type="radio" name="poll" value="<%=i%>" <%=i == 0 ? "checked='checked'" : ""%> /><%=vo.getItems()[i]%>
				</label></td>
			</tr>
			<%
			}
			%>
			<tr>
				<td style="text-align: center;"><input type="submit" value="투 표 하 기 "> <input type="button" value="결 과 보 기 " onclick="location.href='pollResult.jsp?file=<%=fileName%>'"></td>
			</tr>
		</table>
	</form>
</body>
</html>