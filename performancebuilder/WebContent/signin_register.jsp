<%@page import="model.Profile"%>
<div id="signin_register">

 	<% 
 		Profile pf = null;
 		if(session.getAttribute("profile")!= null){
 			 
 		pf  = (Profile)session.getAttribute("profile"); }
 	%>	
    <%	
    
    	if(pf == null )
    	{
    		
     %>
	<a href="#" onclick="show()"><em>Sign In / Sign Up</em></a>
		
 	<% } else {   %>
	 		
 	  <a href="#" >
 	  <em>
 	   <%= ((Profile)session.getAttribute("profile")).getName() %>		
 	  </em>
 	  </a>		
 	  <br />
 	  <a href="LogoutServlet" >logout</a>
 	
   <% } %>
</div>