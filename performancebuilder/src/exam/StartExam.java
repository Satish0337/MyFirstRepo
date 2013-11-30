package exam;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StartExam
 */
public class StartExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartExam() {
        super();
        // TODO Auto-generated constructor stub
    }
/**
 *	Process and Data to be stored in Session before exam Starts
 *
 * @param request
 * @param response
 * @throws ServletException
 * @throws IOException
 */
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	int exid=Integer.parseInt(request.getParameter("exam"));
    	Exam ex=new Exam();
    	ExamBean eb=ex.getExamByID(exid);
    	HttpSession ss=request.getSession(false);
    	
    	int subid=eb.getSubjectId();
    	Questions q=new Questions();
    	QuestionBean[] qb=q.getQuestionBySubject(subid);
    	QuestionBean examQuestions[]=null; 
    	int nquestions=eb.getNquestions();
    	examQuestions=new QuestionBean[nquestions];//array of questions to be used in exam 
    	int answers[]=new int[nquestions];
    	
     	for(int i=0;i<nquestions;i++)
    	{
     		answers[i]=0;
    		//selecting random index
    		int index=(int) ((Math.random()*100)%qb.length);
    		
    		//checking if question is used
    		if(qb[index].used==false)
    		{
    			qb[index].used=true;//marking question as used
    			examQuestions[i]=new QuestionBean(qb[index]);//copying question to be used array for actual exam
    		}
    		else
    			continue;
    	}
     	//setting values to needed in exam inside the session
     	ss.setAttribute("exam", eb);
    	ss.setAttribute("currentQuestion",1);
     	ss.setAttribute("questions",examQuestions);
     	ss.setAttribute("answer", answers);
     	response.sendRedirect("/examinterface.jsp");
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
