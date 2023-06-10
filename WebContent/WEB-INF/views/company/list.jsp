<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Компании</title>

</head>
<body>
	<h2>
	<div>
	<a href="../passintrip/" style="margin-left: 50px;" >Регистрации</a>   <a href="../passenger/"style="margin-left: 100px;">Пассажиры</a>   <a href="../trip/"style="margin-left: 100px;">Рейсы</a> 

	</div></h2>
	<h1>Компании</h1>

	<c:if test="${not empty company}">
		<table border="1">
			<tr>
				<td>Название</td>
			    <td>Id компании</td>
           <s:authorize access="hasRole('ROLE_Admin')">
			    <td></td>
			    <td></td>
			   
		   </s:authorize>
			</tr>
			
			<c:forEach items="${company}" var="company">
				<tr>
					<td>${company.name}</td>
					<td>${company.idComp}</td>
					<s:authorize access="hasRole('ROLE_Admin')">
						<td><a href="update/${company.idComp}">Изменить</a></td>
						<td><a href="delete/${company.idComp}">Удалить</a></td>
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