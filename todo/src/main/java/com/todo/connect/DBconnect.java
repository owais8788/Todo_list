package com.todo.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBconnect {
	
	private static Connection con;
	public static Connection getCon(){
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo", "root", "root");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;

		
	}
}