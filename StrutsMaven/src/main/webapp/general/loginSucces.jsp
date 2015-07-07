<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen"> 

    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <script type="text/javascript" src="jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script> 
 <script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script> 


</head>
<body>
<div class="container">
<div class="panel panel-default">
  <div class="panel-body">
  
  
    <form action="" >
        <fieldset>
            
            
			<div class="control-group">
                <label class="control-label">Start Date : </label>
                <div class="controls input-append date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input1" data-link-format="yyyy-mm-dd">
                    <input size="16" type="text" value="" readonly>
                    <span class="add-on"><i class="icon-remove"></i></span>
					<span class="add-on"><i class="icon-th"></i></span>
                </div>
				<input type="hidden" id="dtp_input1" value="" /><br/>
            </div>
            <div class="control-group">
                <label class="control-label">End Date : </label>
                <div class="controls input-append date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                    <input size="16" type="text" value="" readonly>
                    <span class="add-on"><i class="icon-remove"></i></span>
					<span class="add-on"><i class="icon-th"></i></span>
                </div>
				<input type="hidden" id="dtp_input2" value="" /><br/>
            </div>
			<script type="text/javascript">
$('.form_date').datetimepicker({
   
    weekStart: 1,
    todayBtn:  1,
	autoclose: 1,
	todayHighlight: 1,
	startView: 2,
	minView: 2,
	forceParse: 0
});

$('.form_date').datetimepicker({
   
    weekStart: 1,
    todayBtn:  1,
	autoclose: 1,
	todayHighlight: 1,
	startView: 2,
	minView: 2,
	forceParse: 0
});</script>
        </fieldset>
    </form>

  
  </div>
</div>
</div>

 




</body>

</html>