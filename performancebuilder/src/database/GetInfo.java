package database;

import java.sql.*;


import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;

import model.CommentInfo;
import model.PostCommInfo;

import java.util.*;


public class GetInfo {
	
	public static void getCategoryList(HttpServletRequest request)
	{
		Connection conn  = CreateConnection.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try
		{
			pst = conn.prepareStatement("SELECT * FROM PerfCategory");
			rs = pst.executeQuery();
			request.setAttribute("list", rs);
			request.setAttribute("conn", conn);
			request.setAttribute("stat", pst);
		}
		catch(SQLException sqle)
		{
			CreateConnection.destroyConnection(conn, rs, pst);
			System.out.println("Error in getting Categories List "+ sqle.getMessage());
			
		}
	}
	
	public static void getPostList(HttpServletRequest request)
	{
		Connection conn  = CreateConnection.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		ArrayList<model.PostList> listOfPost = new ArrayList<model.PostList>();
		try
		{
				
			/*	pst = conn.prepareStatement("select p.postid,count(q.commentid)no,p.postdate,p.createdby " +
					"from perfpost p , perfcomment q " +
					"where p.postid = q.postid " +
					"group by p.postid,p.postdate,p.createdby");
				rs = pst.executeQuery(); */
			
			pst = conn.prepareStatement("select * from perfpost where categoryid = ? order by postdate desc");
			pst.setString(1, request.getParameter("categoryid"));
			
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				model.PostList tempPost = new model.PostList();
				String tmpStr = rs.getString(2);
				if(tmpStr.length() > 100 )
					tmpStr = tmpStr.substring(0,100);
				
				tempPost.setPostText(tmpStr);
				tempPost.setPostid(rs.getString(1));
				tempPost.setPostCreatedBy(rs.getString(5));
				tempPost.setPostDate(rs.getDate(3).toString());
				
				pst = null ;
				pst = conn.prepareStatement("select count(*) from perfcomment where " +
						"postid = ? ");
				
				pst.setString(1, tempPost.getPostid());
				ResultSet rs2 = pst.executeQuery();
				
				if(rs2.next())
					tempPost.setNoOfComments(rs2.getInt(1));
				
				listOfPost.add(tempPost);
				
			}
			
			request.setAttribute("postInfo", listOfPost);
			
		}
		catch(SQLException sqle)
		{
			CreateConnection.destroyConnection(conn, rs, pst);
			System.out.println("Error in getting Categories List "+ sqle.getMessage());
			
		}
		
		finally
		{
			CreateConnection.destroyConnection(conn,rs, pst);
		}
	}
	
	public static void getAPost(HttpServletRequest request)
	{
		Connection conn  = CreateConnection.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try
		{
			pst = conn.prepareStatement("select posttext from perfpost where postid = ?");
			pst.setString(1, request.getParameter("postid"));
			rs = pst.executeQuery();
			
			if(rs.next())
			{
				request.setAttribute("postText", rs.getString("posttext"));
			}
		}
		catch(SQLException sqle)
		{
			
		}
		finally
		{
			CreateConnection.destroyConnection(conn,rs, pst);
		}
	}
	
	public static void getPostCommentInfo(HttpServletRequest request, PostCommInfo pstComInf)
	{
		Connection conn  = CreateConnection.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try
		{
			pst = conn.prepareStatement("SELECT * FROM PerfPost WHERE postid = ?");
			pst.setString(1, request.getParameter("postid"));
			rs = pst.executeQuery();
			if(rs.next())
			{
				pstComInf.setPostId(rs.getString(1));
				pstComInf.setPostData(rs.getString(2));
				pstComInf.setPostDate(rs.getDate(3).toString());
				pstComInf.setCreatedBy(rs.getString(5));
				
				pst = null;
				
				pst = conn.prepareStatement("SELECT * FROM PerfComment WHERE postid=? ORDER BY commentdate desc ");
				pst.setString(1, request.getParameter("postid"));
			
				rs = pst.executeQuery();
				ArrayList<model.CommentInfo> comments = new ArrayList<CommentInfo>();
				while(rs.next())
				{
					model.CommentInfo tempComment = new CommentInfo();
					tempComment.setCommentId(rs.getString(1));
					tempComment.setCommentText(rs.getString(3));
					tempComment.setCommentDate(rs.getDate(4).toString());
					tempComment.setCreatedBy(rs.getString(5));
					
					comments.add(tempComment);
				}
				pstComInf.setComments(comments);
			}
		}
		catch(SQLException sqle)
		{
			System.out.println("Error At getPostCommentInfo "+sqle.getMessage());
		}
		finally
		{
			CreateConnection.destroyConnection(conn,rs, pst);
		}
	}
	
	public static void noOfPostPerCategory(int catid,HttpServletRequest request)
	{
		Connection conn  = CreateConnection.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try
		{
			pst = conn.prepareStatement("SELECT COUNT(*) FROM PerfPost WHERE categoryid = ? ");
			pst.setInt(1, catid);
			rs = pst.executeQuery();
			
			if(rs.next())
			{
				request.setAttribute("curr", rs.getString(1));
			}
			
		}
		catch(SQLException sqle)
		{
			System.out.println("Error At No Of Comment "+sqle.getMessage());
			
		}
		finally
		{
			CreateConnection.destroyConnection(conn, rs, pst);
		}
	}

}
