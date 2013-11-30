<%@page import="java.util.Iterator"%>
<%@page import="model.PostList"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <% ArrayList<PostList> postList = (ArrayList<PostList>)request.getAttribute("postInfo");
 %>   
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
		<title>Performance Builder | Forum List by Category</title>
		<link href="css/style.css" rel="stylesheet" />
		<link href="menu_assets/styles.css" rel="stylesheet" type="text/css">
		<script src="js/popup.js">
		</script>
	</head>
	<body>
	

		
		<div id="ajaxPostText" >
			<a href="#" >close</a>
		</div>
		<div id="popup"></div>
		<div id="postTosave" >
			<textarea id="post2" rows="12" cols="45"></textarea>
			<input type="button" class="a_submit_save" value="save" onclick="saveAPost(<%= request.getParameter("categoryid") %>)"  />
		</div>
		<div  >
		<a href="#" class="a_submit2" onclick="showPost()" >Add Post</a>
		</div>
		
		<div id='content' >
				<div id='row' >
					<div class='cell_centre_text'><b>Forum Text</b> </div>
					<div class='cell_centre'   ><b>Created by</b></div>
					<div class='cell_centre'   ><b> Date</b> </div>
					<div class='cell_centre'   ><b> No of comments</b></div>
					<div class='cell_centre'   ><b>Action</b></div>
				</div>
				<%--for(every forum in category){ --%>
				<%
					Iterator<PostList> it = postList.iterator();
					int i = 1;
					
					while(it.hasNext()){
						PostList tempPost = it.next();
						
				%>
				<div id='row'  >
					<div class='cell_text'  ><%= tempPost.getPostText() %>
					  <% if(tempPost.getPostText().length() > 98 ){ %> 
						<span class='spanr' onclick="getPost(event,<%= tempPost.getPostid() %>,<%= i %>)" id="read<%= i %>" >read more...</span>
					<% } else {%>
				 		<span class='spanc' onclick="getPost(event,<%= tempPost.getPostid() %>,<%= i %>)" id="read<%= i %>" ><br/>add Comment</span>
				 	<%  } %>
					 </div>
					<div class='cell_centre' ><%= tempPost.getPostCreatedBy() %></div>
					<div class='cell_centre' ><%= tempPost.getPostDate() %> </div>
					<div class='cell_centre' id="com<%= i %>" ><a href="CommentView?postid=<%= tempPost.getPostid() %>"><%= tempPost.getNoOfComments() %></a></div>
					<div class='cell_centre' ><a href="#" > Edit</a>|<a href="#"> Delete</a> </div>
				</div>
				<%  i++; } %>
				<%--}--%>
		</div>
		
	</body>

</html>