package exam;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EndExamServlet
 */
public class EndExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EndExamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	HttpSession ss=request.getSession(false);
    	int attempted=0,right=0,wrong=0;
    	int[] answers=(int[]) ss.getAttribute("answer");
    	QuestionBean [] questions=(QuestionBean[]) ss.getAttribute("questions");
    	
    	//check for attempted and correct answers
    	for(int i=0;i<questions.length;i++)
    	{
    		if(answers[i]!=0)
    		{
    			attempted++;
    			if(answers[i]==questions[i].getAns())
    			{
    				right++;
    			}
    			else
    			{
    				wrong++;
    			}
    		}
    	}
    	System.out.println("Attepmted="+attempted);
    	System.out.println("Right="+right);
    	System.out.println("Wrong="+wrong);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

}
