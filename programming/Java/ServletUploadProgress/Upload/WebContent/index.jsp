<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link type="text/css" href="css/jquery-ui-1.8.5.css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="js/jquery-ui.js"></script>
	<script type="text/javascript" src="js/jquery.form.js"></script>
	<script>
	 	$(document).ready(function() {
		    $("#progressbar").progressbar({ value: 0 });

		    $('#form1').ajaxForm(function() { 
	             //$("#progressbar").fadeOut();
	         }); 
		    
		  });

		  function upload() {
			  var interval = setInterval(function(){
				  $.ajax({ 
					  	url: "ProgressServlet", 
					  	data:"", 
					  	success: function(response){
				  			$("#progressbar").progressbar({ value: parseInt(response) });
					  		if(response==100) {
					  			alert("Cancel");
					  			clearInterval(interval);
					  		}
				      }});
				 }, 1000);
			  return true;
		  }

	</script>
</head>
<body>
	<form name="form1" id="form1" action="UploadServlet" method="post" enctype="multipart/form-data">
		<input type="hidden" name="hiddenfield1" value="ok">
		Files to upload:
		<br/>
		<input type="file" size="50" name="file">
		<br/>
		<input type="submit" value="Upload" onclick="return upload();">
	</form>
	
	<div id="progressbar"></div>
	
</body>
</html>