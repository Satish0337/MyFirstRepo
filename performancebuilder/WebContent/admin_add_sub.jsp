<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@page import="model.Profile"%>
<% Profile pf=(Profile) session.getAttribute("profile"); %>


<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Performance Builder: Administration</title>
<link href="css/style.css" rel="stylesheet" >
<link href="menu_assets/styles.css" rel="stylesheet" type="text/css">
</head>

<body>
<center>
<%if(pf!=null){ %>
<div id="page">
<jsp:include page="admin_header.jsp"/>
<div id="admin_banner">
<div id="admin_cnt">
	<div id="profile_cnt_left">
		<h1>Exam creation.</h1>
			<img src="images/exam3.jpg" />
		<p>Performance Builder helps candidates improve and test their technical skills by providing them with various  exams.
		We provide various subjects as the field in the industry.
		</p>
	</div>
<div>&nbsp;</div>
<div>&nbsp;</div>
<div id="detail_user">
	<form  action="/AddSubjectServlet"  method="POST">
		<h2>Create Exam.</h2>
 
	<div class="form_field"><br/>
   	 	<label>Subject:</label>
    	<input type="text" class="input" name="subjectName"  />
    	<input type="submit" name="Submit"  class="submit2" value="Add" onclick=""/>
</div>
</form>	

<br/>
<table border="1" id="cat_list">
	  <tr>
		<td width="119"><b>Subject Name</b></td>
		<td width="168"><b>Action</b></td>
	  </tr>

	<tr>
		<td width="119">&nbsp;</td>
		<td width="168"><a href="#">Edit</a> /<a href="#">Delete</a> </td>
	</tr>

	</table>
		</div>
</div>
</div>
<jsp:include page="footer.jsp"/>
<%} else 
	response.sendRedirect("index.jsp");%>
</center>
</body>
</html>