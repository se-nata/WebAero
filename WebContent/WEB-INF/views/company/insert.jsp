<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Компания</title>
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
	<form method="POST">
		<h1>Компания</h1>

		<fieldset>
			<div>
					<label>Введите новую компанию:</label>
					<input type="text" name="name" value="${company.name}"/>
		   </div>
		
			
	
			
			<div>
				<input type="submit" value="Сохранить">
			</div>
		</fieldset>

	</form>

</body>
</html>