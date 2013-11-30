
<%@page import="java.util.Iterator"%>
<%@page import="model.CommentInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.PostCommInfo"%>
<%@page import="model.Profile"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>Performance Builder: Administration</title>
<link href="css/style.css" rel="stylesheet" >
<link href="menu_assets/styles.css" rel="stylesheet" type="text/css">
	<script src="js/popup.js" type="text/javascript" >
	</script>
</head>

<body>
	<%
	PostCommInfo pstCmtInfo = (PostCommInfo)request.getAttribute("comments");
	ArrayList<CommentInfo> comments = pstCmtInfo.getComments();
	Iterator<CommentInfo> it = comments.iterator();
	%>
	
<center>
<div id="page">
<%
model.Profile pf = (model.Profile)request.getSession().getAttribute("profile");
if(pf.getRole().trim().equals("user")){
%>
<jsp:include page="user_header.jsp"/>
<%}else{ %>
<jsp:include page="admin_header.jsp"/>
<%} %>
<div>&nbsp;</div><div>&nbsp;</div><div>&nbsp;</div><div>&nbsp;</div><div>&nbsp;</div>
		
		<div id="wrap">
  		<div id="right_side">
  			Advt Img.
  		</div>
  		<div id="left_side">
  			<h2 class="say_by">Author:</h2><p class="date_on">Date:&nbsp;&nbsp;<%= pstCmtInfo.getPostDate() %></p>
  			<p><%= pstCmtInfo.getPostData() %></p>
  		</div>
  		<div id="box3">
				<textarea rows="6" cols="60" id="myComment" name="comdata"></textarea>
				<p class="post_btn"><input type="button"  class="submit" value="submit" onclick="saveComment2(<%= pstCmtInfo.getPostId() %>)"></p>
		</div>	
		<div id="commentArea" >
  		<% while(it.hasNext()){ CommentInfo tempComm = it.next(); %>
  		<div id="com_side">
  		 <%= tempComm.getCommentText() %>
  		</div>
  		<% } %>
  		</div>
</div>	
</div>
<jsp:include page="footer.jsp"/>
</center>
</body>
</html>