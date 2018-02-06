<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movies: Listings</title>
<%@ include file="includes/styles.jsp" %>
</head>
<body>
<div class="container">
	<div class="hero-unit">
		<h1>Movie Listings</h1>
	</div>
	<%@ include file="includes/navigation.jsp" %>
	<div class="container">
		<c:choose>
			<c:when test="${empty movie}">
				<p>Sorry, the list of movies is empty.</p>
			</c:when>
			<c:otherwise>
				<c:forEach var="movie" items="${movie }">
					<div class="span4">
						<h2>${movie.title}</h2>
						<p>${movie.title} was directed by ${movie.director} and is ${movie.lengthInMinutes} minutes long.</p>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
	<%@ include file="includes/footer.jsp" %>
</div>
<%@ include file="includes/scripts.jsp" %>
</body>
</html>