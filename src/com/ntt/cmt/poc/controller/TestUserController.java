package com.ntt.cmt.poc.controller;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestUserController {
	
	UserController controller = new UserController();
	
	HttpServletRequest request;
	HttpServletResponse response;
	RequestDispatcher dispatcher;
	
	@Before
	public void setUp() {
		request = createMock(HttpServletRequest.class);
		response = createMock(HttpServletResponse.class);
		dispatcher = createMock(RequestDispatcher.class);
	}
	
	@After
	public void tearDocwn() {
		request = null;
		response = null;
	}

	@Test
	public void testAuthenticateUser() throws Exception {
		expect(request.getParameter("action")).andReturn("signup");
		expect(request.getRequestDispatcher("/signup.jsp")).andReturn(dispatcher);
		replay(request);
		
		controller.doPost(request, response);
		
		assertNotNull(response);
		assertEquals(0, response.getStatus());
	}
	
}
