<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- <link rel='stylesheet' href='css/fullcalendar.print.css' /> -->
<link rel='stylesheet' href='css/fullcalendar.css' />
<script src='js/fullcalendar.js'></script>
<script type="text/javascript">

$(document).ready(function() {

    // page is now ready, initialize the calendar...

    $('#calendar').fullCalendar({
    	
    	header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month,agendaWeek,agendaDay'
		},
		defaultView: 'month',
		editable: true,
    	
    })

});


</script>

<style type="text/css">
#calendar {
		width: 90%;
		margin: 0 auto;
	}



</style>

</head>

<body>
<div class="container">

     <!--  <ul class="breadcrumb">

        <li class="active">Home</li>

    </ul>-->
    <div class="panel panel-default">
  <div class="panel-body">
  <div id='calendar' ></div>
  </div>
  </div>
  
    
    

</div>


</body>
</html>