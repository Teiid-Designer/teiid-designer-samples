package com.jboss.teiid.client;

import java.sql.Connection;

import com.jboss.teiid.client.util.JDBCUtil;

public class AccountClient {

	private static final String JDBC_DRIVER = "org.teiid.jdbc.TeiidDriver";
	private static final String JDBC_URL = "jdbc:teiid:Account@mm://localhost:31000;version=1";
	private static final String JDBC_USER = "user";
	private static final String JDBC_PASS = "user";
	
	private static final String SQL_QUERY_TXT = "SELECT * FROM Stock" ;

	public static void main(String[] args) throws Exception {

		Connection conn = JDBCUtil.getDriverConnection(JDBC_DRIVER, JDBC_URL, JDBC_USER, JDBC_PASS);
		
		try {
			JDBCUtil.executeQuery(conn, SQL_QUERY_TXT);
		} catch (Exception e) {
			throw e;
		} finally {
			JDBCUtil.close(conn);
		}
	}

}
