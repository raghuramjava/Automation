<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>AV BIKE SHOP</title>
    
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    
    
     <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
     <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
     <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    


</head>
<body>
	
<div class="container">

    <div class="well"><p style="text-align:center;"><b>AV BIKE SHOP</b></p></div>
    <ul class="nav nav-pills">
    <!--class="active"  -->
    <li  style="background-color:#33CCFF;width:22%;"><a href="#" >SEARCH</a></li>
    <li style="background-color:#33CCFF;width:23%;" <s:if test="tabIndex.equals('home')">class="active"</s:if> ><a href="#" >BUY</a></li>
    <li style="background-color:#33CCFF;width:24%;"><a href="#" >SELL</a></li>
    <li style="background-color:#33CCFF;;width:25%;"><a href="#" >REPORTS</a></li>
  </ul>
</div>
    
 
</body>
</html>