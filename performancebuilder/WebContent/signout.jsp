<%@page import="model.Profile"%>
<% Profile pf=(Profile) session.getAttribute("profile"); %>
<div id="signin_register">
<%if(pf!=null){ %>Signed In As: <%=pf.getName() %><a href="LogoutServlet"><em>(Sign Out)</em></a>
<%} %>

</div>