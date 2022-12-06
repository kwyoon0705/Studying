<%@page import="kr.human.poll.PollUtil"%>
<%@page import="kr.human.poll.PollVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// 투표한 번호를 받아서 해당 번호를 1 증가 시키고 다시 저장하고 결과보기로 간다.
// 눈에 보일 필요는 없기에 아래의 html태그를 다 지워준다.
// get방식으로 이 파일에 접근하는것을 방지해야한다.
// pollOk?poll=1 을 입력하면 1번의 값이 증가하므로 get방식을 막아주어야한다.
if (!request.getMethod().equals("POST")) {
	// POST전송이 아니라면 = GET방식이라면 = FORM을 통해 넘어온 값이 아니라면
	response.sendRedirect("pollForm.jsp"); // 무조건 지정 파일로 간다.
	return; // 더이상 실행하지 않고 종료한다.
}
//투표할 파일의 이름을 받아오자
String fileName = request.getParameter("file");
if (fileName == null || fileName.trim().length() == 0) { // 파일이름이 넘어오지 않았다면
	fileName = "poll01";
}

// 투표한 항목을 받아보자.
int poll = Integer.parseInt(request.getParameter("poll"));
// 투표한 항목의 숫자를 1개 증가시키자.
String path = application.getRealPath("./json/" + fileName + ".json");
PollVO pollVO = PollUtil.readPoll(path);
pollVO.getCounts()[poll]++;
// 변경된 내용을 저장하자.
PollUtil.savePoll(path, pollVO);
// 저장한 뒤에 리다이렉트할 페이지를 지정해준다.
response.sendRedirect("pollResult.jsp?file=" + fileName);
%>
