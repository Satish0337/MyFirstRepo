<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Performance Builder: "Enhance Your Skills"</title>
<link href="css/style.css" rel="stylesheet" />

<script src="js/popup.js">
</script>

</head>

<body>
<center>
<div id="page">
<div id="popup"></div>
<jsp:include page="common.jsp" />

<%String error=request.getParameter("error");
if(error!=null)
{	
%>
<script type="text/javascript">
show();
show_signin();
</script>
<%}  %>
<jsp:include page="index_header.jsp" />

<% String str = request.getRequestURI();
	if(str.lastIndexOf("index.jsp") > 0  )
	{
%>
<script type="text/javascript" >
	var pht2 = document.getElementById("home_active");
	pht2.style.backgroundColor = "#888";
	pht2.style.height="28px";
</script>
<% } %>
<jsp:include page="index_content.jsp" />

</div>
<jsp:include page="footer.jsp" />
</center>
</body>
</html>