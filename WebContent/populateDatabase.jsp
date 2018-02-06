<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movies: Populate Database</title>
<meta name="description" content="repopulates test data">
<%@ include file="includes/styles.jsp" %>
</head>
<body>
<div class="container">
	<div class="hero-unit">
		<h1>Search</h1>
	</div>
	<%@ include file="includes/navigation.jsp" %>
	<div class="container">
		<form action="PopulateDatabase" method="post">
			<p>Click on the populate button to populate the movies database.</p>
			<p>Warning: Submitting this form will reset the database and it will only contain the original data</p>
			<input type="submit" value="OK">
		</form>
	</div>
	<%@ include file="includes/footer.jsp" %>
</div>
<%@ include file="includes/scripts.jsp" %>
</body>
</html>