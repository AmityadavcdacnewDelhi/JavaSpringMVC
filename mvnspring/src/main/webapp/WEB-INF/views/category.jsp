<%@page import="mvnspring.pojo.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border='1'>
<%
 List<Category> list = (List<Category>)request.getAttribute("data");
for(Category objCategory : list)
{	
%>
<tr>
<td><%=objCategory.getCategoryName() %></td>
<td><%=objCategory.getCategoryDescription() %></td>
<td><%=objCategory.getCategoryImageUrl() %></td>
</tr>
<% 
}
%>
</table>
</body>
</html>