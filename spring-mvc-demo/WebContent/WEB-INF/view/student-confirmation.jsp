<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration Form</title>
</head>
<body>
The Student is confirmed: ${student.firstName} ${student.lastName}
<br><br>
The Student is from: ${student.country}
<br><br>
THe Student's Favorite Programming Language :${student.favoriteLanguage}
<br><br>
The Student Know's Following Operating Systems: 
<ul>
 <c:forEach var="temp" items="${student.operatingSystem}">
 <li>${temp}</li>
 </c:forEach>
</ul>
</body>
</html>