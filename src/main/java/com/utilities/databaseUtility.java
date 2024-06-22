package com.utilities;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class databaseUtility {

    private static Connection conn;
    private static Statement stmt;
	
	public Connection getConnectionToDatabase() throws SQLException
	{
		
	    Driver d = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(d);
		conn = DriverManager.getConnection(IpathConstants.dbUrl, IpathConstants.dbUsername, IpathConstants.dbPassword);
		return conn;
	}
	
	public void retrieveDataFromDatabase(String query) throws SQLException
	{
	    stmt = conn.createStatement();
		ResultSet result = stmt.executeQuery(query);
		
		while(result.next())
		{
			System.out.println(result.getString(1));
		}
	}
	
	public void updateDatabase(String query) throws SQLException
	{
		stmt = conn.createStatement();
		int result = stmt.executeUpdate(query);
		
		if(result==1)
		{
			System.out.println("Database has been updated");
		}
		else {
			System.out.println("Some error occurs!!!!");
		}
		
	}
	
	public void disconnectionToDatabase()
	{
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
