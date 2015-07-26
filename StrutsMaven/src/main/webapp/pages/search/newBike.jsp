<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<!-- <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">  -->

<!--     <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen"> -->
<%--     <script type="text/javascript" src="jquery/jquery-1.8.3.min.js" charset="UTF-8"></script> --%>
<%-- <script type="text/javascript" src="js/bootstrap.min.js"></script>  --%>
<%--  <script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>  --%>

<style type="text/css">

.row {

margin-bottom: 20px;

}




</style>

</head>
<body>
<div class="container">


    <ul class="breadcrumb">

        <li><a href="#">Home</a></li>

      <li><a href="#">Searh</a></li>

        <li class="active">New Bike</li>

    </ul>


<div class="panel panel-default">
  <div class="panel-body">
  <form action="searchAction" id="searchForm" name="searchForm">
  <div class="row">
        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label"> Bike No </label>
                    <input type='text' class="form-control input-sm" />
                 </div>
            </div>
        </div>
        
        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > Bike Type </label>
                    <input type='text'  class="form-control input-sm" />
                  
                </div>
            </div>
        </div>
        
    </div>
  
   <div class="row">
        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label"> Model No </label>
                    <input type='text' class="form-control input-sm" />
                 </div>
            </div>
        </div>
        
        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label" > Chase No </label>
                    <input type='text'  class="form-control input-sm" />
                  
                </div>
            </div>
        </div>
        
    </div>
  
  
  
  
  
  
  <div class="row">
        <div class='col-sm-6'>
            <div class="form-group">
            <div class="col-xs-6">
            <label class="control-label"> Date : </label>
                <div class='input-group date' id='datetimepicker5'>
                    <input type='text' class="form-control input-sm" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
                 </div>
            </div>
        </div>
        
       
        <script type="text/javascript">
            $(function () {
                $('#datetimepicker5').datetimepicker({
                	showClose : true,
                    
                });
            });
            
           
        </script>
    </div>
    
   
  
  <div class="row"> 
    <div class="btn-group" style="margin: 20px;">
     <button type="button" class="btn-success" style="margin: 10px;"  data-toggle="button"><span><i class="fa fa-floppy-o"></i></span>SAVE BIKE</button>
  </div>
   </div>
   
   </form>
  </div>
  
  </div>
</div>

<script type="text/javascript">

function submit(){
	 document.getElementById("searchForm").submit();
}


</script>
 




</body>

</html>