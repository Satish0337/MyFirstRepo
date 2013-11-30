package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class CreateConnection {
	
	public static String username,password;
	public static Connection getConnection()
	{
		Connection conn;
		String url ="jdbc:sqlserver://202.141.152.6;" +
			   		"databaseName=fpgdst11;user="+username+";password="+password;
		String driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		
		try {
				Class.forName(driver);
				conn=DriverManager.getConnection(url);
				System.out.println("Connected To Database");
				return conn;
				
		}
		 catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			return null;
		}
		
		catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		
		} 
	}
	
	public static void destroyConnection(Connection conn,ResultSet rs,Statement st)
	{
		if(conn != null)
		{
			try{
			if(conn != null)	
			conn.close();
			if(rs != null)
			rs.close();
			if(st != null)
			st.close();
			System.out.println("Connection Closed");
			System.out.println("----------------------");
			}
			catch(SQLException sqle)
			{
				System.err.println("Error in closing connection "+sqle.getMessage());
			}
		}
		
	}
	
	public static void destroyConnection(Connection conn)
	{
		if(conn != null)
		{
			try{
			if(conn != null)	
			conn.close();
			System.out.println("Connection Closed");
			System.out.println("----------------------");
			}
			catch(SQLException sqle)
			{
				System.err.println("Error in closing connection"+sqle.getMessage());
			}
		}
		
	}
	
	public static void destroyConnection(Connection conn,PreparedStatement pst)
	{
		if(conn != null)
		{
			try{
			conn.close();
			if(pst != null)
			pst.close();
			System.out.println("Connection Closed");
			System.out.println("----------------------");
			}
			catch(SQLException sqle)
			{
				System.err.println("Error in closing connection"+sqle.getMessage());
			}
		}
		
	}

}
