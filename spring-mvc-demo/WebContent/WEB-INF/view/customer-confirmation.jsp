<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
The Customer name is : ${customer.firstName} ${customer.lastName}
<br><br>
The number of FreePasses are : ${customer.freePasses}
<br><br>
The Postal Code of the person is : ${customer.postalCode}
<br><br>
The Course Code of the customer is : ${customer.courseCode}
</body>
</html>