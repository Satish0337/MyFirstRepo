package exam;

import java.io.Serializable;
import java.util.Date;

public class ExamBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int duration,nquestions,subjectId;
	private long examid;
	private Date examDate,modifiedDate;
	private String creator;
	
	/**
	 *	Blank Constructor 
	 */
	public ExamBean() {
		
	}
	
	/**
	 * @param examid
	 * @param examDate
	 * @param duration
	 * @param nquestions
	 * @param subjectId
	 * @param modifiedDate
	 * @param creator
	 */
	public ExamBean(int examid, Date examDate, int duration, int nquestions,
			int subjectId, Date modifiedDate, String creator) {
		this.examid = examid;
		this.examDate = examDate;
		this.duration = duration;
		this.nquestions = nquestions;
		this.subjectId = subjectId;
		this.modifiedDate = modifiedDate;
		this.creator = creator;
	}

	public long getExamid() {
		return examid;
	}

	public void setExamid(long id) {
		this.examid = id;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getNquestions() {
		return nquestions;
	}

	public void setNquestions(int nquestions) {
		this.nquestions = nquestions;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	
}
