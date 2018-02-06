<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie: Search</title>

<%@ include file="includes/styles.jsp" %>
</head>
<body>
<div class="container">
	<div class="hero-unit">
		<h1>Search</h1>
	</div>
	<%@ include file="includes/navigation.jsp" %>
	<div class="container">
		<form action="Search" method="post">
			<label for="title"><strong>Search by Title:</strong></label>
			<input name="title">
			<br>
			<label for="director"><strong>Search by Director:</strong></label>
			<input name="director">
			<br>
			<input type="submit" value="Search">
		</form>
	</div>
	<%@ include file="includes/footer.jsp" %>
</div>
<%@ include file="includes/scripts.jsp" %>
</body>
</html>
