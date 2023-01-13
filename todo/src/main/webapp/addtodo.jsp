<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="component/allcss.jsp"%>
<title>Insert title here</title>
</head>
<body style="background-color:#f0f1f2;">
	<%@include file="component/navbar.jsp"%>
	<div class="container">
		<div class="row p-5">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
					<h3 class="text-center text-info">Add To-Do</h3>
					<hr class="text-info">
						<form action="addtodo" method="post">
							<div class="mb-3">
								<label class="form-label" >Task
								</label>
								 <input type="text" class="form-control" name="todo">
							</div>
							<div class="mb-3">
								<label class="form-label" >Category</label>
								<input type="text" class="form-control" name="category">
							</div>
							<div>
								<label for="exampleInputPassword1" class="form-label">Status</label>
								<select name="status" class="form-select" aria-label="Default select example">
									<option selected>--Select--</option>
									<option value="pending">Pending</option>
									<option value="finished">Finished</option>
								</select>
							</div>
							<div class="text-center p-2">
								<button type="submit" class="btn btn-primary">Add</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>