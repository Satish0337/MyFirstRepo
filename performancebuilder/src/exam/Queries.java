package exam;

public final class Queries {

	public static final String getExamByIdQuery="select * from PerfExam where examid=?";
	public static final String addExamQuery="insert into PerfExam values(?,?,?,?,getdate(),?,?)";
	public static final String updateExamQuery="update PerfExam set ";
	public static final String getExamIDQuery="select examid from PerfExam where examid >?";
	
	
	public static final String getQuestionCount="select count(*) from PerfQuestion where subjectid=? ";
	public static final String getQuestion="select * from PerfQuestion where subjectid=? ";
	
	
	
	
	//Subject
	public static final String addSubjectQuery="insert into PerfSubject values(?,getDate(),?)";
	public static final String getSubjectByID="select * from PerfSubject where subjectid=?";
	public static final String getSubjectByUser="select * from PerfSubject where createdby=?";
	public static final String getSubjectCountByUser="select count(*) from PerfSubject where createdby=?";
	
	public static final String getSubjectNotByUser="select * from PerfSubject where createdby<>?";
	public static final String getSubjectCountNotByUser="select count(*) from PerfSubject where createdby<>?";
	
	public static final String updateSubject="update PerfSubject set subjectname=?, modifieddate=getDate()";
	public static final String checkSubjectQuery="select * from PerfSubject where subjectname=?";
 	
}
