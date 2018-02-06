<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movies: Add Movie</title>
<meta name="description" content="Feel free to add a movie to our database.">
<%@ include file="includes/styles.jsp" %>
</head>
<body>
<div class="container">
	<div class="hero-unit">
		<h1>Add Movie</h1>
	</div>
	<%@ include file="includes/navigation.jsp" %>
	<div class="container">
		<h5>${message}</h5>
		<form action="AddMovie" method="post">
			<label for="title"><strong>Title:</strong></label>
			<input name="title">
			<br>
			<label for="director"><strong>Director:</strong></label>
			<input name="director">
			<br>
			<label for="lengthInMinutes"><strong>Length of film:</strong></label>
			<input name="lengthInMinutes">
			<br>
			<input type="submit" value="Add Movie">
		</form>
	</div>
	<%@ include file="includes/footer.jsp" %>
</div>
<%@ include file="includes/scripts.jsp" %>
</body>
</html>