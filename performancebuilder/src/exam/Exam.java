package exam;
import java.sql.*;
//import java.util.*;
public class Exam {

	public ExamBean getExamByID(long id)
	{
		ExamBean eb=null;
		try{
			Connection cn=database.CreateConnection.getConnection();
			PreparedStatement ps=cn.prepareStatement(Queries.getExamByIdQuery);
			ps.setLong(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				eb=new ExamBean();
				eb.setExamid(id);
				eb.setExamDate(rs.getDate(2));
				eb.setDuration(rs.getInt(3));
				eb.setNquestions(rs.getInt(4));
				eb.setModifiedDate(rs.getDate(5));
				eb.setSubjectId(rs.getInt(6));
				eb.setCreator(rs.getString(7));
				return eb;
			}
			database.CreateConnection.destroyConnection(cn);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			
		}
		return eb;
	}
	
	public boolean addExam(ExamBean eb)
	{
		
		return false;
	}
	
	@SuppressWarnings("deprecation")
	public long getExamID(ExamBean eb )
	{
		int y=eb.getExamDate().getYear();
		int m=eb.getExamDate().getMonth();
		int d=eb.getExamDate().getDate();
		String i=y+""+m+""+d+""+eb.getSubjectId()+"0";
		long id=Long.parseLong(i);
		try
		{
			Connection cn=database.CreateConnection.getConnection();
			PreparedStatement ps=cn.prepareStatement(Queries.getExamIDQuery);
			ps.setLong(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				id=rs.getLong(1);
				id++;
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return id;
	}
}
