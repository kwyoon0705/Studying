<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제비뽑기</title>
<!-- Bootstrap과 Jquery를 사용하겠다. -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<style type="text/css">
	fieldset{
		width: 800px; padding : 10px; padding-left: 30px; border: 2px solid gray; margin: 10px;
	}
	.innerBox{
		width: 80px; height: 80px; border: 1px solid gray; background-color: silver;
		text-align: center; font-size: 22pt; margin-right: 5px; float: left; vertical-align: middle;
		line-height: 80px; border-radius: 30px; cursor: pointer;
	}
</style>
<script type="text/javascript">
	var boxCount = 3;
	var boom = []; // 빈 배열만들기
	
	$(function(){
		makeInnerBox(boxCount);
		
		$(".innerBox").hover(function() {
			// 클래스 이름이 innerBox놈에 커서가 올라가면 배경색을 하늘색으로
			$(this).css('background-color','skyblue');
		}, function() {
			// 클래스 이름이 innerBox놈에 커서가 나가면 배경색을 밝은회색으로
			$(this).css('background-color','silver');
		});
		
		// input type="number"에 타이핑해서 입력을 못하도록 한다.
		// keydown은 키가 눌리면 바로 아무짓도 못하게 한다.
		$("#cntNum").keydown(function() {
			return false;
		});
		$("#boomNum").keydown(function() {
			return false;
		});
		
		// 초기화 버튼을 클릭하면
		$("#initBtn").click(function() {
			boxCount = 3;
			makeInnerBox(boxCount);
			var cntNum = $("#cntNum").val(boxCount);
			var boomNum = $("#boomNum").val(1);
		});

		// 만들기 버튼을 클릭하면
		$("#makeBtn").click(function() {
			var cntNum = $("#cntNum").val();
			var boomNum = $("#boomNum").val();
			if(cntNum<boomNum){
				alert('전체 개수보다 폭탄의 개수가 클 수 없어요!!!');
				 $("#boomNum").val(1);
				return false;
			}
			// 전체 개수만큼 배열을 만들고 폭탄 개수만큼 폭탄이라고 표시!!!
			//--------------------------------------------------------------
			boom.length = 0; // 배열의 길이를 0으로 만든다.
			for(var i=0;i<cntNum;i++) boom.push(0); // 배열의 내용을 총개수 만큼 0으로 채우기
			for(var i=0;i<boomNum;i++){ // 폭탄의 개수만큼 반복
				do{
					t = parseInt(Math.random()*cntNum); // 0 ~개수-1 사이의 난수 발생
				}while(boom[t]!=0); // 0이 있는 위치를 찾아서 탈출
				boom[t] = 1; // 그자리에 1을 넣자
			}
			//--------------------------------------------------------------
			// 이제 innerBox를 만들고
			makeInnerBox(cntNum);
			// alert(boom);
			
			// 클래스 이름이 innerBox를 찾아 각각에 클릭이벤트 지정
			$(".innerBox").each(function(i, element) { // 반복
				// 클릭이벤트 지정
				$(this).click(function() {
					// alert(i+1 + "번째 눌렀냐?");
					if(boom[i]==1){
						$(this).html("<img src='images/boom.png'/>");
					}else{
						$(this).html("<img src='images/ok.png'/>");
					}
					$(this).css('background-color','white');
				});
			});
		});
	});
	
	function makeInnerBox(cnt){
		$("#resultBox").empty(); // id가 resultBox놈을 찾아 안의 내용을 모두 지워라
		for(var i = 0;i<cnt;i++){ // 넘어온 cnt값 만큼 div태그를 만들어서 resultBox에 추가해라!!!
			$("#resultBox").append("<div class='innerBox' id='innerBox"+(i+1)+"'>?</div>");
		}
	}
</script>
</head>
<body>
	<fieldset>
		<legend>제비 뽑기</legend>
	<button id="initBtn" class="btn btn-danger btn-sm">초기화</button>
	<button id="makeBtn" class="btn btn-danger btn-sm">만들기</button>
	<br />
	<hr />
		총개수 : <input type="number" min="3" max="10" value="3" id="cntNum"/>
		꽝개수 : <input type="number" min="1" max="10" value="1" id="boomNum"/>
	<hr />
	<div id="resultBox">
	
	</div>
	</fieldset>
</body>
</html>