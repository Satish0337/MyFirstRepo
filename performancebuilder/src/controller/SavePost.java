package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PostList;

import java.util.*;

import database.CreateConnection;

/**
 * Servlet implementation class SavePost
 */
public class SavePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SavePost() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("called the controller");
		database.SaveInfo.saveAPost(request);
		PostList tmpPost = (PostList)request.getAttribute("tmpPost");
		database.GetInfo.noOfPostPerCategory(Integer.parseInt(request.getParameter("catid")),request);
		int curr = Integer.parseInt((String)request.getAttribute("curr"));
		curr++;
		String finalPost = tmpPost.getPostText();
		if(tmpPost.getPostText().length() > 98 )
		{
			finalPost = tmpPost.getPostText().substring(0, 95);
		}
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("<div class='cell_text'>"+finalPost);
		if(tmpPost.getPostText().length() > 98 )
		{
			strBuff.append("<span class='spanr' onclick ='getPost(event,"+tmpPost.getPostid()+","+curr+")' id" +
					" ='read "+curr+"'>read more...</span>");
		}
		
		else
		{
			strBuff.append("<span class='spanc' onclick ='getPost(event,"+tmpPost.getPostid()+","+curr+")' id" +
					" ='read "+curr+"'><br/>add Comment...</span>");
		}
		
		strBuff.append("</div>");
		strBuff.append("<div class='cell_centre'>"+tmpPost.getPostCreatedBy()+"</div>");
		strBuff.append("<div class='cell_centre'>"+tmpPost.getPostDate()+"</div>");
		strBuff.append("<div class='cell_centre' id='com"+curr+"'><a href='CommentView?postid="+tmpPost.getPostid()+"'>" +
				""+tmpPost.getNoOfComments()+"</a></div>");
		strBuff.append("<div class='cell_centre'><a href='#'>Edit</a>|<a href='#'>Delete</a></div>");
		
		System.out.println(strBuff.toString());
		response.getWriter().println(strBuff.toString());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
