package exam;
 
import java.sql.*;

public class Questions {

	public QuestionBean[] getQuestionBySubject(int subID)
	{
		QuestionBean[] qb=null;
		try
		{
			int num=1;
			Connection cn=database.CreateConnection.getConnection();
			PreparedStatement ps=cn.prepareStatement(Queries.getQuestionCount);
			ps.setInt(1, subID);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				num=rs.getInt(1);
			}
			rs.close();
			ps.close();
			if(num!=0)
			{
				int i=0;
				qb=new QuestionBean[num];
				ps=cn.prepareStatement(Queries.getQuestion);
				rs=ps.executeQuery();
				while(rs.next())
				{
					qb[i]=new QuestionBean();
					qb[i].setQuestionid(rs.getInt(1));
					qb[i].setQuestion(rs.getString(2));
					qb[i].setAns1(rs.getString(3));
					qb[i].setAns2(rs.getString(4));
					qb[i].setAns3(rs.getString(5));
					qb[i].setAns4(rs.getString(6));
					qb[i].setAns(rs.getInt(7));
					qb[i].setSubid(subID);
					qb[i].setModdate(rs.getDate(9));
					qb[i].setCreator(rs.getString(10));
					qb[i].used=false;
					i++;
				}
					return qb;
			}
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return qb;
	}
}
