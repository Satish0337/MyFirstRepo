<%@page import="database.CreateConnection"%>
<%@page import="database.SaveInfo"%>
<%@page import="database.GetInfo,model.Profile"%>

<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<% Profile pf=(Profile) session.getAttribute("profile");

	if(pf==null)
	{
		response.sendRedirect("index.jsp");
	}

%>
<%
	GetInfo.getCategoryList(request);
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Performance Builder: Administration</title>
<link href="css/style.css" rel="stylesheet" />
<link href="menu_assets/styles.css" rel="stylesheet" type="text/css" />
</head>
<body>
<center>
<div id="page">
<jsp:include page="user_header.jsp" />
<jsp:include page="forumlist.jsp" />

<%
		CreateConnection.destroyConnection((Connection)request.getAttribute("conn"),(ResultSet)request.getAttribute("list"),
				(Statement)request.getAttribute("stat"));
%>
</div>
<jsp:include page="footer.jsp"/>
</center>
</body>
</html>