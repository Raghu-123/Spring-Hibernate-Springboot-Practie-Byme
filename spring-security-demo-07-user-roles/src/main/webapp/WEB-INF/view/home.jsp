<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
   <hr>
     <!-- display user name and user role -->
     <p>
     User Name: <security:authentication property="principal.username"/>
     <br><br>
     Role(s) :<security:authentication property="principal.authorities"/>
     </p>
    
     
     <!-- Add security tag to show links based on roles -->
     <security:authorize access="hasRole('MANAGER')">
	      <!-- Add link to point to /leaders ... this is for managers-->
	      <p> 
	       <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
	       (Only for Manager peeps)
	      </p>
      </security:authorize>
      
      <!-- Add security tag to show links based on roles -->
     <security:authorize access="hasRole('ADMIN')">
      <!-- Add link to point to /systems ... this is for Admin-->
      <p> 
       <a href="${pageContext.request.contextPath}/systems">Admin Meeting</a>
       (Only for Admin peeps)
      </p>
      </security:authorize>
      
      
    
   <hr>
   <!-- Add Logout button -->
   <form:form action="${pageContext.request.contextPath}/logout" method="POST">
   
   <input type="submit" value="Logout" /> 
   </form:form>
   
</body>
</html>