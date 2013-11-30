package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.CreateConnection;
import java.sql.*;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		model.Profile pf = new model.Profile();
		boolean flag=false;
		Connection conn = CreateConnection.getConnection();
		try
		{
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM PerfLogin");
			while(rs.next())
			{
				if(request.getParameter("uid").equals(rs.getString("email")) && 
						request.getParameter("pswd").equals(rs.getString("password")))
				{
					flag=true;
					HttpSession session = request.getSession(true);
					session.setAttribute("isAuthenticate", "yes");	
					makeProfileBean(request, pf);
					session.setAttribute("profile", pf);
					System.out.println("Authenticated");
					System.out.println("User type "+rs.getString("role"));
					String utype=rs.getString("role").trim();
					CreateConnection.destroyConnection(conn, rs, st);
					if(utype.equalsIgnoreCase("user"))
					{
						RequestDispatcher rd = request.getRequestDispatcher("/user_home.jsp");
						System.out.println("user");
						rd.forward(request, response);
					}
					else if(utype.equals("admin"))
					{
						RequestDispatcher rd = request.getRequestDispatcher("/admin.jsp");
						System.out.println("Admin");
						rd.forward(request, response);
					}
					break;
				}
			}
			if(!flag)
			{
				response.sendRedirect("index.jsp?error='user_not_found'");
				
			}
			
		}
		catch(SQLException sqle)
		{
			System.out.println("Error At LoginController"+sqle.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		
		doGet(request,response);
		
	}
	
	 private void makeProfileBean(HttpServletRequest req,model.Profile pf)
	     {
		 		Connection conn = CreateConnection.getConnection();
		 		PreparedStatement pst = null;
		 		ResultSet rs = null;
		 		try
		 		{
		 			pst = conn.prepareStatement("SELECT t1.email,t2.name,t2.contactno,t2.address,t1.password ,t1.role " +
		 					"FROM PerfLogin t1 join PerfProfile t2 on " +
		 					"t1.email=t2.email WHERE t1.email=?");
		 			pst.setString(1, req.getParameter("uid"));
		 			
		 			rs = pst.executeQuery();
		 			
		 			if(rs.next())
		 			{
		 				pf.setEmail(rs.getString(1).trim());
		 				pf.setName(rs.getString(2).trim());
		 				pf.setContactno(rs.getString(3).trim());
		 				pf.setAddress(rs.getString(4).trim());
		 				pf.setPswd(rs.getString(5).trim());
		 				pf.setRole(rs.getString(6).trim());
		 				
		 			}
		 			
		 		}
		 		catch(SQLException sqle)
		 		{
		 			System.err.println("Error at Making Bean "+sqle);
		 		}
		 		
		 		finally
		 		{
		 			CreateConnection.destroyConnection(conn, rs, pst);
		 		}
		 		
	     }
}
