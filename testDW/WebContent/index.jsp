<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	ul{list-style:none;}
</style>
</head>
<body>
	<h2>
		<form action="getUser.do" method="get">
			<ul>
				<li>
					UserID : <input type="text" name="id" />	
				</li>
				<li>
					<input type="submit" value="조회" />
				</li>
			</ul>
		</form>
		<a href="getAllUser.do">전체 조회하기</a>
	</h2>
</body>
</html>