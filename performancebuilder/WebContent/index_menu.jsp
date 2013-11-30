	<!-- Start Menu -->
	<div id="menu" class="transparent">
		<ul>
			<li><a href="index.jsp" id="home_active">Home</a></li>
			<% if(session.getAttribute("isAuthenticate") != null) { %>
				<li><a href="admin_categories.jsp" id="aboutus_active">Forum</a></li>
		 	<% } %>		
			<li><a href="aboutus.jsp" id="aboutus_active">About Us</a></li>
            <li><a href="feedback.jsp" id="feedback_active">Feedback</a></li>
            <li><a href="contactus.jsp" id="contact_active" >Contact Us</a></li>
        </ul>
		<!-- Start Search -->
		<!--<div id="search">
			<form method="post" action="user_search.jsp">
				<fieldset>
					<input type="text" name="s" id="search-text" size="15" />
					<input type="submit" id="search-submit" value="Search" />
				</fieldset>
			</form>
		</div>
		<!-- End Search -->
	</div>
	<!-- End Menu -->