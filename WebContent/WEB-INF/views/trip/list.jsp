<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trip</title>

</head>
<body>
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
	<h2>
	<div>
	<a href="../passintrip/" style="margin-left: 50px;" >Регистрации</a>     <a href="../passenger/" style="margin-left: 100px;">Пассажиры</a>  <a href="../company/"style="margin-left: 100px;">Компании</a> 

	</div>
	</h2>
	<h1>Trip</h1>
	
	<c:if test="${not empty trip}">
		<table border="1">
			<tr>
				<td>Номер рейса</td>
                <td>Id компании</td>
			    <td>Самолёт</td>
			    <td>Откуда</td>
			    <td>Куда</td>
			    <td>Время вылета</td>
			    <td>Время прилета</td>
           <s:authorize access="hasRole('ROLE_Admin')">
			    <td></td>
			    <td></td>
			   
		   </s:authorize>
			</tr>
			
			<c:forEach items="${trip}" var="trip">
				<tr>
					<td>${trip.tripNo}</td>
					<td>${trip.comp.idComp}</td>
					<td>${trip.plane}</td>
					<td>${trip.townFrom}</td>
					<td>${trip.townTo}</td>
			    	<td>${trip.timeIn}</td> 
					<s:authorize access="hasRole('ROLE_Admin')">
						<td><a href="update/${trip.tripNo}/${trip.comp.idComp}">Изменить</a></td>
						<td><a href="delete/${trip.tripNo}">Удалить</a></td>
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