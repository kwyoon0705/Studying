<%@page import="kr.human.util.LunarVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.human.util.CalendarUtil"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Calendar cal = Calendar.getInstance();
int yy = cal.get(Calendar.YEAR);
int mm = cal.get(Calendar.MONTH) + 1;

try {
	yy = Integer.parseInt(request.getParameter("yy"));
} catch (Exception e) {
	; // 에러 발생시(넘어오지 않거나 숫자가 아니면) 아무 명령도 수행하지 않겠다는 의미.
}
try {
	mm = Integer.parseInt(request.getParameter("mm"));
} catch (Exception e) {
	; // 에러 발생시(넘어오지 않거나 숫자가 아니면) 아무 명령도 수행하지 않겠다는 의미.
}
// 월이 계속 늘어나다 보면 13월이 되니 13월부터는 다시 1월로 시작해야한다.
if (mm >= 13) {
	yy++;
	mm = 1;
}
//월이 계속 줄어들다 보면 0월이 되니 0월부터는 다시 12월로 시작해야한다.
if (mm <= 0) {
	yy--;
	mm = 12;
}
// 연도는 1이상이어야한다.
if (yy <= 0) {
	yy = cal.get(Calendar.YEAR);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음력이 나오는 달력만들기</title>
<!-- 엑시콘 적용하기 -->
<link rel="stylesheet" type="text/css" href="axicon/axicon.min.css" />
<style type="text/css">
table {
	width: 700px;
	margin: auto;
	border: none;
}

th {
	width: 100px;
	background-color: silver;
	border: 1px solid gray;
	padding: 5px;
}

td {
	width: 100px;
	border: 1px solid gray;
	padding: 5px;
	height: 60px;
	text-align: right;
	vertical-align: top;
}

.title {
	text-align: center;
	font-size: 18pt;
	border: none;
}

a:link {
	text-decoration: none;
	color: gray;
}

a:active {
	text-decoration: none;
	color: gray;
}

a:hover {
	text-decoration: none;
	color: black;
}

a:visited {
	text-decoration: none;
	color: gray;
}
</style>
</head>
<body>
	<i class="axi axi-ion-load-a axi-spin"></i>
	<i class="axi axi-ion-load-b axi-spin"></i>
	<i class="axi axi-ion-load-c axi-spin"></i>
	<i class="axi axi-ion-load-d axi-spin"></i>
	<i class="axi axi-bicycle-man"></i> Normal
	<br />
	<i class="axi axi-bicycle-man axi-rotate-90"></i> axi-rotate-90
	<br />
	<i class="axi axi-bicycle-man axi-rotate-180"></i> axi-rotate-180
	<br />
	<i class="axi axi-bicycle-man axi-rotate-270"></i> axi-rotate-270
	<br />
	<table>
		<tr>
			<td colspan="2" class="title">
				<%-- 링크를 걸때 ?로 시작하면 자신의 파일이 된다. --%> <%-- 월 증가 --%> <%-- 연 증가 <--%> <a href="?yy=<%=yy - 1%>&mm=<%=mm%>">
					<i class="axi axi-skip-back"></i>
				</a> <a href="?yy=<%=yy%>&mm=<%=mm - 1%>">
					<i class="axi axi-rewind"></i>
				</a>
			</td>
			<td colspan="3" class="title"><%=String.format("%04d년 %02d월", yy, mm)%></td>
			<td colspan="2" class="title">
				<%-- 월 증가 --%> <%-- 연 증가 --%> <a href="?yy=<%=yy%>&mm=<%=mm + 1%>">
					<i class="axi axi-fast-forward"></i>
				</a> <a href="?yy=<%=yy + 1%>&mm=<%=mm%>">
					<i class="axi axi-skip-forward"></i>
				</a>
			</td>
		</tr>
		<tr>
			<th>일</th>
			<th>월</th>
			<th>화</th>
			<th>수</th>
			<th>목</th>
			<th>금</th>
			<th>토</th>
		</tr>
		<tr>
			<%
			// 1달의 음력데이터 읽어오기
			List<LunarVO> list = CalendarUtil.readLunarData(yy, mm);

			// 1일의 요일과 그달의 마지막 날짜가 필요하다.
			int week = list.get(0).getWeekDateToInteger();
			int lastday = list.size();
			// 1일의 요일을 맞추기 위하여 앞에 공백을 출력해준다.
			for (int i = 0; i < week; i++) {
				out.println("<td>&nbsp;</td>");
			}
			for (int i = 1; i <= lastday; i++) {
				// 토요일이면 다음줄을 만들어준다.
				week = CalendarUtil.getWeekday(yy, mm, i);
				switch (week) {
				case 0:
					out.println("<td style='color:red'>");
					break;
				case 6:
					out.println("<td style='color:blue'>");
					break;
				default:
					out.println("<td style='color:black'>");
					break;
				}
				out.println(i);// 양력날짜
				LunarVO vo = list.get(i - 1);
				out.println("<br><span style='font-size:8pt;'>");// 음력날짜
				out.println("음력 " + vo.getLunarMonth() + "月 " + vo.getLunarDate() + "日<br>");
				out.println("(" + vo.getGanjiDateH() + ")");
				out.println("</span><br>");
				// 이사하기 좋은날 표시
				if (vo.getLunarDate() % 10 == 9 || vo.getLunarDate() % 10 == 0) {
					out.println("<i class=\"axi axi-truck\"></i>");
				}
				out.println("</td>");

				if (week == 6) {
					out.println("</tr>");
					if (i < lastday) {
				out.println("<tr>");
					}
				}
			}
			if (week != 6) {// 마지막 요일이 토요일이 아니라면 뒤에 빈칸을 출력해줘야한다.
				for (int i = week; i < 6; i++) {
					out.println("<td>&nbsp;</td>");
				}
				out.println("</tr>");
			}
			%>
		</tr>
	</table>
</body>
</html>