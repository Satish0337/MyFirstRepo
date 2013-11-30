package model;

public class CommentInfo {
	
	private String commentId;
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public String getCommentDate() {
		return CommentDate;
	}
	public void setCommentDate(String commentDate) {
		CommentDate = commentDate;
	}
	public String getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}
	private String commentText;
	private String CommentDate;
	private String CreatedBy;
	

}
