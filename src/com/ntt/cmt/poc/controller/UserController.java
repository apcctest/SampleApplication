package com.ntt.cmt.poc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ntt.cmt.poc.dao.UserDao;
import com.ntt.cmt.poc.model.User;
import com.ntt.cmt.poc.util.DBUtil;

public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UserDao dao;

	private Connection connection;

	public UserController() {
		super();
		dao = new UserDao();
		connection = DBUtil.getConnection();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String actionForward = "";
		String action = request.getParameter("action");

		System.out.println("Action: " + action);

		try {
			if ("signup".equals(action)) {
				actionForward = "/signup.jsp";
			} else if ("login".equals(action)) {
				actionForward = "/login.jsp";
			} else if ("register".equals(action)) {
				String firstName = request.getParameter("firstname");
				String lastName = request.getParameter("lastname");
				String userName = request.getParameter("username");
				String password = request.getParameter("password");
				String emailAddress = request.getParameter("emailid");
				String role = "user";
				Boolean result = true;
				
				
				if (!(emailAddress.contains("@") && emailAddress.contains("."))){
					request.setAttribute("message", "Invalid Email ID, Please retry");
					actionForward = "/signup.jsp";
				} else {

					result = dao.addUser(connection, firstName, lastName, userName, password, emailAddress, role);

					if (result) {
						request.setAttribute("message", "Welcome to our blog " + userName);
						actionForward = "/user.jsp";
					} else {
						request.setAttribute("message", "User " + userName + " already exists!.. Please choose a different User name");
						actionForward = "/signup.jsp";
					}
				}
			} else if ("authenticate".equals(action)) {
				String userName = request.getParameter("username");
				String password = request.getParameter("password");
			//Srikar			
			System.out.println("Srikar2: username="+userName+"Password"+password);

				User user = dao.authenticateUser(connection, userName, password);

				if (null != user) {
					System.out.println("USER found: " + user);
					System.out.println("USER Name: " + user.getUserName());					
					
					request.setAttribute("message", "Welcome back " + user.getUserName());
					
					if ("admin".equalsIgnoreCase(user.getRole())) {
						actionForward = "/admin.jsp";
					} else {
						actionForward = "/user.jsp";
					}
				} else {
					System.out.println("USER not found");
					request.setAttribute("message", "Invalid credentials!. Please enter the valid details.");
					actionForward = "/login.jsp";
				}
			} else if ("manageusers".equals(action)) {
				List<User> users = dao.viewUsers(connection);

				request.setAttribute("userlist", users);

				actionForward = "/viewusers.jsp";

			} else if ("removeuser".equals(action)) {
				String username = request.getParameter("usernametoworkon");

				dao.removeUserByName(connection, username);

				List<User> users = dao.viewUsers(connection);

				request.setAttribute("userlist", users);

				actionForward = "/viewusers.jsp";

			} else if ("edituser".equals(action)) {
				String username = request.getParameter("usernametoworkon");

				User user = dao.getUserByUserName(connection, username);

				request.setAttribute("user", user);

				actionForward = "/edituser.jsp";

			} else if ("updateuserdetails".equals(action)) {

				String firstName = request.getParameter("firstname");
				String lastName = request.getParameter("lastname");
				String userName = request.getParameter("username");
				String password = request.getParameter("password");
				String emailAddress = request.getParameter("emailid");
				String role = "user";

				System.out.println("first name: " + firstName);

				System.out.println("email: " + emailAddress);

				dao.updateUserdetails(connection, firstName, lastName, userName, password, emailAddress, role);

				List<User> users = dao.viewUsers(connection);

				request.setAttribute("userlist", users);

				actionForward = "/viewusers.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher view = request.getRequestDispatcher(actionForward);
		view.forward(request, response);
	}

}
