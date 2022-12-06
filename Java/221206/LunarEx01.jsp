<%@page import="kr.human.util.CalendarUtil"%>
<%@page import="kr.human.util.LunarVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음력 달력 보이기</title>
<!-- 엑시콘(이쁜 아이콘) 사용하기 -->
<link rel="stylesheet" type="text/css" href="axicon/axicon.min.css" />

<style type="text/css">
table {
	width: 1000px;
	margin: auto;
	padding: 5px;
}

td {
	border: 1px solid gray;
	padding: 5px;
	text-align: center;
}
</style>
</head>
<body>
	<%
	// 년도와 월을 get방식으로 받아보자!!!
	// 만년 달력이므로 년도와 월을 받아서 변수에 초기화 하자
	Calendar cal = Calendar.getInstance();
	int yy = cal.get(Calendar.YEAR); // 현재 년도 
	int mm = cal.get(Calendar.MONTH) + 1; // 현재 월 
	// 넘어온 년/월을 받아 숫자로 변경하자
	try {
		yy = Integer.parseInt(request.getParameter("yy"));
	} catch (Exception e) {
		; // 에러 발생시(넘어오지 않거나 숫자가 아니면) 아무짓도 하지 않는다. 현재 년을 가진다. 
	}
	try {
		mm = Integer.parseInt(request.getParameter("mm"));
	} catch (Exception e) {
		; // 에러 발생시(넘어오지 않거나 숫자가 아니면) 아무짓도 하지 않는다. 현재 월을 가진다. 
	}
	// 월이 계속 늘어나다보면 13월이 되어 버린다. 13월일 경우 년도 증가 월은 1월로 변경
	if (mm >= 13) {
		yy++;
		mm = 1;
	}
	// 월이 계속 줄어들다 보면 0월이 되어 버린다. 0월일 경우 년도 감소 월은 12월로 변경
	if (mm <= 0) {
		yy--;
		mm = 12;
	}
	// 년도는 1 이상이어야 한다.
	if (yy <= 0) {
		yy = cal.get(Calendar.YEAR); // 현재 년도 
	}
	// 음력데이터를 받아보자!!!
	List<LunarVO> list = CalendarUtil.readLunarData(yy, mm);
	%>
	<table>
		<tr>
			<td colspan="5" style="font-size: 18pt; text-align: center;">
				<%-- 링크를 걸때 ?로 시작하면 자신의 파일이 된다. --%> <%-- 년 감소 --%> <a href="?yy=<%=yy - 1%>&mm=<%=mm%>">
					<i class="axi axi-skip-back"></i>
				</a> <%-- 월 감소 --%> <a href="?yy=<%=yy%>&mm=<%=mm - 1%>">
					<i class="axi axi-rewind"></i>
				</a> <%=String.format("%04d년 %02d월", yy, mm)%> <%-- 월 증가 --%> <a href="?yy=<%=yy%>&mm=<%=mm + 1%>">
					<i class="axi axi-fast-forward"></i>
				</a> <%-- 년 증가 --%> <a href="?yy=<%=yy + 1%>&mm=<%=mm%>">
					<i class="axi axi-skip-forward"></i>
				</a>
			</td>
		</tr>
		<tr>
			<td>양력</td>
			<td>음력</td>
			<td>간지</td>
			<td>요일</td>
			<td>율리우스력</td>
		</tr>
		<%
		for (LunarVO vo : list) {
			out.println("<tr>");
			out.println("<td>" + vo.getSolar1() + "</td>");
			out.println("<td>" + vo.getLunar() + "</td>");
			out.println("<td>" + vo.getGanji() + "</td>");
			out.println("<td>" + vo.getWeek() + "</td>");
			out.println("<td>" + vo.getSolar2() + "</td>");
			out.println("</tr>");
		}
		%>
	</table>
</body>
</html>