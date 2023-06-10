<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

form fieldset input, form fieldset textarea {
	width: 100%;
}
</style>
</head>
<body>
	<h1>Pass in trip</h1>
	<form method="POST">
		<fieldset>
			<div>
			
				<label>Рейс № ${passintrip.trip.tripNo}   из ${passintrip.trip.townFrom} в ${passintrip.trip.townTo}</label>
		
				 
				 <input style="display: none;" type="number" name="trip.comp.idComp" value="${passintrip.trip.comp.idComp}"> 
				 
				 <input style="display: none;" type="text" name="trip.comp.name" value="${passintrip.trip.comp.name}"> 
				 
				 <input style="display: none;" type="text" name="trip.plane"  value="${passintrip.trip.plane}"> 
				 
				 <input style="display: none;" type="text" name="trip.townFrom" value="${passintrip.trip.townFrom}"> 
				 
				 <input style="display: none;" type="text" name="trip.townTo" value="${passintrip.trip.townTo}">
				  
				 <input style="display: none;" type="datetime-local" name="trip.timeOut" value="${passintrip.trip.timeOut}"> 
				 
				 <input style="display: none;" type="datetime-local" name="trip.timeIn" value="${passintrip.trip.timeIn}"> 
				 
				 <input style="display: none;" type="text" name="passenger.name" value="${passintrip.passenger.name}"> 
				 
				 <input style="display: none;" type="number" name="key.psgId" value="${passintrip.key.psgId}"> 
				 
				 <input style="display: none;" type="number" name="key.tripId" value="${passintrip.key.tripId}">
			</div>
			<div>
				<label>Дата: </label> <input type="datetime-local" name="date"
					value="${passintrip.date}">
			</div>

			<div>
				<label>Id пассажира: </label> <input type="number"
					name="passenger.passengerId"
					value="${passintrip.passenger.passengerId}" >
			</div>

			<div>

				<label>Номер места:</label> 
				<input type="text" name="place"  	value="${passintrip.place}"> 


			</div>
		<div>
				<input type="submit" value="Сохранить">
			</div>
		</fieldset>
	
	</form>

</body>
</html>