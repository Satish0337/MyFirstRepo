<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
	function check()
	{
		var xmlhttp;
		xmlhttp = new XMLHttpRequest();
		
		xmlhttp.onreadystatechange = function()
		{
			if(xmlhttp.readyState <=  3 )
			{
				var el = document.getElementById("in");
				
				el.value = "processing";
			}	
			
			else if(xmlhttp.readyState == 4 && xmlhttp.status == 200)
				{
				var el = document.getElementById("in");
				el.value = xmlhttp.responseText;
			}	
				
		}
		
		xmlhttp.open("GET","NewFile?id="+Math.random(),true);
		xmlhttp.send();
	
	}
</script>
<title>Insert title here</title>
</head>
<body>

	<input type="text" name="name" id="in" value="start" />
	<button onclick="check()">push</button>

</body>
</html>