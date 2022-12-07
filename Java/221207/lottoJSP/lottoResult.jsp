<%@page import="java.util.Random"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 넘어온 값을 받자!!!
	request.setCharacterEncoding("UTF-8");

	// POST전송이 아니면 에러발생!!! 이것을 막아보자
	if(!request.getMethod().equals("POST")){
		response.sendRedirect("lotto.jsp");
		return;
	}

	// 같은 name 속성이 여러개면 getParameterValues로 받아야 한다. 
	String[] lotto = request.getParameterValues("lotto"); 
	int lotto2[] = new int[45];   // 로또 번호 생성할 배열
	int makeLotto[] = new int[6]; // 결과 배열
	for(String s : lotto){ // 제외할 값에 배열을 2로 초기화
		lotto2[Integer.parseInt(s)-1] = 2;
	}
	Random rnd = new Random(); // 난수
	int temp;
	for(int i=0;i<6;i++){
		do{
			temp = rnd.nextInt(45);
		}while(lotto2[temp]!=0); // 0인 있는  위치를 찾아
		lotto2[temp] = 1; // 1로 선택
	}
	int cnt = 0;
	// 배열값이 1인 위치를 저장하면 됨
	for(int i=0;i<lotto2.length;i++){ 
		if(lotto2[i]==1) makeLotto[cnt++] = i+1;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	제외할번호 : 
	<%=Arrays.toString(lotto) %>
	<br />
	생성한 로또번호 : <%=Arrays.toString(makeLotto) %>
</body>
</html>