<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
img.infinite_rotating_logo{
    animation: rotate_image 1s linear infinite;
    transform-origin: 50% 50%;
}
 
@keyframes rotate_image{
	100% {
    	transform: rotate(360deg);
    }
}
</style>
</head>
<body>
<div class="logo-area">
	<img src="images/coin_0.png" class="infinite_rotating_logo">
</div>
</body>
</html>