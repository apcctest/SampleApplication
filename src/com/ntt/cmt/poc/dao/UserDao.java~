package com.ntt.cmt.poc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ntt.cmt.poc.model.User;
import com.ntt.cmt.poc.util.DBUtil;

public class UserDao {

/*	private Connection connection;

	public UserDao() {
		connection = DBUtil.getConnection();
	}*/

	public User authenticateUser(Connection connection, String userName, String password) throws SQLException {
		System.out.println("Inside authenticate user method");
		User user = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where username=? and password=?");
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			
			//Srikar			
			System.out.println("Srikar: username="+userName+"Password"+password);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				System.out.println("User found in the DB");
				user = new User();
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
			}
		} catch (SQLException e) {
			throw new SQLException();
		}
		return user;
	}

	public User getUserByUserName(Connection connection, String userName) throws SQLException {
		User user = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where username=?");
			preparedStatement.setString(1, userName);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				System.out.println("User found in the DB");
				user = new User();
				user.setUserName(rs.getString("username"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setEmailAddress(rs.getString("emailaddress"));
			}
		} catch (SQLException e) {
			throw new SQLException();
		}
		return user;
	}

	public Boolean addUser(Connection connection, String firstName, String lastName, String userName, String password, String emailAddress, String role) {
		Boolean result = true;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(username, password, role, firstname, "
					+ "lastname, emailaddress, datejoined) VALUES (?, ?, ?, ?, ?, ?,current_timestamp)");

			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, role);
			preparedStatement.setString(4, firstName);
			preparedStatement.setString(5, lastName);
			preparedStatement.setString(6, emailAddress);

			preparedStatement.executeUpdate();

			System.out.println("User added successfully!");

		} catch (SQLException e) {
			result = false;
		}
		return result;
	}

	public List<User> viewUsers(Connection connection) throws SQLException {
		List<User> users = new ArrayList<User>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from users");

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setFirstName(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setUserName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				user.setEmailAddress(rs.getString("emailaddress"));
				user.setJoinedDate(rs.getDate("datejoined"));
				users.add(user);
			}

			System.out.println("Users list size: " + users.size());
		} catch (SQLException e) {
			throw new SQLException();
		}

		return users;
	}

	public void removeUserByName(Connection connection, String username) throws SQLException {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from users where username = ?");

			preparedStatement.setString(1, username);

			preparedStatement.executeUpdate();

			System.out.println("User removed successfully!");

		} catch (SQLException e) {
			throw new SQLException();
		}

	}

	public void updateUserdetails(Connection connection, String firstName, String lastName, String userName, String password, String emailAddress, String role) throws SQLException {
		System.out.println("User name: " + userName);
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("update users set firstname = ?,  lastname = ?,  password = ?, emailaddress = ? where username = ?");

			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, password);
			preparedStatement.setString(4, emailAddress);
			preparedStatement.setString(5, userName);

			preparedStatement.executeUpdate();

			System.out.println("User updated successfully!");

		} catch (SQLException e) {
			throw new SQLException();
		}

	}
}
