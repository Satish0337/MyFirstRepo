<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<% ResultSet rs = (ResultSet)request.getAttribute("list"); %>
<div id="admin_banner">
<div id="admin_cnt">
	<div id="profile_cnt_left">
		<h1>Forum Creation</h1>
			<img src="images/forum.jpg" />
		<p>Performance Builder is really new way of thinking which help you to provide
		   a facilities to evaluate your skill through exam. It provide a bunch of exam which help the
		   candidate to judge your skill.
		</p>
	</div>
<div>&nbsp;</div>

<div id="detail_user">
<h2>Categories List.</h2>
<p>Here are the list.</p>
<table border="1" id="cat_list">
	
	  <tr>
		<td width="119"><b>Category Name</b></td>
		<!-- <td width="168"><b>Action</b></td> -->
	  </tr>
	<%  while(rs.next()) { %>
	<tr>
		<td width="119"><a href="/performancebuilder/ForumList?categoryid=<%= rs.getString(1)%>"><%= rs.getString(2)%></a>&nbsp;</td>
		<!-- <td width="168"><a href="#">Disable</a> </td> -->
	</tr>
	<% } %> 
	</table>
		</div>
</div>
</div>