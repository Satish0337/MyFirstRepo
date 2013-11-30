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
<div id="page">
<jsp:include page="user_header.jsp"/>
<div id="admin_banner">
<div id="admin_cnt">
	<div id="profile_cnt_left">
		<h1>Edit Your Profile</h1>
			<img src="images/profile.jpg" />
		<p>Performance Builder is really new way of thinking which help you to provide
		   a facilities to evaluate your skill through exam. It provide a bunch of exam which help the
		   candidate to judge your skill.
		</p>
	</div>
	
<div id="detail_user">
<form action="UpdateProfileServlet" >
 				<h2>Your Detail</h2>
				<div class="form_field">
    				<label>Name:</label>
   					<input type="text" class="input" name="name"  <%if(pf!=null){%> value='<%=pf.getName() %>' readonly <%} %> />
				</div>
				<div class="form_field">
   					 <label>Email:</label>
   					 <input type="text" class="input" name="email" <%if(pf!=null){%> value='<%=pf.getEmail()%>' readonly <%} %>  />
				</div>
				<div class="form_field">
   					 <label>Contact:</label>
   					<input type="text" class="input" name="contactno"  <%if(pf!=null)%> value='<%=pf.getContactno() %>'/>
				</div>
				<div class="form_field">
   					 <label>Address:</label>
   					 <textarea class="input" name="address" ><%if(pf!=null)%> <%=pf.getAddress() %></textarea>
				</div>
	<input type="submit" name="Submit"  class="submit" value="Submit" />		
		</form></div>
</div>
</div>
<jsp:include page="footer.jsp"/>
</div>
</center>
</body>
</html>