package com.laptrinhjavaweb.dao.Impl;

import java.sql.Connection;
import java.sql.DriverManager;

public class AbstractDAO {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String username = "root";
			String password = "01082003";
			String url = "jdbc:mysql://localhost:3306/jsp_servlet";
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
