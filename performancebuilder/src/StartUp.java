

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.CreateConnection;

import java.sql.*;
/**
 * Servlet implementation class StartUp
 */
public class StartUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   public void init()
   {
	   ServletContext sc = getServletContext();
	   CreateConnection.username = sc.getInitParameter("username");
	   CreateConnection.password = (String)sc.getInitParameter("password");
	}
}
