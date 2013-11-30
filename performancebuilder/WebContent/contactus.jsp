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

<body >
<center>
<div id="page">
<div id="popup"></div>
<!-- 
<div id="sign_up">
<img src="images/close-button.png" id="close-button" onclick="back2()" />
<form id="login" method="post" action="/letstalk/Login" >
      	  <table id="signup_table">
        	<tr>
          		<td colspan="2"><h3>Sign_up</h3></td>
        	</tr>
        	<tr>
          		<td> Name <img src="images/red_a.gif" id="red_a" /></td>
          		<td><input name="uid" type="text" class="field" /></td>
        	</tr>
        	<tr>
          		<td> Email <img src="images/red_a.gif" id="red_a" /></td>
          		<td><input name="uid" type="text" class="field" /></td>
        	</tr>
        	
        	<tr>
          		<td>Password<img src="images/red_a.gif" id="red_a" /></td>
          		<td><input name="pswd" type="password" class="field"  /></td>
        	</tr>
        	<tr>
          		<td>Conform Password<img src="images/red_a.gif" id="red_a" /></td>
          		<td><input name="pswd" type="password" class="field"  /></td>
        	</tr>
        	<tr>
          		<td>Contact<img src="images/red_a.gif" id="red_a" /></td>
          		<td><input name="pswd" type="text" class="field"  /></td>
        	</tr>
        	<tr>
          		<td>Address<img src="images/red_a.gif" id="red_a" /></td>
          		<td><textarea class="field" name="aboutme"></textarea></td>
        	</tr>
        	<tr>
          		<td colspan="2"><input name="login" type="submit" class="submit" id="login" value="Submit :)" /></td>
        	</tr>
      	</table>
	</form>
	<p><a href="#" onclick="show_signin()">Sign_in</a></p>
</div>

	<div id="sign_in">
	<img src="images/close-button.png" id="close-button" onclick="back()" />
	<form id="login" method="post" action="" >
      	  <table id="login_table">
        	<tr>
          		<td colspan="2"><h3>Login Panel </h3></td>
        	</tr>
        	
        	<tr>
          		<td> Email <img src="images/red_a.gif" id="red_a" /></td>
          		<td><input name="uid" type="text" class="field" /></td>
        	</tr>
        	
        	<tr>
          		<td>Password<img src="images/red_a.gif" id="red_a" /></td>
          		<td><input name="pswd" type="password" class="field"  /></td>
        	</tr>
        	
        	<tr>
          		<td><input name="login" type="submit" class="submit" id="login" value="LogIn :)" /></td>
          		<td><a href="#" onclick="show_signup()">&nbsp;&nbsp;Sign UP</a>&nbsp;&nbsp;<a href="password.jsp"></a></td>
        	</tr>
      	</table>
	</form>
	
	</div>
-->
<jsp:include page="common.jsp" />
<jsp:include page="index_header.jsp" />
<% String str = request.getRequestURI();
	if(str.lastIndexOf("contactus.jsp") > 0  )
	{
%>
<script type="text/javascript" >
	var pht2 = document.getElementById("contact_active");
	pht2.style.backgroundColor = "#888";
	pht2.style.height="28px";
</script>
<% } %>
<div id="content">
	<div id="banner">
		<img src="images/contact.jpg"/>
	</div>
</div>
<div id="index_cnt">
	<div id="about_main">
<h2>Centre For Developmentof Advanced computing (C-DAC)</h2>
<h5>(A Scientific R&D Institution of Development of Information Technology.)</h5><br />
<p>Sector 7, Rain Tree Marg, <br /> Near Bharti Vidyapeeth,<br />Opp. Kharghar Railways Station<br />
CBD Belapur, Navi Mumbai-400614 <br />
Phone: 8080020085 <br />
Email: performancebuilder1@gmail.com
       
</p><br />
</div>
</div>
<jsp:include page="footer.jsp" />
</div>
</center>
</body>
</html>