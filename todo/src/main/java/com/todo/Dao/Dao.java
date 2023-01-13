package com.todo.Dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.todo.model.Todo;

public class Dao {
	
	private Connection con;
	
	public Dao(Connection con) {
		super();
		this.con = con;
	}


	public boolean addTodo(String category,String todo,String status) {
		boolean f = false;
		try {
			String sql = "insert into todo(category,todo,status) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, category);
			ps.setString(2, todo);
			ps.setString(3, status);
			
			int i=ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}else {
				f=false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	public List<Todo> getTodo(){
		
		List<Todo> list = new ArrayList<Todo>();
		Todo t = null;
		try {
			String sql = "select*from todo";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				t=new Todo();
				t.setId(rs.getInt(1));
				t.setCategory(rs.getString(2));
				t.setTodo(rs.getString(3));
				t.setStatus(rs.getString(4));
				list.add(t);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	public Todo getTodobyId(int id) {
		Todo t =null;
		try {
			String sql = "select*from todo where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				t=new Todo();
				t.setId(rs.getInt(1));
				t.setCategory(rs.getString(2));
				t.setTodo(rs.getString(3));
				t.setStatus(rs.getString(4));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return t;
	}
	
	public boolean updateTodo(Todo t) {
		
		boolean f = false;
		try {
			String sql = "update todo set category=?,todo=?,status=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getCategory());
			ps.setString(2, t.getTodo());
			ps.setString(3, t.getStatus());
			ps.setInt(4, t.getId());
			
			int i = ps.executeUpdate();
			if(i==1) {
				f=true;
			}else {
				f=false;
			}
			
		}catch(Exception e) {
			
		}
		
		return f;
		
	}
	public boolean deleteTodo(int id) {
		boolean f = false;
		try {
			String sql = "delete from todo where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i==1) {
				f=true;
			}else {
				f=false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}