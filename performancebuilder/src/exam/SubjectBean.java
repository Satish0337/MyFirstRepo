package exam;

import java.io.Serializable;
import java.util.Date;

public class SubjectBean implements Serializable 
{

		private int subjectid;
		private String subName,creator;
		private Date modifiedDate;
		
		
		
		public SubjectBean() {
			super();
		}



		public SubjectBean(int subjectid, String subName, String creator,
				Date modifiedDate) {
			super();
			this.subjectid = subjectid;
			this.subName = subName;
			this.creator = creator;
			this.modifiedDate = modifiedDate;
		}



		public int getSubjectid() {
			return subjectid;
		}



		public void setSubjectid(int subjectid) {
			this.subjectid = subjectid;
		}



		public String getSubName() {
			return subName;
		}



		public void setSubName(String subName) {
			this.subName = subName;
		}



		public String getCreator() {
			return creator;
		}



		public void setCreator(String creator) {
			this.creator = creator;
		}



		public Date getModifiedDate() {
			return modifiedDate;
		}



		public void setModifiedDate(Date modifiedDate) {
			this.modifiedDate = modifiedDate;
		}
		
		
		
}
