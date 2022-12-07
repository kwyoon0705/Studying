<%@page import="java.util.Random"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!
	public int[] getLotto(String[] lotto){
		int lotto2[] = new int[45];   // 로또 번호 생성할 배열
		int makeLotto[] = new int[6]; // 결과 배열
		for(String s : lotto){ // 꼭 포함할 값에 배열을 1로 초기화
			lotto2[Integer.parseInt(s)-1] = 1;
		}
		Random rnd = new Random(); // 난수
		int temp;
		for(int i=0;i<6-lotto.length;i++){
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
		return makeLotto;
	}
%>
<%
	// 넘어온 값을 받자!!!
	request.setCharacterEncoding("UTF-8");

	// POST전송이 아니면 에러발생!!! 이것을 막아보자
	if(!request.getMethod().equals("POST")){
		response.sendRedirect("lotto3.jsp");
		return;
	}

	// 같은 name 속성이 여러개면 getParameterValues로 받아야 한다. 
	String[] lotto = request.getParameterValues("lotto"); 
	
	int game = Integer.parseInt(request.getParameter("game"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	꼭 포함할 번호 : 
	<%=Arrays.toString(lotto) %>
	<br />
	생성한 로또번호<br />
	<% 
		for(int i=1;i<=game;i++){
			out.println(Arrays.toString(getLotto(lotto)) + "<br>");
		}
	%>
</body>
</html>