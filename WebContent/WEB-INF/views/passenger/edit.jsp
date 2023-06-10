<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Пассажир</title>
<style>
	form fieldset {
		width : 40%;
	} 
	form fieldset label {
		display : block;
		/*width : 50%;
		float :left;*/
	}
	form fieldset input, form fieldset textarea {
		width : 100%;
	}
</style>
</head>
<body>
	<h1>Пассажир</h1>
	<form method="POST">
		<fieldset>
			<div>
				<label>Имя: </label>
				<input  type="text" name="name" value="${passenger.name}">
			</div>
			<div>
				<label>Id_пассажира: ${passenger.passengerId} </label>
		
			</div>
			
			<div>
				<input type="submit" value="Сохранить">
			</div>
		</fieldset>
	
	</form>

</body>
</html>