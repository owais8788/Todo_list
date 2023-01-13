package com.todo.servelt;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.todo.Dao.Dao;
import com.todo.connect.DBconnect;
import com.todo.model.Todo;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String category = req.getParameter("category");
		String todo = req.getParameter("todo");
		String status = req.getParameter("status");

		Dao d = new Dao(DBconnect.getCon());
		Todo t = new Todo();
		t.setId(id);
		t.setCategory(category);
		t.setTodo(todo);
		t.setStatus(status);
		boolean f = d.updateTodo(t);
		HttpSession session = req.getSession();
		if (f) {
			session.setAttribute("sucmsg", "ToDo update successfully");
			resp.sendRedirect("index.jsp");
		} else {
			session.setAttribute("failedmsg", "Something wrong on server");
			resp.sendRedirect("index.jsp");
		}
	}

}