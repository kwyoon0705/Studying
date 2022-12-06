<%@page import="kr.human.poll.PollUtil"%>
<%@page import="kr.human.poll.PollVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// 투표하기 파일을 읽어온다.
// 투표할 파일의 이름을 받아오자
String fileName = request.getParameter("file");
if (fileName == null || fileName.trim().length() == 0) { // 파일이름이 넘어오지 않았다면
	fileName = "poll01";
}
PollVO pollVO = PollUtil.readPoll(application.getRealPath("./json/" + fileName + ".json"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사 결과보기</title>
<style type="text/css">
table {
	width: 400px;
	margin: auto;
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
	<table>
		<tr>
			<td class="head">온라인 설문조사하기 ver.0.9</td>
		</tr>
		<tr>
			<td class="title">제목 : <%=pollVO.getTitle()%></td>
		</tr>
		<tr>
			<td style="text-align: right;">전체 투표수 : <%=pollVO.getTotalCount()%></td>
		</tr>
		<%
		String colors[] = "red,orange,yellow,green,blue".split(",");
		for (int i = 0; i < pollVO.getItems().length; i++) {
		%>
		<tr>
			<td><%=i%>번<%=pollVO.getItems()[i]%>(<%=pollVO.getCounts()[i]%>표, <%=pollVO.getPercent(i)%>) <!-- 그래프를 추가해보자. -->
				<hr size="10" align="left" width="<%=pollVO.getPercent(i)%>" color="<%=colors[i % colors.length]%>" /></td>

		</tr>
		<%
		}
		%>
		<tr>
			<td style="text-align: center;"><input type="submit" value="돌 아 가 기 " onclick="location.href='pollForm.jsp?file=<%=fileName%>'"></td>
		</tr>
	</table>
</body>
</html>