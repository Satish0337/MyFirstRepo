package database;

import java.sql.*;

import javax.servlet.http.HttpServletRequest;

import model.PostList;
import model.Profile;

public class SaveInfo {
	
	public static void saveProfile(Profile pf)
	{
		Connection conn = CreateConnection.getConnection();
		PreparedStatement pst = null;
		try {
			
			pst = conn.prepareStatement("INSERT INTO PerfLogin values(?,?,'user')");
			pst.setString(1, pf.getEmail());
			pst.setString(2, pf.getPswd());
			pst.executeUpdate();
			
			pst = null;
			pst = conn.prepareStatement("INSERT INTO PerfProfile values(?,?,?,?,getdate()) ");
			pst.setString(1, pf.getEmail());
			pst.setString(2, pf.getName());
			pst.setString(3, pf.getAddress());
			pst.setString(4, pf.getContactno());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			CreateConnection.destroyConnection(conn, pst);
		}
	}
	
	public static String saveCategory(HttpServletRequest request)
	{
		Connection conn = CreateConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try
		{
			
			pst = conn.prepareStatement("SELECT * FROM PerfCategory WHERE cat_name = ? ");
			pst.setString(1, request.getParameter("catname"));
			rs = pst.executeQuery();
			if(rs.next())
				return "duplicate";
			pst = null;
			pst = conn.prepareStatement("INSERT INTO PerfCategory (cat_name) values " +
					"(?)");
			
			pst.setString(1, request.getParameter("catname"));
			pst.executeUpdate();
			return "saved";
		}
		catch(SQLException sqle)
		{
			System.out.println("Error in Saving category"+sqle.getMessage());
			return "error";
		}
		finally
		{
			CreateConnection.destroyConnection(conn,rs,pst);
		}
		
	}
	
	public static void saveAComment(HttpServletRequest request)
	{
		Connection conn = CreateConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try
		{
			pst = conn.prepareStatement("INSERT INTO PerfComment (postid,commenttext,commentdate," +
					"createdby) values(?,?,getDate(),?) ");
			pst.setInt(1, Integer.parseInt(request.getParameter("postid")));
			pst.setString(2,request.getParameter("comm"));
			String mail = ((model.Profile)request.getSession().getAttribute("profile")).getEmail();
			
			pst.setString(3, mail);
			
			pst.executeUpdate();
			
			pst = null;
			pst = conn.prepareStatement("SELECT COUNT(*) FROM PerfComment WHERE postid = ?");
			pst.setInt(1,Integer.parseInt(request.getParameter("postid")));
			rs = pst.executeQuery();
			
			if(rs.next())
				request.setAttribute("totalcomm", rs.getInt(1));
			
		}
		catch(SQLException sqle)
		{
			System.out.println("Error At saving comment in ajax"+sqle.getMessage());
		}
		
		finally
		{
			database.CreateConnection.destroyConnection(conn,rs,pst);
		}
	}
	
	public static void saveAPost(HttpServletRequest request)
	{
		
		Connection conn = CreateConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try
		{
			
			pst = conn.prepareStatement("INSERT INTO PerfPost (posttext,postdate,categoryid,createdby) values(?,getDate(),?,?);");
			pst.setString(1,request.getParameter("post"));
			pst.setInt(2,Integer.parseInt(request.getParameter("catid")));
			String mail = ((model.Profile)request.getSession().getAttribute("profile")).getEmail();
	
			pst.setString(3, mail);
			pst.executeUpdate();
			
			pst = null;
			pst = conn.prepareStatement("SELECT * FROM    " +
					"perfpost WHERE  " +
					"postid = IDENT_CURRENT('perfpost')");
			
			rs = pst.executeQuery();
			PostList tmpPost = new PostList();
			
			if(rs.next())
			{
				tmpPost.setPostid(rs.getString(1));
				tmpPost.setPostText(rs.getString(2));
				tmpPost.setPostDate(rs.getString(3));
				tmpPost.setPostCreatedBy(rs.getString(5));
			}
			
			pst = conn.prepareStatement("SELECT COUNT(*) FROM perfComment WHERE postid = ?");
			pst.setInt(1, Integer.parseInt(tmpPost.getPostid()));
			
			rs = pst.executeQuery();
			
			if(rs.next())
			{
				tmpPost.setNoOfComments(rs.getInt(1));
			}
			request.setAttribute("tmpPost", tmpPost);
		}
		catch(SQLException sqle)
		{
			System.err.println("Error At Saving Post "+sqle.getMessage());
		}
		finally
		{
			CreateConnection.destroyConnection(conn, rs, pst);
		}
			
	}

}
