<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="3" bordercolor="double blue">
		<thead>
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>성별</td>
				<td>도시</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="result" items="${list}">
				<tr>
					<td>${result.userId}</td>
					<td>${result.name}</td>
					<td>${result.gender}</td>
					<td>${result.city}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>