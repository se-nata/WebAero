<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trip</title>
<style>
form fieldset {
	width: 40%;
}

form fieldset label {
	display: block;
	/*width : 50%;
		float :left;*/
}

form fieldset input, form fieldset select, form fieldset textarea {
	width: 100%;
}
</style>
</head>
<body>
	<form:form method="POST">
		<h1>Trip</h1>

		<fieldset>
			<div>
					<label>Номер рейса</label>
					<form:input path="tripNo" />
		   </div>
		
			<div>
				<label>Id компании</label>
				<form:select path="comp"> 
					<form:options items="${companyList}" itemValue="idComp" itemLabel="name"/>
				</form:select>
			</div>
		
     		<div>
				 <label> Самолёт </label>
					<form:input type="text" path="plane" />
			
			</div>
						
			<div>
				 <label>Откуда </label>	
				<form:input type="text" path="townFrom"/>
			</div> 
			
			<div>
				 <label>Куда </label>	
				<form:input type="text" path="townTo"/>
			</div> 
			
			<div>
			    <label> Вылет </label>
			 
			    <form:input type="datetime-local" path="timeOut"/>
			</div> 
			<div>
			    <label> Прилёт </label>
			  
			    <form:input type="datetime-local" path="timeIn"/>
			</div> 
			
			<div>
				<input type="submit" value="Сохранить">
			</div>
		</fieldset>

	</form:form>

</body>
</html>