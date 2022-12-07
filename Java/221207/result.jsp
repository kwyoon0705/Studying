<%@page import="kr.human.dao.TestDAO"%>
<%@page import="kr.human.vo.TestVO"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
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
	<%
	int result = 0;
	for (int i = 0; i < list.size(); i++) {
		TestVO vo = list.get(i);
	%>
	<div class="test">
		<%=vo.getN()%>.
		<%=vo.getQ()%>
		<br /> 정답 :
		<%=vo.getA()%>
		제출한 답 :
		<%=request.getParameter("answer" + vo.getN())%>
		===>
		<%
		if (vo.getA().equals(request.getParameter("answer" + vo.getN()))) {
			result++;
			out.println("정답");
		} else {
			out.println("오답");

		}
		%>
	</div>
	<%
	}
	%>
	<h2><%=list.size()%>문제 중
		<%=result%>개 맞음
	</h2>
	<h2>
		정답률 :
		<%=String.format("%2d%%", (int) ((double) result / list.size() * 100))%></h2>
	<%
	if ((int) ((double) result / list.size() * 100) >= 60) {
	out.println("<h2>합격입니다!</h>");
	}else{
	out.println("<h2>불합격입니다..</h>");
	}
	%>
</body>
</html>