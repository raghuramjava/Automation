<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<!-- <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">  -->

<!--     <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen"> -->
<%--     <script type="text/javascript" src="jquery/jquery-1.8.3.min.js" charset="UTF-8"></script> --%>
<%-- <script type="text/javascript" src="js/bootstrap.min.js"></script>  --%>
<%--  <script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>  --%>


</head>
<body>
<div class="container">
<div class="panel panel-default">
  <div class="panel-body">
  
  
     <div class="row">
        <div class='col-sm-6'>
            <div class="form-group">
                <div class='input-group date' id='datetimepicker1'>
                    <input type='text' class="form-control" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
        </div>
        
         <div class='col-sm-6'>
            
            <div class="form-group">
        <label class="col-xs-3 control-label">Date</label>
        <div class="col-xs-5 date">
            <div class="input-group input-append date" id="datePicker">
                <input type="text" class="form-control" name="date" />
                <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
            </div>
        </div>
    </div> 
            
            
            
        </div>
        <script type="text/javascript">
            $(function () {
                $('#datetimepicker1').datetimepicker({
                	format: 'dd/mm/yyyy'
                });
                
                
                $(document).ready(function() {
                    $('#datePicker')
                        .datepicker({
                            format: 'mm/dd/yyyy'
                        })
                        .on('changeDate', function(e) {
                            // Revalidate the date field
                           // $('#eventForm').formValidation('revalidateField', 'date');
                        });
                
            });
            
            
        </script>
    </div>
  
  </div>
</div>
</div>

 




</body>

</html>