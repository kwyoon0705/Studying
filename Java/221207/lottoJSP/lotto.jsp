<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<style type="text/css">
	fieldset{
		width: 400px; padding: 10px; margin-left: 50px; border: 1px solid gray;
	}
</style>
<script type="text/javascript">
	$(function(){
		$("#clearBtn").click(function() {
			for(var i=0;i<45;i++){
				$("#chk"+i).prop("checked", false);
			}
		});
	});
</script>	
</head>
<body>
	<form action="lottoResult.jsp" method="post">
		<fieldset>
			<div>
				<input type="button"  value="제외할 선택 초기화" id="clearBtn" class="btn btn-success btn=sm"/>
				<input type="submit"  value="로또번호 생성하기"  class="btn btn-danger btn=sm"/>
			</div>
			<hr />
			<legend> 제외할 번호 선택 </legend>		
			<hr />
			<% for(int i=0;i<45;i++){ %>
				<label>
					<input type="checkbox" name="lotto" id="chk<%=i %>" value="<%=i+1%>"/>
					<%=String.format("%02d", i+1) %>
					<span style="width: 30px;">&nbsp;</span> 
				</label>
				<% if((i+1)%7==0){ out.println("<br>"); } %>
			<% } %>
			<br />
		</fieldset>
	</form>
</body>
</html>