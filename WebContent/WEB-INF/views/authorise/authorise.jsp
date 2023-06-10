<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Authorise</title>
</head>
<body>
<body>
	<h1>Логин форма</h1>
	<div id="userinfo">
		<s:authorize access="isAuthenticated()"> Привет,
			<s:authentication property="principal.username" />!
			<br/>
			<a href="../j_spring_security_logout">Выход</a>
		</s:authorize>
	</div>
		<div>
		<s:authorize access="isAuthenticated()">
	<a href="../trip/">Рейсы</a>
	</s:authorize>
	</div>

	<s:authorize access="isAnonymous()">
		<form id="login" name="loginForm" action="../j_spring_security_check" 
			method="POST">
			<label>Логин:</label>&nbsp;
			<input type="text" name="j_username">
			<label>Пароль:</label>&nbsp;
			<input type="password" name="j_password">
			<input type="submit" name="submit" value="Войти">
		</form>
	</s:authorize>
</body>
</html>