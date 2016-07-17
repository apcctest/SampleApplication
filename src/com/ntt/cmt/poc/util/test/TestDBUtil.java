package com.ntt.cmt.poc.util.test;

import static org.junit.Assert.assertNotNull;
import java.sql.Connection;

import org.junit.Test;

import com.ntt.cmt.poc.util.DBUtil;

public abstract class TestDBUtil {
	
	@Test void testAuthenticateUser() {
		
		Connection connection =  DBUtil.getConnection();
		
		assertNotNull(connection);
	}
}
