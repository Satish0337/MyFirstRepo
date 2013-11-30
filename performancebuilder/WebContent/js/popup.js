function show()
			{
				
				var pht = document.getElementById("popup");
				pht.style.display = "block";
				pht.style.height = window.outerHeight + "px"; 
				pht.style.width = window.outerWidth + "px";
				var ph = document.getElementById("sign_in");
				ph.style.display = "block";
				var ph2 = document.getElementById("sign_up");
				
				ph.style.left = pht.style.width.substring(0,pht.style.width.indexOf("px")) / 2 - 200 + "px" ;
				ph.style.top = pht.style.height.substring(0,pht.style.height.indexOf("px")) / 2 - 200 + "px" ;
				ph2.style.left = pht.style.width.substring(0,pht.style.width.indexOf("px")) / 2 - 200 + "px" ;
				ph2.style.top = pht.style.height.substring(0,pht.style.height.indexOf("px")) / 2 - 200 + "px" ;
				document.getElementById("user_albums").style.display = "none";
				
				
			}
		function back()
			{
				var pht = document.getElementById("popup");
				var ph = document.getElementById("sign_in");
				var rpt = document.getElementById("nikReport");
				pht.style.display = "none";
				ph.style.display = "none";
				rpt.style.display = "none";
				document.getElementById("user_albums").style.display = "block";
			}
		
		function show_signup() {
			var pht2 = document.getElementById("sign_up");
			pht2.style.display  = "block"; 
			var ph = document.getElementById("sign_in");
			ph.style.display = "none";
			
		}
		
		function show_signin() {
			var pht2 = document.getElementById("sign_in");
			pht2.style.display  = "block"; 
			var ph = document.getElementById("sign_up");
			ph.style.display = "none";
			
		}
		function back2()
		{
			var pht = document.getElementById("popup");
			var ph = document.getElementById("sign_up");
			var rpt = document.getElementById("nikReport");
			pht.style.display = "none";
			ph.style.display = "none";
			rpt.style.display = "none";
			document.getElementById("user_albums").style.display = "block";
		}
		
		function hideMsg()
		{
			var pht = document.getElementById("msg");
			
			pht.style.display = "none";
		}
		
/*		function showMsg()
		{
			var pht = document.getElementById("msg");
			
			if(pht.innerHTML == "Error" )
				pht.style.backgroundColor = "#FF4500";
				
			pht.style.display = "block";
			setTimeout(hideMsg, 3000);
		} */
		
		function saveCategory()
		{
			
			var xmlhttp;
			xmlhttp = new XMLHttpRequest();
			var el = document.getElementById("msg");
			
			xmlhttp.onreadystatechange = function()
			{
				if(xmlhttp.readyState <= 3 )
					{
						el.style.backgroundColor = "yellow";
						el.innerHTML = "processing";
						el.style.display = "block";
					}
				else if(xmlhttp.readyState == 4 && xmlhttp.status == 200 )
					{
					
					var str = xmlhttp.responseText;
					
					if(str.indexOf("saved")!= -1)
						el.style.backgroundColor = "#98FB98";
					else if(str.indexOf("duplicate")  != -1 )
						el.style.backgroundColor = "#FFE4B5";
					else if(str.indexOf("error") != -1 )
						el.style.backgroundColor = "#FF0000";
					
							el.innerHTML = str;
							el.style.display = "block";
							setTimeout(hideMsg, 3000);		
					}
			};
			
			xmlhttp.open("GET","AddCategory?catname="+document.getElementById("catname").value,true);
			xmlhttp.send();
			
		}
		
		function getPost(event,val,curr)
		{
			
			var xmlhttp;
			xmlhttp = new XMLHttpRequest();
			var el = document.getElementById("ajaxPostText");
			
			xmlhttp.onreadystatechange = function()
			{
				if(xmlhttp.readyState <= 3 )
					{
						
					}
				else if(xmlhttp.readyState == 4 && xmlhttp.status == 200 )
					{
					
					var str = xmlhttp.responseText;
					el.innerHTML = str+"<form ><textarea type='text'id='commajax' ></textarea><input type='button' class='submit' value='save' onclick='saveComment("+val+","+ curr + ")'  />" +
					"<input type='button' class='submit' value='cancel' onclick='postFadeAway()' /></form>";
							var x,y;
							x =  event.clientX + window.scrollX;
							y = event.clientY + window.scrollY;
							x -= 2; 
							y -= 2;
							y = y+15;
							el.style.left = x + "px";
							el.style.top = y + "px";
							//alert(el.style.left);
							//alert("client"+el.clientWidth);
							//alert(window.innerWidth);
							
							
							var totalWidth = parseInt(el.style.left.substring(0,el.style.left.indexOf("px"))) + parseInt(el.clientWidth);
							//alert(totalWidth+" total width");
							//alert(window.innerWidth+" inner width");
							
							
							if((totalWidth+100) >= window.innerWidth)
							{
								
								
								//alert(totalWidth+" total width");
								 //el.style.width = window.innerWidth - 300; + "px";
								
								 el.style.width = window.innerWidth - 200 + "px";
								 //alert("width "+el.style.width);
								 
							}
							else
								{
									/*alert("inner width "+el.clientWidth); 
									var leftCord = el.style.left.substring(0,el.style.left.indexOf("px"));
									//alert(leftCord+" leftcord");
									var totalWidth2 = parseInt(leftCord )+ parseInt(el.clientWidth);
									alert("tw2 "+totalWidth2);
									el.style.width = totalWidth2 + "px";  */
									el.style.width = window.innerWidth - 700 + "px";
							
								}
								el.style.visibility = "visible";
								
					}
			};
			
			xmlhttp.open("GET","AjaxPost?postid="+val,true);
			xmlhttp.send(); 
		}
		
		function saveComment(val,curr)
		{
			var xmlhttp;
			xmlhttp = new XMLHttpRequest();
			var str2 = document.getElementById("commajax").value;
			var el = document.getElementById("com"+curr);
			
			xmlhttp.onreadystatechange = function()
			{
				if(xmlhttp.readyState <= 3 )
					{
						el.innerHTML = "<img src='/performancebuilder/images/ajax-loader.gif' />";
					}
				else if(xmlhttp.readyState == 4 && xmlhttp.status == 200 )
					{
						//alert(xmlhttp.responseText);
						el.innerHTML = xmlhttp.responseText;
						el.innerHTML = "<a href='CommentView?postid="+val+"'>"+xmlhttp.responseText+"</a>";
						postFadeAway();
						
					}
			};
			
			xmlhttp.open("POST","SaveComment",true);
			xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			xmlhttp.send("postid="+val+"&comm="+str2);
			
		}
		
		function postFadeAway()
		{
			el = document.getElementById('ajaxPostText');
			
			el.style.visibility = "hidden";
		}
		
		function saveComment2(val)
		{
			
			var xmlhttp;
			xmlhttp = new XMLHttpRequest();
			str2 = document.getElementById("myComment").value;
			
			xmlhttp.onreadystatechange = function()
			{
				if(xmlhttp.readyState <= 3 )
					{
						
					}
				else if(xmlhttp.readyState == 4 && xmlhttp.status == 200 )
					{
						var el = document.getElementById("commentArea");
						var newEl = document.createElement("div");
						newEl.setAttribute("id", "com_side");
						var textNode = document.createTextNode(str2);
						newEl.appendChild(textNode);
						el.insertBefore(newEl,el.childNodes[0]);
						document.getElementById("myComment").value = "";
						
						
					}
			};
			
			xmlhttp.open("POST","SaveComment",true);
			xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			xmlhttp.send("postid="+val+"&comm="+str2);
		}
	
	function showPost()
	{
		var pht = document.getElementById("popup");
		pht.style.display = "block";
		pht.style.height = window.outerHeight + "px"; 
		pht.style.width = window.outerWidth + "px";
		var ph = document.getElementById("postTosave");
		ph.style.display = "block";
		ph.style.left = pht.style.width.substring(0,pht.style.width.indexOf("px")) / 2 - 200 + "px" ;
		ph.style.top = pht.style.height.substring(0,pht.style.height.indexOf("px")) / 2 - 200 + "px" ;
	}
	
	function closePost()
	{
		var pht = document.getElementById("popup");
		var ph = document.getElementById("postTosave");
		pht.style.display = "none";
		ph.style.display = "none";
		
	}
	function saveAPost(val)
	{
		var xmlhttp;
		xmlhttp = new XMLHttpRequest();
		str = document.getElementById('post2').value;
		
		xmlhttp.onreadystatechange = function()
		{
			if(xmlhttp.readyState <= 3 )
				{
					
				}
			else if(xmlhttp.readyState == 4 && xmlhttp.status == 200 )
				{
					el = document.getElementById("content");
					newEl = document.createElement("div");
					newEl.setAttribute("id", "row");
					newEl.innerHTML = xmlhttp.responseText;
					el.insertBefore(newEl,el.childNodes[2]);
					//el.appendChild(newEl);
					closePost();
				}
		};
		
		xmlhttp.open("POST","SavePost",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("catid="+val+"&post="+str);
		
	}