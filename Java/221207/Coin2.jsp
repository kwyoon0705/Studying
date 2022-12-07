<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link href="./css/flip_coin.css" rel="stylesheet" type="text/css">
<style type="text/css">

</style>
<script type="text/javascript">
	$(function() {
		$("#flip").click(function() {
			$("img.heads").addClass("animate-coin");
			setTimeout(() => {
				$("img.heads").removeClass("animate-coin");
				$("img.heads").attr("src", "./images/coin_" + parseInt(Math.random()*2+"")  + ".png");
			}, 1000);
			
		});
	});
</script>
</head>
<body>
<div id="coin"><img class="heads" src="./images/coin_0.png"></div>
<button id="flip">눌러</button>
</body>
</html>