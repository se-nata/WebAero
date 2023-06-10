<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pass in trip</title>
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
		<h1>Pass in trip</h1>

		<fieldset>
			<div>
					<label>Номер места:</label>
					<form:input path="place" />
		   </div>
		
			<div>
				<label>Рейс:</label>
				<form:select path="trip"> <!-- trip_in_pass.trip=trip_no->converter->Trip (findbyID) -->
					<form:options items="${tripList}" itemValue="tripNo" itemLabel="tripNo"/>
				</form:select>
			</div>
		
     		<div>
				<label>Пассажир:</label> 
				<form:select path="passenger">
					<form:options items="${passengerList}" itemValue="passengerId" itemLabel="name" />
				</form:select>
			</div>
						
			<div>
				<label>Дата:</label> 	
				<form:input type="datetime-local" path="date"/>
			</div> 
			
			<div>
				<input type="submit" value="Сохранить">
			</div>
		</fieldset>

	</form:form>

</body>
</html>