<!DOCTYPE html>
<html>
<head>
<title>Success Page</title>
<%@ include file="includes/styles.jsp" %>
</head>
<body>
	<div class = "container">
		<div class = "hero-unit">
			<h1>Success</h1>
		</div>
<%@ include file="includes/navigation.jsp" %>
		<div class = "hero-unit">
			<p>${message}</p>
		</div>
			

<%@ include file="includes/footer.jsp" %>
	</div>
<%@ include file="includes/scripts.jsp" %>
</body>
</html>