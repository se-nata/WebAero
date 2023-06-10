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

}

form fieldset input, form fieldset textarea {
	width: 100%;
}
</style>
</head>
<body>
	<h1>Trip</h1>
	<form method="POST">
		<fieldset>
			<div>
				
				<label>Номер рейса</label>
				  <input type="number" name="tripNo" value="${trip.tripNo}" readonly="readonly"> 
			</div>	  
			<div>
				 <label>Id компании</label>
				 <input  type="number" name="idComp" value="${trip.comp.idComp}" > 
				 	
		
			 </div>	
			 <div>
				 <label> Самолёт </label>
				 <input type="text" name="plane"  value="${trip.plane}">
			 </div> 
			 <div>
				  <label>Откуда </label>
				 <input  type="text" name="townFrom" value="${trip.townFrom}"> 
			</div>  
			 <div>
				  <label>Куда </label>
				 <input  type="text" name="townTo" value="${trip.townTo}">
			</div> 
			<div>
				   <label> Вылет </label>
				 <input  type="datetime-local" name="timeOut" value="${trip.timeOut}"> 
			</div> 
			<div>
				  <label> Прилёт </label>
				 <input  type="datetime-local" name="timeIn" value="${trip.timeIn}"> 
			</div> 
			

			
		<div>
				<input type="submit" value="Сохранить">
			</div>
		</fieldset>
	
	</form>

</body>
</html>