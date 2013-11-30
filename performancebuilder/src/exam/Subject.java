package exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Subject {

	public boolean addSubject(SubjectBean sb)
	{
		try
		{
			Connection cn=database.CreateConnection.getConnection();
			PreparedStatement ps=cn.prepareStatement(Queries.addSubjectQuery);
			ps.setString(1,sb.getSubName());
			ps.setString(2, sb.getCreator());
			if(ps.executeUpdate()>0)
				return true;
			database.CreateConnection.destroyConnection(cn);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return false;
	}
	
	
	public boolean isExist(String subject)
	{
		try
		{
			Connection cn=database.CreateConnection.getConnection();
			PreparedStatement ps=cn.prepareStatement(Queries.checkSubjectQuery);
			ps.setString(1, subject);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				return true;
			database.CreateConnection.destroyConnection(cn);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	
	public SubjectBean[] getSubjectsByUser(String user)
	{
		SubjectBean[] sb=null;
		try
		{
			Connection cn=database.CreateConnection.getConnection();
			PreparedStatement ps=cn.prepareStatement(Queries.getSubjectCountByUser);
			ps.setString(1, user);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				int i=rs.getInt(1);
				sb=new SubjectBean[i];
				for(int j=0;j<i;j++)
					sb[j]=new SubjectBean();
			}
			rs.close();
			ps.close();
			ps=cn.prepareStatement(Queries.getSubjectByUser);
			rs=ps.executeQuery();
			int k=0;
			while(rs.next())
			{
				sb[k].setSubjectid(rs.getInt(1));
				sb[k].setSubName(rs.getString(2));
				sb[k].setModifiedDate(rs.getDate(3));
				sb[k].setCreator(rs.getString(4));
				k++;
			}

			database.CreateConnection.destroyConnection(cn);
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
		return sb;
	}

	public SubjectBean[] getSubjectsNotByMe(String user)
	{
		SubjectBean [] sb=null;
		try
		{
			Connection cn=database.CreateConnection.getConnection();
			PreparedStatement ps=cn.prepareStatement(Queries.getSubjectCountNotByUser);
			ps.setString(1, user);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				int i=rs.getInt(1);
				sb=new SubjectBean[i];
				for(int j=0;j<i;j++)
					sb[j]=new SubjectBean();
			}
			rs.close();
			ps.close();
			ps=cn.prepareStatement(Queries.getSubjectNotByUser);
			rs=ps.executeQuery();
			int k=0;
			while(rs.next())
			{
				sb[k].setSubjectid(rs.getInt(1));
				sb[k].setSubName(rs.getString(2));
				sb[k].setModifiedDate(rs.getDate(3));
				sb[k].setCreator(rs.getString(4));
				k++;
			}

			database.CreateConnection.destroyConnection(cn);
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
		return sb;
	}
	
}
