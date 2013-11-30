<%@page import="model.Profile"%>
<% Profile pf=(Profile) session.getAttribute("profile"); %>
<div id="admin_banner">
<div id="admin_cnt">
	<div id="profile_cnt_left">
		<h1>Edit Your Profile</h1>
			<img src="images/profile.jpg" height="100px" width="300px"/>
		<p>Performance Builder is really new way of thinking which help you to provide
		   a facilities to evaluate your skill through exam. It provide a bunch of exam which help the
		   candidate to judge your skill.
		</p>
	</div>
	
<div id="detail_user">
 				<h2>Your Detail</h2>
				<div class="form_field">
    				<label>Name:</label>
   					 <p class="detail_u"><%if(pf!=null)%> <%=pf.getName() %></p>
				</div>
				<div class="form_field">
   					 <label>Email:</label>
   					 <p class="detail_u"><%if(pf!=null)%> <%=pf.getEmail() %></p>
				</div>
				<div class="form_field">
   					 <label>Contact:</label>
   					 <p class="detail_u"><%if(pf!=null)%> <%=pf.getContactno() %></p>
				</div>
				<div class="form_field">
   					 <label>Address:</label>
   					 <p class="detail_u"><%if(pf!=null)%> <%=pf.getAddress() %></p>
				</div>
				<div class="form_field">
   					 <p class="detail_u"><a href="user_profile_update.jsp" class="a_submit"> Edit It</a>	</p>
				</div>
					
</div>
</div>
</div>