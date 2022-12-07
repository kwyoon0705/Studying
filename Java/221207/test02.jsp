<%@page import="kr.human.dao.TestDAO"%>
<%@page import="kr.human.vo.TestVO"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// 파일번호를 GET방식으로 받자.
String no = request.getParameter("no");
if (no == null || no.trim().length() == 0) { // 파일번호가 넘어오지 않았다면
	no = "68";
}
// 그 파일이 있는지 확인해보자.
File file = new File(application.getRealPath("./json/test" + no + ".json"));
// 해당 경로에서 파일을 가져오자.

// 해당 파일이 존재하지 않는다면 기본값으로 68을 설정
if (!file.exists()) {
	no = "68";
}

// 이제 파일을 읽어보자.
String path = application.getRealPath("./json/test" + no + ".json");
List<TestVO> list = TestDAO.getInstance().getTest(path);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한자 <%=list.get(0).getD()%>수 <%=list.get(0).getS()%> 시험
</title>
<style type="text/css">
.test {
	border: 1px solid gray;
	padding: 5px;
	margin-bottom: 10px;
	padding-left: 30px;
}
</style>
</head>
<body>
	<h1>
		한자
		<%=list.get(0).getD()%>수
		<%=list.get(0).getS()%>
		시험
	</h1>
	<hr />
	<form action="result.jsp" method="post">
		<%
		for (int i = 0; i < list.size(); i++) {
			TestVO vo = list.get(i);
		%>
		<div class="test">
			<%=vo.getN()%>.
			<%=vo.getQ()%>
			<br />
			<%
			// e1항목에 값이 있으면 4지선다, 없으면 단답형.
			if (vo.getE1() != null && vo.getE1().trim().length() != 0) {
				// 4지선다
				out.println("<label>");
				out.println("<input type='radio' name='answer" + vo.getN() + "' checked='checked' value='1'>");
				out.println(vo.getE1());
				out.println("</label>");
				out.println("<label>");
				out.println("<input type='radio' name='answer" + vo.getN() + "' value='2'>");
				out.println(vo.getE2());
				out.println("</label>");
				out.println("<label>");
				out.println("<input type='radio' name='answer" + vo.getN() + "' value='3'>");
				out.println(vo.getE3());
				out.println("</label>");
				out.println("<label>");
				out.println("<input type='radio' name='answer" + vo.getN() + "' value='4'>");
				out.println(vo.getE4());
				out.println("</label>");
			} else {
				out.println("<input type='text' name='answer" + vo.getN() + "'>");
			}
			%>
		</div>
		<%
		}
		%>
		<input type="hidden" name="no" value="<%=no %>">
		<button>제출하기</button>
	</form>
</body>
</html>