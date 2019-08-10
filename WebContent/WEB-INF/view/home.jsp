<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Great Number Game!</title>
</head>
<body>
	
	<h1>Welcome to the Great Number Game!</h1>
	<h4>I am thinking of a number between 1 and 100</h4>
	<h3>Take a guess!</h3>
	
	<%String input = (String) session.getAttribute("response");%>
	<%! public String response (Integer response){
		return response.toString();
	}%>
	<%if(input == "correct"){ %>
		<div class = "correct"><h1><%=response(Integer.parseInt(request.getParameter("guess")))%> was correct!</h1>
		<form action = "Restart" method = "get">
		<input type = "submit" value = "Play again?">
		</form>
		</div>
		<%}
		 else { 
			 if (input == "low") {%>
			<div class = "low"><h1>Too low!</h1></div>
			<% }
			 if(input == "high") { %>
			<div class = "high"><h1>Too high!</h1></div>
			<% } %>
		
	<form action = "Game" method = "post">
	<input type = "text" name = "guess">
	<button type = "submit">Submit</button>
	</form>
	<%}%>
</body>
</html>