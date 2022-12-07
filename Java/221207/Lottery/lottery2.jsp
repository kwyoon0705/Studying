<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제비뽑기</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<style type="text/css">
fieldset {
	width: 1200px;
	margin-left: 10px;
	padding: 10px;
	border: 1px solid gray;
}

.innerBox {
	width: 120px;
	height: 120px;
	border: 1px solid gray;
	background-color: silver;
	text-align: center;
	font-size: 18pt;
	margin-right: 5px;
	float: left;
	vertical-align: middle;
	line-height: 120px;
	border-radius: 30px;
	cursor: pointer;
}
</style>
<script type="text/javascript">
	var boxCount = 3;
	var boom = []; // 빈 배열을 만들고
	$(function() {
		makeInnerBox(boxCount);

		$(".innerBox").hover(function() {
			$(this).css('background-color', 'yellow');
		}, function() {
			$(this).css('background-color', 'silver');
		});

		$("#cntNum").keydown(function() {
			return false;
		});
		$("#boomNum").keydown(function() {
			return false;
		});

		// 초기화 버튼을 클릭하면
		$("#initBtn").click(function() {
			boxCount = 3;
			$("#cntNum").val(3);
			$("#boomNum").val(1);
			makeInnerBox(boxCount);
		});

		// 만들기 버튼을 클릭하면
		$("#makeBtn").click(function() {
			var cntNum = $("#cntNum").val();
			var boomNum = $("#boomNum").val();
			if (cntNum < boomNum) {
				alert('전체 제비 개수보다 꽝의 개수가 많을 수는 없습니다.');
				$("#boomNum").val(1);
				return false;
			}
			boom.length = 0; // 배열의 길이를 0으로 만든다.
			for (var i = 0; i < cntNum; i++) { // 배열의 내용을 0으로 채운다.
				boom.push(0);
			}
			for (var i = 0; i < boomNum; i++) { // 폭탄의 개수만큼 반복
				do {
					t = parseInt(Math.random() * cntNum); // 0에서 폭탄의개수-1 사이의 난수 발생하면
				} while (boom[t] != 0) // 위에서 구한 난수 자리가 0이라면 do-while문을 나와서
				boom[t] = 1;// 그 자리에 폭탄을 넣자.
			}
			makeInnerBox(cntNum);

			$(".innerBox").each(function(i, element) {
				$(this).click(function() {
					if (boom[i] == 1)
						$(this).html("<img src='../images/boom.png'/>");
					else
						$(this).html("<img src='../images/lottery.png'/>");
				});
			});
			$(".innerBox").hover(function() {
				$(this).css('background-color', 'yellow');
			}, function() {
				$(this).css('background-color', 'silver');
			});
		});
	});
	function makeInnerBox(cnt) {
		$("#resultBox").empty();
		for (var i = 0; i < cnt; i++) {
			$("#resultBox").append(
					"<div class='innerBox' id='innerBox" + (i + 1) + "'>"
							+ (i + 1) + "</div>");
		}

	}
</script>
</head>
<body>
	<fieldset>
		<legend>제비뽑기</legend>
		<button id="initBtn" class="btn btn-success btn-sm">초기화</button>
		<button id="makeBtn" class="btn btn-success btn-sm">제비 만들기</button>
		<br />
		<hr />
		총 제비개수 :
		<input type="number" min="3" max="10" value="3" id="cntNum">
		꽝 제비개수 :
		<input type="number" min="1" max="10" value="1" id="boomNum">
		<hr />
		<div id="resultBox"></div>
	</fieldset>
</body>
</html>