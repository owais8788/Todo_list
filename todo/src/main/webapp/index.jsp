<%@page import="com.todo.model.Todo"%>
<%@page import="java.util.List"%>
<%@page import="com.todo.Dao.Dao"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.todo.connect.DBconnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="component/allcss.jsp" %>
<title>TODO APP</title>
</head>
<body>
<%@include file="component/navbar.jsp" %>
<h1 class="text-center text-success">TODO-APP</h1>

<%
String sucmsg = (String)session.getAttribute("sucmsg");
if(sucmsg!=null){
	%>
	<div class="alert alert-success" role="alert"><%=sucmsg %></div>
	<%
	session.removeAttribute("sucmsg");
}
%>
<%
String failedmsg = (String)session.getAttribute("failedmsg");
if(failedmsg!=null){
	%>
	<div class="alert alert-success" role="alert"><%=failedmsg %></div>
	<%
	session.removeAttribute("failedmsg");
}
%>

<div class="container">
<table class="table table-striped" border="1px">
  <thead class="bg-info">
    <tr>
      <th scope="col">id</th>
      <th scope="col">category</th>
      <th scope="col">To-Do</th>
      <th scope="col">status</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  
  <%
  Dao d = new Dao(DBconnect.getCon());
  List<Todo> list = d.getTodo();
  for(Todo t:list)
  {%>
	  
    <tr>
      <th scope="row"><%=t.getId()%></th>
      <td><%=t.getCategory()%></td>
      <td><%=t.getTodo()%></td>
      <td><%=t.getStatus()%></td>
      <td>
      <a href="edit.jsp?id=<%=t.getId()%>" class="btn btn-sm btn-success">Edit</a>
      <a href="delete?id=<%=t.getId()%>" class="btn btn-sm btn-danger">Delete</a>
      </td>
    </tr>
    <% }
  %>
  </tbody>
</table>
</div>

</body>
</html>