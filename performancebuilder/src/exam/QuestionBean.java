package exam;

import java.util.Date;

public class QuestionBean {

	private int questionid,ans,subid;
	private String question,ans1,ans2,ans3,ans4,creator;
	private Date moddate;
	public boolean used=false;
	
	/**
	 * 
	 */
	public QuestionBean() {
	}

	/**
	 * @param questionid
	 * @param question
	 * @param ans1
	 * @param ans2
	 * @param ans3
	 * @param ans4
	 * @param ans
	 * @param subid
	 * @param moddate
	 * @param creator
	 */
	public QuestionBean(int questionid, String question, String ans1,
			String ans2, String ans3, String ans4, int ans, int subid,
			Date moddate, String creator) {
		this.questionid = questionid;
		this.question = question;
		this.ans1 = ans1;
		this.ans2 = ans2;
		this.ans3 = ans3;
		this.ans4 = ans4;
		this.ans = ans;
		this.subid = subid;
		this.moddate = moddate;
		this.creator = creator;
	}

	public QuestionBean(QuestionBean qb)
	{
		this.questionid = qb.questionid;
		this.question = qb.question;
		this.ans1 = qb.ans1;
		this.ans2 = qb.ans2;
		this.ans3 = qb.ans3;
		this.ans4 = qb.ans4;
		this.ans = qb.ans;
		this.subid = qb.subid;
		this.moddate = qb.moddate;
		this.creator = qb.creator;
	}
	
	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public int getAns() {
		return ans;
	}

	public void setAns(int ans) {
		this.ans = ans;
	}

	public int getSubid() {
		return subid;
	}

	public void setSubid(int subid) {
		this.subid = subid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAns1() {
		return ans1;
	}

	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}

	public String getAns2() {
		return ans2;
	}

	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}

	public String getAns3() {
		return ans3;
	}

	public void setAns3(String ans3) {
		this.ans3 = ans3;
	}

	public String getAns4() {
		return ans4;
	}

	public void setAns4(String ans4) {
		this.ans4 = ans4;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getModdate() {
		return moddate;
	}

	public void setModdate(Date moddate) {
		this.moddate = moddate;
	}
	
	
	
}
