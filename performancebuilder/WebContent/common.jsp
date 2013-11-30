<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="sign_up">
<img src="images/close-button.png" id="close-button" onclick="back2()" />
<form id="login" method="post" action="/performancebuilder/ProfileCreator" >
      	  <table id="signup_table">
        	<tr>
          		<td colspan="2"><h3>Sign_up</h3></td>
        	</tr>
        	<tr>
          		<td>Name<img src="images/red_a.gif" id="red_a" /></td>
          		<td><input name="name" type="text" class="field" /></td>
        	</tr>
        	<tr>
          		<td>Email<img src="images/red_a.gif" id="red_a" /></td>
          		<td><input name="email" type="text" class="field" /></td>
        	</tr>
        	
        	<tr>
          		<td>Password<img src="images/red_a.gif" id="red_a" /></td>
          		<td><input name="pswd" type="password" class="field"  /></td>
        	</tr>
        	<tr>
          		<td>Confirm Password <img src="images/red_a.gif" id="red_a" /></td>
          		<td><input name="pswd" type="password" class="field"  /></td>
        	</tr>
        	<tr>
          		<td>Contact <img src="images/red_a.gif" id="red_a" /></td>
          		<td><input name="contactno" type="text" class="field"  /></td>
        	</tr>
        	<tr>
          		<td>Address <img src="images/red_a.gif" id="red_a" /></td>
          		<td><textarea class="field" name="address"></textarea></td>
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
	<form id="login" method="post" action="LoginController" >
      	  <table id="login_table">
        	<tr>
          		<td colspan="2"><h3>Login Panel </h3></td>
        	</tr>
        	
        	<tr>
          		<td>Email<img src="images/red_a.gif" id="red_a" /></td>
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
