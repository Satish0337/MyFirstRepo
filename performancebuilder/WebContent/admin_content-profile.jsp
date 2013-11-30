<%@page import="model.Profile"%>
<div id="admin_banner">
<div id="admin_cnt">
<% Profile pf=(Profile) session.getAttribute("profile"); %>
	<div id="profile_cnt_left">
		<h1>Edit Your Profile</h1>
			<img src="images/profile.jpg" />
		<p>Performance Builder is really new way of thinking which help you to provide
		   a facilities to evaluate your skill through exam. It provide a bunch of exam which help the
		   candidate to judge your skill.
		</p>
	</div>
	
<div id="detail_user">
<form action="UpdateProfileServlet" method="post" >

 				<h2>Your Detail</h2>
				<div class="form_field">
    				<label>Name:</label> 
   					<input type="text" class="input"  name="name"  <%if(pf!=null){%> value='<%=pf.getName() %>' readonly <%} %> />
				</div>
				<div class="form_field">
   					 <label>Email:</label>
   					 <input type="text" class="input" name="email" <%if(pf!=null){%> value='<%=pf.getEmail()%>' readonly <%} %> />
				</div>
				<div class="form_field">
   					 <label>Contact:</label>
   					<input type="text" class="input" name="contactno" <%if(pf!=null)%> value='<%=pf.getContactno() %>' />
				</div>
				<div class="form_field">
   					 <label>Address:</label>
   					 <textarea class="input" name="address" ><%if(pf!=null)%> <%=pf.getAddress() %></textarea>
				</div>
	<input type="submit" name="Submit"  class="submit" value="Submit" />		
		</form></div>
</div>
</div>