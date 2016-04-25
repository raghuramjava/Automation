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
<s:if test="hasActionMessages()">
<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      
      <div class="modal-body">
        <div class="alert alert-success">
      <strong> <s:actionmessage escape="true"/></strong>
       </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
<script type="text/javascript">
$(document).ready(function() {
	$('#myModal').modal('show'); 
});
</script>

</s:if>
<s:else>
<s:if test="hasActionErrors()">
<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      
      <div class="modal-body">
        <div class="alert alert-danger">
      <strong> <s:actionerror/></strong>
       </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
<script type="text/javascript">
$(document).ready(function() {
	$('#myModal').modal('show'); 
});
</script>

</s:if>


</s:else>

   
<%
String contextPath = request.getContextPath();

%>

 <ul class="breadcrumb">

        <li><a href="<%=contextPath %>/admin/defaultaction">Admin</a></li>

      <li class="active">Users List</li>

        

    </ul>

<div class="panel panel-default">
  <div class="panel-body">
  
  <div class="row" style="line-height: 30px;">
    <div class="col-sm-2" style="background-color:lavenderblush;font-weight: bold;">Select</div>
    <div class="col-sm-2" style="background-color:lavender;font-weight: bold;">User Id</div>
    <div class="col-sm-2" style="background-color:lavenderblush;font-weight: bold;">Email</div>
    <div class="col-sm-2" style="background-color:lavender;font-weight: bold;">First Name </div>
    <div class="col-sm-2" style="background-color:lavender;font-weight: bold;">Last Name</div>
    <div class="col-sm-2" style="background-color:lavender;font-weight: bold;">Admin User</div>
    
    
  </div>
  
   
  <s:iterator value="userList" var="Users"> <!-- here myList contains the list of objects -->
 
  <div class="row" style="line-height: 30px;">
    <div class="col-sm-2" style="background-color:lavenderblush;"><input type="checkbox" name="userGroup" id="userGroup" value='<s:property value="%{#Users.userId}"/>'></div>
    <div class="col-sm-2" style="background-color:lavender;"><a href="#"><s:property value="%{#Users.loginId}" /></a></div>
    <div class="col-sm-2" style="background-color:lavenderblush;"><s:property value="%{#Users.email}" /></div>
    <div class="col-sm-2" style="background-color:lavender;"><s:property value="%{#Users.fname}" /> </div>
    <div class="col-sm-2" style="background-color:lavender;"><s:property value="%{#Users.lname}" /></div>
    <div class="col-sm-2" style="background-color:lavender;"><s:property value="%{#Users.adminflag}" /></div>
    
    
  </div>
  
  </s:iterator>
  <form action="deleteUserAction" id="target" method="post">
  
  <input type="hidden" name="deleteUsers" id="deleteUsers">
  
  </form>
   <s:if test='%{#session.admin.equals("true")}'> 
  <button type="button" id="deleteButton" class="btn btn-danger" >Delete User</button>
  
   <a href="<%=contextPath %>/admin/newUserAction" class="btn btn-success" role="button">Add New User</a>
   </s:if>
  <script type="text/javascript">
  
  $(document).ready(function() {
      $("#deleteButton").click(function(){
          var favorite = [];
          
          $.each($("input[name='userGroup']:checked"), function(){            
              favorite.push($(this).val());
          });
          $("#deleteUsers").val(favorite.join(","));
          if(favorite.length >0){
        	  $( "#target" ).submit();
          }else{
        	  alert("Please select users")
          }
      });
  });
  
  </script>
  
  </div>
  
  </div>
</div>


 




</body>

</html>