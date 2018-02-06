<!DOCTYPE html>
<html>
<head>
<title>Error Page</title>
<%@ include file="includes/styles.jsp" %>
</head>
<body>
	<div class = "container">
		<div class = "hero-unit">
			<h1>Error!</h1>
		</div>
<%@ include file="includes/navigation.jsp" %>
		<div class = "hero-unit">
			<h2>Houston, we've had a problem.</h2>
			
		
			<h4>Error Details</h4>
			<p>Message: ${message}</p>
			</div>
			

<%@ include file="includes/footer.jsp" %>
	</div>
<%@ include file="includes/scripts.jsp" %>
</body>
</html>