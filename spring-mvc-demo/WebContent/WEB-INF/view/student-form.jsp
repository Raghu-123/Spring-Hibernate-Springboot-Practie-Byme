<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration Form</title>
</head>
<body>
     <form:form action="processForm" modelAttribute="student">
     First Name: <form:input path="firstName"/>
     
     <br><br>
     
     Last Name: <form:input path="lastName"/>
     
     <br><br>
     Country: <form:select path="country">
     <%-- To load the country values from java 
        <form:options items="${student.countryOptions}"/> --%>
     
     <!-- To load country values from the properties files -->
       <form:options items="${theCountryOptions}" />
     </form:select>
     <br><br>
     
     Please select the Favorite Programming language:
     
      <br><br>
      
     Java <form:radiobutton path="favoriteLanguage" value="Java"/>
     Python <form:radiobutton path="favoriteLanguage" value="Python"/>
     C# <form:radiobutton path="favoriteLanguage" value="C#"/>
     C++ <form:radiobutton path="favoriteLanguage" value="C++"/>
     
     <br><br>
     Operating Systems:<br>
     
    Linux <form:checkbox path="operatingSystem" value="Linux"/>
    Mac OS <form:checkbox path="operatingSystem" value="Mac OS"/>
    Windows <form:checkbox path="operatingSystem" value="Linux"/>
     
     <br><br>
     <input type="submit" value="submit">
     
     </form:form>

</body>
</html>