<%@page import="com.todo.model.Todo"%>
<%@page import="com.todo.connect.DBconnect"%>
<%@page import="com.todo.Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="component/allcss.jsp"%>
<title>Insert title here</title>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="component/navbar.jsp"%>
	<div class="container">
		<div class="row p-5">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-info">Add To-Do</h3>
						<%
							int id = Integer.parseInt(request.getParameter("id"));
							Dao d = new Dao(DBconnect.getCon());
							Todo t = d.getTodobyId(id);
						%>

						<hr class="text-info">
						<form action="update" method="post">
						<input type="hidden" value="<%=t.getId()%>" name="id">
							<div class="mb-3">
								<label class="form-label">Task </label> <input type="text"
									class="form-control" name="todo" value="<%=t.getTodo()%>">
							</div>
							<div class="mb-3">
								<label class="form-label">Category</label> <input type="text"
									class="form-control" name="category"
									value="<%=t.getCategory()%>">
							</div>
							<div>
								<label for="exampleInputPassword1" class="form-label">Status</label>
								<select name="status" class="form-select">
									<%
										if ("pending".equals(t.getStatus())) {
									%>
									<option value="pending">Pending</option>
									<option value="finished">Finished</option>
									<%
										} else {
									%>
									<option value="finished">Finished</option>
									<option value="pending">Pending</option>

									<%
										}
									%>

								</select>
							</div>
							<div class="text-center p-2">
								<button type="submit" class="btn btn-primary">Update</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>