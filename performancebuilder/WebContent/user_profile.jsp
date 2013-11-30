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
<jsp:include page="user_header.jsp"/>
<jsp:include page="user_profile_content.jsp"/>

<jsp:include page="footer.jsp"/>
</div>
<%} else 
	response.sendRedirect("index.jsp");%>
</center>
</body>
</html>