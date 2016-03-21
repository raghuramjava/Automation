<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 <!DOCTYPE html>
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
    <script src="js/bootstrap/bootstrap.min.js"></script>
    
<style type="text/css">

label {
	font-weight: normal;
}


</style>

</head>
<body>
	
    <div class="container" style="width: 579px;margin-top: 30px;">
    
    
    
    <div class="panel panel-default" >
    <div class="panel-heading" style="background-color: #337ab7;color: #fff;text-align: center;">LOG IN</div>
    <div class="panel-body">
    <form role="form" method="post" action="loginAction">
  <div class="form-group">
     
     <s:if test="hasActionErrors()">
   <div class="errors">
      <s:actionerror/>
   </div>
     </s:if>
  
    <label for="email">User Name</label>
    <input type="text" class="form-control" id="userName" name="userName" required="required">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" id="password" name="password" required="required">
  </div>
  
  <button type="submit" class="btn btn-default">Submit</button>
   <div class="form-group" style="margin-top: 10px;">
    <label > <a href="forgotpassword">Forgot Password</a></label>
  </div>
</form>
    </div>
  </div>

    
    
    
   
   
  
  
   
  
</div>
 
</body>
</html>