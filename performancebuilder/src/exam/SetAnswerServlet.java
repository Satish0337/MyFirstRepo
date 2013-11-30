package exam;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SetAnswerServlet
 */
public class SetAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetAnswerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss=request.getSession(false);
		int answer=Integer.parseInt(request.getParameter("ans"));
		int [] answers=(int[]) ss.getAttribute("answer");
		int curr=(Integer) ss.getAttribute("currentQuestion");
		answers[curr]=answer;//changed answer of particular question at current index 
		ss.setAttribute("answer", answers);
		
	}
}
