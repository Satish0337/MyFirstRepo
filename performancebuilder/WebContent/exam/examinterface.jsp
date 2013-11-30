<%@page import="model.Profile"%>
<%@page import="exam.ExamBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Performance Builder| Exam Screen</title>
<style type="text/css">
div
{
float:left;
}
#navbuttons
{
width:1000px;

}
#head
{
width:850px;
margin-left:150px;
padding:3px;
}
#qnums
{
	margin-left:20px;
	margin:10px;
	width:210px;
	padding:5px;
	float:left;
}
#content
{
	padding:8px;
	float:left;
	margin:10px;
	
}
body {
margin:0; 
font-size:0.9em; 
line-height:20px; 
background:#fff; 
font-family: "Myriad Pro", "Trebuchet MS", Arial;
}

#timer
{
 float:right;
 margin:15px;
 padding:5px;
 background-color:black;
 border-radius:4px;
}

#time
{
 
}
</style>
</head>
<%ExamBean eb=(ExamBean)session.getAttribute("exam");
		Profile pf=(Profile) session.getAttribute("profile");	%>
<script type="text/javascript">
<%if(eb!=null)%>
m=20<%=eb.getDuration()%>;
s=0;
c0 = new Image(); 
c0.src = "images/c0.gif";
c1 = new Image(); 
c1.src = "images/c1.gif";
c2 = new Image(); 
c2.src = "images/c2.gif";
c3 = new Image(); 
c3.src = "images/c3.gif";
c4 = new Image(); 
c4.src = "images/c4.gif";
c5 = new Image(); 
c5.src = "images/c5.gif";
c6 = new Image();
c6.src = "images/c6.gif";
c7 = new Image(); 
c7.src = "images/c7.gif";
c8 = new Image();
c8.src = "images/c8.gif";
c9 = new Image(); 
c9.src = "images/c9.gif";
cb = new Image(); 
cb.src = "images/cb.gif";
col = new Image(); 
col.src = "images/colon.gif";

function clock()
{
	document.images.m2.src=eval("c"+(m%10)+".src");
	document.images.m1.src=eval("c"+Math.floor(m/10)+".src");
	if(m==0 && s==0)
	{
		alert("Your time is over...");
		stopClock();
	}
	if(s<=0)
	{
		s=60;
		m--;
		if(m<=9)
		{
			document.images.m1.src=eval("c"+Math.floor(m/10)+".src");
			document.images.m2.src=eval("c"+m+".src");
		}
		else if(m>9)
		{
			document.images.m2.src=eval("c"+(m%10)+".src");
			document.images.m1.src=eval("c"+Math.floor(m/10)+".src");
		}
		s--;
		if(s<=9)
		{
			document.images.s2.src=eval("c"+s+".src");
			document.images.s1.src=eval("c"+Math.floor(s/10)+".src");
		}
		else if(s>9)
		{
			document.images.s2.src=eval("c"+(s%10)+".src");
			document.images.s1.src=eval("c"+Math.floor(s/10)+".src");
		}
	}
	else
	{
		s--;
		if(s<=9)
		{
			document.images.s2.src=eval("c"+s+".src");
			document.images.s1.src=eval("c"+Math.floor(s/10)+".src");
		}
		else if(s>9)
		{
			document.images.s2.src=eval("c"+(s%10)+".src");
			document.images.s1.src=eval("c"+Math.floor(s/10)+".src");
		}
	}
}

function startClock()
{
	ref=window.setInterval("clock()",1000);
}
function stopClock()
{
clearInterval(ref);
}
</script>
<script type="text/javascript">
function getAjaxObject()
{
	var req=false;
	if(window.XMLHttpRequest)
		{
			req=new XMLHttpRequest();
		}
	else if(window.ActiveXObject)
		{
				req=new ActiveXObject("Microsoft.XMLHTTP");	
		}
	return req; 
}

function getPrevQuestion()
{
	var curr=<%=session.getAttribute("currentQuestion")%>;
	curr=curr-1;
	getQuestion(curr);
}

function getNextQuestion()
{
	var curr=<%=session.getAttribute("currentQuestion")%>;
	curr=curr+1;
	getQuestion(curr);
}

function getQuestion(i)
{
	req=getAjaxObject();
	req.open("GET","GetQuestionServlet?num="+i,true);
		req.onreadystatechange=function(){
		if(req.readyState==4 && req.status==200)
			{
				document.getElementById("content").innerHTML=req.responseText;
			}
		else if(req.status==404)
			{
			document.getElementById("content").innerHTML="No servlet found";
			}
	};
	req.send();	
}

function setAnswer(ans)
{
	req=getAjaxObject();
	req.open("GET","SetAnswerServlet?ans="+ans,true);
	req.onreadystatechange=function(){if(req.readyState==4 && req.status==200)
	{
		alert("Answer Set");
	}};
	req.send();	
}

function endExam()
{
	req=getAjaxObject();
	req.open("post","EndExamServlet",true);
	req.onreadystatechange=function(){
	if(req.readyState<=3 && req.status==200)
	{
		alert("Submitting Exam");
	}
	};
	req.send();	
}



</script>

<body onload="JavaScript:getQuestion(1), startClock()">
	
		<div id="timer">
			<span id="time">
				<img  src="images/c0.gif" width=20 name=m1>
				<img  src="images/c0.gif" width=20 name=m2>
				<img  height="27" src="images/colon.gif" width=20 name=col1>
				<img  src="images/c0.gif" width=20 name=s1>
				<img  src="images/c0.gif" width=20 name=s2>
			</span>
		</div>
	<div id="head" >
		<h2 style="float:left; padding:3px; margin:3px; width=:200px;">Exam ID:</h2>
		<span style="border-radius:5px; border:1px black solid; float:left; padding:4px; margin:4px; ">
	  	<%if(eb!=null){%> 
		<%=eb.getExamid()%>
		<%}
		else{		%>
		<i>No exam found in the session</i>
	<%}%>
		</span>
	</div>
	<div id="qnums">
		<%if(eb!=null){%>
		<%for(int i=1;i<=eb.getNquestions();i++){%>
			<input type="button" value="<%=i%>" style="width:35px; margin:1px;" onclick="JavaScript:getQuestion(<%=i%>)">
		<%		} 
			}
			else{%>
			<i>No exam found in the session</i>
			<%}%>
	</div>
	<div id="content">

	</div>
	<%if(eb!=null){%>
	<div id="navbuttons">
		<span style="padding:4px;padding-left:15px;padding-right:15px;margin-left:10px;border:2px solid black;"> 
		<input type="button" value="&lt--Back" onclick="JavaScript:getPrevQuestion()">
		<input type="button" valuje="Next--&gt" onclick="JavaScript:getNextQuestion()">
		<input type="button" value="End Exam" onclick="JavaScript:endExam()">
		</span>
	</div>
	<%}%>
</body>
</html>