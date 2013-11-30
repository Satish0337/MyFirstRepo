<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
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
<jsp:include page="admin_header.jsp"/>
<div id="admin_banner">
<div id="admin_cnt">
	<div id="profile_cnt_left">
		<h1>Exam creation.</h1>
			<img src="images/exam3.jpg" />
		<p>Performance Builder generates their revenue through Online Advertisement. It is a Business Model through we get revenue. It provides a facility to customer to publish their Ads which is very helpful for their company to known other.
		</p>
	</div>


<div id="detail_user2">
	<form action="" >
 				<h2>Your Detail</h2>
				<div class="form_field2">
    				<label>Subject:</label>
   					<select class="field2">
   						<option>Sub1</option>
   						<option>sub2</option>
   					</select>
				</div>
				<div class="form_field2">
   					 <label>Question:</label>
   					<textarea rows="7" cols="40"></textarea>
				</div>
				<div class="form_field">
   					 <label>Option1:</label>
   					<input type="text" class="input" name="contactno"  />
				</div>
				<div class="form_field">
   					 <label>Option2:</label>
   					 <input type="text" class="input" name="contactno"  />
				</div>
				<div class="form_field">
   					 <label>Option3:</label>
   					 <input type="text" class="input" name="contactno"  />
				</div>
				<div class="form_field">
   					 <label>Option4:</label>
   					 <input type="text" class="input" name="contactno"  />
				</div>
				<div class="form_field">
   					 <label>Answer:</label>
   					 <input type="text" class="input" name="contactno"  />
				</div>
	<input type="submit" name="Submit"  class="submit" value="Submit" />		
		</form>

		</div>
</div>
</div>
<jsp:include page="footer.jsp"/>
</center>
</body>
</html>