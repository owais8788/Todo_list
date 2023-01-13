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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		Dao d = new Dao(DBconnect.getCon());
		boolean f = d.deleteTodo(id);
		HttpSession session = req.getSession();
		if (f) {
			session.setAttribute("sucmsg", "ToDo Deleted successfully");
			resp.sendRedirect("index.jsp");
		} else {
			session.setAttribute("failedmsg", "Something wrong on server");
			resp.sendRedirect("index.jsp");
		}
	}

	
}