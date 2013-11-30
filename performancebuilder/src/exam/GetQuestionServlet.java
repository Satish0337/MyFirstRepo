package exam;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * Servlet implementation class GetQuestionServlet
 */
public class GetQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.print(request.getParameter("num"));
		int num=Integer.parseInt(request.getParameter("num"));
		
		HttpSession ss=request.getSession(false);
		ss.setAttribute("currentQuestion", num);
		QuestionBean[] qb=(QuestionBean[]) ss.getAttribute("questions");
		if(qb!=null)
		{
			QuestionBean q=new QuestionBean(qb[num-1]);
			PrintWriter pw=response.getWriter();
			pw.print("<div>"+q.getQuestion()+"</div><br/>");
			pw.print("	<input type=radio name='answer' value='1' onclick='JavaScript:setAnswer(1)' >"+q.getAns1() +"</input><br/>"+
					"<input type=radio name='answer' value='2' onclick='JavaScript:setAnswer(2)'> "+q.getAns2()+"</input><br/>"+
					"<input type=radio name='answer' value='3' onclick='JavaScript:setAnswer(3)'>"+q.getAns3() +"</input><br/>"+
					"<input type=radio name='answer' value='4' onclick='JavaScript:setAnswer(4)'>"+ q.getAns4()+"</input><br/>");
		}
		else
		{
			response.getWriter().print("No question found in session");
		}
	}
}
