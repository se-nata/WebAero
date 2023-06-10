<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Компания</title>
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
	<h1>Компания</h1>
	<form method="POST">
		<fieldset>
			<div>
				<label>Название: </label>
				<input  type="text" name="name" value="${company.name}">
			</div>
			<div>
				<label>Id_comp: ${company.idComp} </label>
			</div>
			
			<div>
				<input type="submit" value="Сохранить">
			</div>
		</fieldset>
	
	</form>

</body>
</html>