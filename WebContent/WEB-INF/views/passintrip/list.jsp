<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pass in trip</title>

</head>
<body>
	<h2>

	<a href="../trip/"style="margin-left: 50px;"   >Рейсы</a>   <a href="../passenger/"style="margin-left: 100px;">Пассажиры</a>   <a href="../company/"style="margin-left: 100px;">Компании</a> 

	
	</h2>
	<h1>Pass in trip</h1>
	
	<div id="userinfo">
		<s:authorize access="isAuthenticated()"> Привет,
			<s:authentication property="principal.username" />!
			<br/>
			<a href="../j_spring_security_logout">Выход</a>
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
	<c:if test="${not empty passintrip}">
		<table border="1">
			<tr>
				<td>Номер авиарейса</td>
			    <td>Дата</td>
			    <td>Id пассажира</td>
			    <td>Место пассажира</td>
           <s:authorize access="hasRole('ROLE_Admin')">
			    <td></td>
			    <td></td>
			   
		   </s:authorize>
			</tr>
			
			<c:forEach items="${passintrip}" var="passintrip">
				<tr>
					<td>${passintrip.trip.tripNo}</td>
					<td>${passintrip.date}</td>
					<td>${passintrip.passenger.passengerId}</td>
					<td>${passintrip.place}</td>
					<s:authorize access="hasRole('ROLE_Admin')">
						<td><a href="update/${passintrip.trip.tripNo}/${passintrip.passenger.passengerId}">Изменить</a></td>
						<td><a href="delete/${passintrip.trip.tripNo}/${passintrip.passenger.passengerId}">Удалить</a></td>
					</s:authorize>
						
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<s:authorize access="hasRole('ROLE_Admin')">
	<h3>
		<a href="insert">Добавить...</a>
		</h3>
	</s:authorize>
</body>
</html>