<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Passenger</title>
</head>
<body>
	<h2>
	<div>
	<a href="../passintrip/" style="margin-left: 50px;" >Регистрации</a>   <a href="../trip/"style="margin-left: 100px;">Рейсы</a>   <a href="../company/"style="margin-left: 100px;">Компании</a> 

	</div></h2>
<h1>Пассажиры</h1>

<c:if test="${not empty passenger }">
<table border="1">

<tr>
         <td>ФИО</td>
<s:authorize access="hasRole('ROLE_Admin')">
         <td></td>
         <td></td>
</s:authorize>
</tr>

<c:forEach items="${passenger}" var="passenger">
<tr>
         <td>${passenger.name}</td>
<s:authorize  access="hasRole('ROLE_Admin')">
      <td><a href="update/${passenger.passengerId}">Изменить</a> </td>
      <td><a href="delete/${passenger.passengerId}">Удалить</a></td>

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