package model;

import java.util.ArrayList;

public class PostCommInfo {
	
	private String postId;
	private String postData;
	
	public String getPostData() {
		return postData;
	}
	public void setPostData(String postData) {
		this.postData = postData;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public ArrayList<model.CommentInfo> getComments() {
		return comments;
	}
	public void setComments(ArrayList<model.CommentInfo> comments) {
		this.comments = comments;
	}
	private String postDate;
	private String createdBy;
	private ArrayList<model.CommentInfo> comments ;
	
}
