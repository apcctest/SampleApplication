package com.ntt.cmt.poc.dao.test;

import static org.easymock.EasyMock.anyInt;
import static org.easymock.EasyMock.anyString;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ntt.cmt.poc.dao.UserDao;
import com.ntt.cmt.poc.model.User;

public class TestUserDao {

	UserDao dao = new UserDao();

	DriverManager driverManager;
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	@Before
	public void setUp() {
		driverManager = createMock(DriverManager.class);
		connection = createMock(Connection.class);
		preparedStatement = createMock(PreparedStatement.class);
		resultSet = createMock(ResultSet.class);
	}

	@After
	public void tearDown() {
		driverManager = null;
		connection = null;
		preparedStatement = null;
		resultSet = null;
	}

	@Test(expected = SQLException.class)
	public void testAuthenticateUserException() throws SQLException {
		preparedStatement.setString(anyInt(), anyString());
		preparedStatement.setString(anyInt(), anyString());
		expect(connection.prepareStatement(anyString())).andReturn(preparedStatement);
		expect(preparedStatement.executeQuery()).andReturn(resultSet);
		expect(resultSet.next()).andThrow(new SQLException());
		replay(connection, preparedStatement, resultSet);

		dao.authenticateUser(connection, "admin", "admin");
	}

	@Test
	public void testAuthenticateUserFail() throws SQLException {
		preparedStatement.setString(anyInt(), anyString());
		preparedStatement.setString(anyInt(), anyString());
		expect(connection.prepareStatement(anyString())).andReturn(preparedStatement);
		expect(preparedStatement.executeQuery()).andReturn(resultSet);
		expect(resultSet.next()).andReturn(false);
		replay(connection, preparedStatement, resultSet);

		assertNull(dao.authenticateUser(connection, "adminnn", "admin"));

	}

	@Test
	public void testAuthenticateUserSuccess() throws SQLException {
		preparedStatement.setString(anyInt(), anyString());
		preparedStatement.setString(anyInt(), anyString());
		expect(connection.prepareStatement(anyString())).andReturn(preparedStatement);
		expect(preparedStatement.executeQuery()).andReturn(resultSet);
		expect(resultSet.next()).andReturn(true);
		expect(resultSet.getString("username")).andReturn("User Dummy");
		expect(resultSet.getString("password")).andReturn("User Pwd");
		expect(resultSet.getString("role")).andReturn("user");
		replay(connection, preparedStatement, resultSet);

		assertNotNull(dao.authenticateUser(connection, "admin", "admin"));
	}

	@Test(expected = SQLException.class)
	public void testGetUserByUserNameException() throws SQLException {
		preparedStatement.setString(anyInt(), anyString());
		expect(connection.prepareStatement(anyString())).andReturn(preparedStatement);
		expect(preparedStatement.executeQuery()).andReturn(resultSet);
		expect(resultSet.next()).andThrow(new SQLException());
		replay(connection, preparedStatement, resultSet);

		dao.getUserByUserName(connection, "admin");
	}

	@Test
	public void testGetUserByUserNameFail() throws SQLException {
		preparedStatement.setString(anyInt(), anyString());
		expect(connection.prepareStatement(anyString())).andReturn(preparedStatement);
		expect(preparedStatement.executeQuery()).andReturn(resultSet);
		expect(resultSet.next()).andReturn(false);
		replay(connection, preparedStatement, resultSet);

		assertNull(dao.getUserByUserName(connection, "hacker"));

	}

	@Test
	public void testGetUserByUserNamePass() throws SQLException {
		preparedStatement.setString(anyInt(), anyString());
		expect(connection.prepareStatement(anyString())).andReturn(preparedStatement);
		expect(preparedStatement.executeQuery()).andReturn(resultSet);
		expect(resultSet.next()).andReturn(true);
		expect(resultSet.getString("username")).andReturn("PeterP");
		expect(resultSet.getString("firstname")).andReturn("Parker");
		expect(resultSet.getString("lastname")).andReturn("Peter");
		expect(resultSet.getString("emailaddress")).andReturn("peter.parker@gmail.com");
		replay(connection, preparedStatement, resultSet);

		assertNotNull(dao.getUserByUserName(connection, "hacker"));

	}

	@Test
	public void testAddUserFail() throws SQLException {
		preparedStatement.setString(anyInt(), anyString());
		preparedStatement.setString(anyInt(), anyString());
		preparedStatement.setString(anyInt(), anyString());
		preparedStatement.setString(anyInt(), anyString());
		preparedStatement.setString(anyInt(), anyString());
		preparedStatement.setString(anyInt(), anyString());

		expect(connection.prepareStatement(anyString())).andReturn(preparedStatement);
		expect(preparedStatement.executeUpdate()).andThrow(new SQLException());
		replay(connection, preparedStatement);

		assertFalse(dao.addUser(connection, "Mary", "Jane", "MaryJane", "mj1234", "Mary.Jane@gmail.com", "user"));
	}

	@Test
	public void testAddUserPass() throws SQLException {
		preparedStatement.setString(anyInt(), anyString());
		preparedStatement.setString(anyInt(), anyString());
		preparedStatement.setString(anyInt(), anyString());
		preparedStatement.setString(anyInt(), anyString());
		preparedStatement.setString(anyInt(), anyString());
		preparedStatement.setString(anyInt(), anyString());

		expect(connection.prepareStatement(anyString())).andReturn(preparedStatement);
		expect(preparedStatement.executeUpdate()).andReturn(1);
		replay(connection, preparedStatement);

		assertTrue(dao.addUser(connection, "Michael", "Jane", "MaryJane", "mj1234", "Mary.Jane@gmail.com", "user"));
	}

	@Test(expected = SQLException.class)
	public void testRemoveUserByNameException() throws SQLException {
		preparedStatement.setString(anyInt(), anyString());

		expect(connection.prepareStatement(anyString())).andReturn(preparedStatement);
		expect(preparedStatement.executeUpdate()).andThrow(new SQLException());
		replay(connection, preparedStatement);

		dao.removeUserByName(connection, "Mugundhan");
	}

	@Test
	public void testRemoveUserByNamePass() throws SQLException {
		preparedStatement.setString(anyInt(), anyString());

		expect(connection.prepareStatement(anyString())).andReturn(preparedStatement);
		expect(preparedStatement.executeUpdate()).andReturn(1);
		replay(connection, preparedStatement);

		dao.removeUserByName(connection, "Mugundhan");
	}

	@Test(expected = SQLException.class)
	public void testUpdateUserdetailsException() throws SQLException {
		preparedStatement.setString(anyInt(), anyString());
		preparedStatement.setString(anyInt(), anyString());
		preparedStatement.setString(anyInt(), anyString());
		preparedStatement.setString(anyInt(), anyString());
		preparedStatement.setString(anyInt(), anyString());

		expect(connection.prepareStatement(anyString())).andReturn(preparedStatement);
		expect(preparedStatement.executeUpdate()).andThrow(new SQLException());
		replay(connection, preparedStatement);

		dao.updateUserdetails(connection, "Mary", "Jane", "MaryJane", "mj1234", "Mary.Jane@gmail.com", "user");
	}

	@Test
	public void testUpdateUserdetailsPass() throws SQLException {
		preparedStatement.setString(anyInt(), anyString());
		preparedStatement.setString(anyInt(), anyString());
		preparedStatement.setString(anyInt(), anyString());
		preparedStatement.setString(anyInt(), anyString());
		preparedStatement.setString(anyInt(), anyString());

		expect(connection.prepareStatement(anyString())).andReturn(preparedStatement);
		expect(preparedStatement.executeUpdate()).andReturn(1);
		replay(connection, preparedStatement);

		dao.updateUserdetails(connection, "Mary", "Jane", "MaryJanesfd", "mj1234", "Mary.Jane@gmail.com", "user");
	}

	@Test
	public void testViewUsersNull() throws SQLException {
		expect(connection.prepareStatement(anyString())).andReturn(preparedStatement);
		expect(preparedStatement.executeQuery()).andReturn(resultSet);
		expect(resultSet.next()).andReturn(false);
		replay(connection, preparedStatement, resultSet);

		List<User> users = dao.viewUsers(connection);

		assertTrue((users.isEmpty()));
	}

	@Test(expected = SQLException.class)
	public void testViewUsersException() throws SQLException {
		expect(connection.prepareStatement(anyString())).andReturn(preparedStatement);
		expect(preparedStatement.executeQuery()).andReturn(resultSet);
		expect(resultSet.next()).andThrow(new SQLException());
		replay(connection, preparedStatement, resultSet);

		dao.viewUsers(connection);
	}
}