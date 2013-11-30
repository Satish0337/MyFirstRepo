package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForumList
 */
public class ForumList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForumList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			database.GetInfo.getPostList(request);
			model.Profile pf = (model.Profile)request.getSession().getAttribute("profile");
			RequestDispatcher rd;
			System.out.println("Role is "+pf.getRole());
			if(pf.getRole().trim().equals("user"))
			
			 rd = request.getRequestDispatcher("user_forumlist.jsp");
			else
			{
					System.out.println("You are in else");
					rd = request.getRequestDispatcher("admin_forumlist.jsp");
			}
			rd.forward(request, response);
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response );
	}

}
