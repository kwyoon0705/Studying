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
<title>한자 급수 시험 읽기여부 확인</title>
</head>
<body>
	<%=list%>
</body>
</html>