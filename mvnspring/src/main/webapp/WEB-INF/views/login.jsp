<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="authenticate" modelAttribute="objUser">
userName:<form:input path="userName"/><br>
password:<form:password path="password"/><br>
<form:button>Login</form:button>
</form:form>
</body>
</html>