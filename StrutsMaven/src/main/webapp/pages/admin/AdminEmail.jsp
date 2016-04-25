<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 <!DOCTYPE html>
<html>
<head>

<style type="text/css">

.row {

margin-bottom: 10px;

}




</style>

</head>
<body>
<div class="container">


   
<%
String contextPath = request.getContextPath();

%>

 <ul class="breadcrumb">

        <li><a href="<%=contextPath %>/admin/defaultaction">Admin</a></li>

      <li class="active">Email Configuration</li>

        

    </ul>

<div class="panel panel-default">
  <div class="panel-body">
  <form  id="emailConfigForm" name="emailConfigForm" method="post" action="saveEmailConfig">
  <div class="row">
        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label">Email Address :</label>
                    <input type="email" class="form-control input-sm" name="email"  id="email"  required="required" value='<s:property value="email"/>'/>
                 </div>
            </div>
        </div>
       </div>  
       
      <div class="row">
        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > Email Id :</label>
                    <input type="text"  class="form-control input-sm" name="emailId" id="emailId" required="required" value='<s:property value="emailId"/>' />
                  
                </div>
            </div>
        </div>
    </div>
       
       <div class="row">
        
        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > Email Passwod :</label>
                    <input type="password"  class="form-control input-sm" name="password" id="password" required="required" value='<s:property value="password"/>'/>
                  
                </div>
            </div>
        </div>
         </div>
         
        <div class="row">
        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > Email Host :</label>
                    <input type="text"  class="form-control input-sm" name="host" id="host" required="required" value='<s:property value="host"/>' />
                  
                </div>
            </div>
        </div>
    </div>
  
  
   <div class="row">
        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > Email Port :</label>
                    <input type="text"  class="form-control input-sm" name="port" id="port" required="required" value='<s:property value="port"/>' />
                  
                </div>
            </div>
        </div>
    </div>
  
   
  
  
  
 <button type="submit" class="btn btn-success" style="margin: 20px;">Save Config</button>
   
   
   </form>
  </div>
  
  </div>
</div>


 




</body>

</html>