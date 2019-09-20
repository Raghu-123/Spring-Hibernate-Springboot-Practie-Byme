<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Raghu's Web Home page</title>
</head>
<body>
   <h2>Raghu's Web Home page</h2>
   <hr>
   <p>
     Welcome to Raghu's company Home Page!
   </p>
   <!-- Add Logout button -->
   <form:form action="${pageContext.request.contextPath}/logout" method="POST">
   
   <input type="submit" value="Logout" /> 
   </form:form>
   
</body>
</html>