package com.ntt.cmt.poc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static Connection connection = null;

	public static Connection getConnection() {

		System.out.println("-------- PostgreSQL JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
			e.printStackTrace();
		}

		try {

			//connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/testdb", "postgres", "admin");
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/testdb", "postgres", "admin");
			//connection = DriverManager.getConnection("jdbc:postgresql://141.77.104.11:5432/testdb", "postgres", "1234");
			//connection = DriverManager.getConnection("jdbc:postgresql://141.77.104.11:5432/testdb", "postgres", "1234");
			
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}

		if (null != connection) {
			System.out.println("Connection successful!");
			System.out.println("-----------------------------------------------------------------");
		} else {
			System.out.println("Failed to make connection!");
		}

		return connection;
	}
}
