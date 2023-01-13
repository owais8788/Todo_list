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

@WebServlet("/addtodo")
public class AddServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          String category = req.getParameter("category");
          String todo = req.getParameter("todo");
          String status = req.getParameter("status");
          
          Dao d = new Dao(DBconnect.getCon());
          boolean f = d.addTodo(category, todo, status);
          
          HttpSession session = req.getSession();
          
          if(f) {
        	  session.setAttribute("sucmsg", "ToDo added successfully");
        	  resp.sendRedirect("index.jsp");
          }else {
        	  session.setAttribute("failedmsg", "Something wrong on server");
        	  resp.sendRedirect("index.jsp");
          }
	}
	
	
	
	

}