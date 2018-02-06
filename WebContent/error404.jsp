<!DOCTYPE html>
<html>
<head>
<title>404 - Page Not Found</title>
<%@ include file="includes/styles.jsp" %>
</head>
<body>
	<div class = "container">
		<div class = "hero-unit">
			<h1>404 Sorry :[</h1>
		</div>
<%@ include file="includes/navigation.jsp" %>
		<div class = "hero-unit">
			<p>This is not the page you were looking for.</p>
			<p>${message}</p>
		</div>		

<%@ include file="includes/footer.jsp" %>
	</div>
<%@ include file="includes/scripts.jsp" %>
</body>
</html>