package com.jboss.teiid.client;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import com.jboss.teiid.client.util.JDBCUtil;

public class WebServiceClient {
	
	private static final String JDBC_DRIVER = "org.teiid.jdbc.TeiidDriver";
	private static final String JDBC_URL = "jdbc:teiid:WebServiceVDB@mm://localhost:31000;version=1";
	private static final String JDBC_USER = "user";
	private static final String JDBC_PASS = "user";
	
	private static final String SQL_QUERY_TXT_PRE = "<tns:CapitalCity xmlns:tns=\"http://www.oorsprong.org/websamples.countryinfo\"><sCountryISOCode>CNA</sCountryISOCode></tns:CapitalCity>" ;
	private static final String SQL_QUERY_TXT = "EXEC CountryInfoServiceView.CapitalCity_response('" + SQL_QUERY_TXT_PRE + "')";
	
	public static void main(String[] args) throws Exception {
		
		Connection conn = JDBCUtil.getDriverConnection(JDBC_DRIVER, JDBC_URL, JDBC_USER, JDBC_PASS);
		
		JDBCUtil.executeQuery(conn, "EXEC CountryInfoServiceView.CapitalCity_request('CNA')");
		
//		JDBCUtil.executeQuery(conn, SQL_QUERY_TXT);
		
		CallableStatement stmt = conn.prepareCall(SQL_QUERY_TXT);
		stmt.execute();
		ResultSet rs = stmt.getResultSet();
//		rs.next();
		System.out.println(rs.next());
		
		ResultSetMetaData metadata = rs.getMetaData();
		int columns = metadata.getColumnCount();
		
		System.out.println(columns);
		System.out.println(metadata.getColumnTypeName(1));
	}

}
