package com.jboss.teiid.client;

import java.sql.Connection;

import com.jboss.teiid.client.util.JDBCUtil;

public class PortfolioClient {
	
	private static final String JDBC_DRIVER = "org.teiid.jdbc.TeiidDriver";
	private static final String JDBC_URL = "jdbc:teiid:Portfolio@mm://localhost:31000;version=1";
	private static final String JDBC_USER = "user";
	private static final String JDBC_PASS = "password1!";
	
	private static final String SQL_QUERY_MARKETDATA= "SELECT * FROM Marketdata" ;
	private static final String SQL_QUERY_PRODUCT= "SELECT * FROM PRODUCT" ;
	private static final String SQL_QUERY_FILE= "SELECT A.* FROM (EXEC MarketData.getTextFiles('marketdata.csv')) AS f, TEXTTABLE(f.file COLUMNS SYMBOL string, PRICE bigdecimal HEADER) AS A" ;
	private static final String SQL_QUERY_FEDERATION = "SELECT * FROM Stock";
	private static final String SQL_QUERY_FEDERATION_JOIN = "select product.symbol, stock.price, company_name from product, (EXEC MarketData.getTextFiles('marketdata.csv')) f, TEXTTABLE(f.file COLUMNS symbol string, price bigdecimal HEADER) stock where product.symbol=stock.symbol";
	private static final String SQL_QUERY_FEDERATION_JOIN_ = "SELECT A.ID, S.symbol, S.price, A.COMPANY_NAME FROM Marketdata AS S, PRODUCT AS A WHERE S.symbol = A.SYMBOL";
	
	public static void main(String[] args) throws Exception {

		Connection conn = JDBCUtil.getDriverConnection(JDBC_DRIVER, JDBC_URL, JDBC_USER, JDBC_PASS);
		
		try {
			JDBCUtil.executeQuery(conn, SQL_QUERY_MARKETDATA);
			
			JDBCUtil.executeQuery(conn, SQL_QUERY_PRODUCT);
			
			JDBCUtil.executeQuery(conn, SQL_QUERY_FILE);
			
			JDBCUtil.executeQuery(conn, SQL_QUERY_FEDERATION);
			
			JDBCUtil.executeQuery(conn, SQL_QUERY_FEDERATION_JOIN);
			
			JDBCUtil.executeQuery(conn, SQL_QUERY_FEDERATION_JOIN_);
		} catch (Exception e) {
			throw e;
		} finally {
			JDBCUtil.close(conn);
		}
	}

}
