 <!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<html>
<head>
<%
String contextPath = request.getContextPath();

%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- <link rel='stylesheet' href='css/fullcalendar.print.css' /> -->
<link rel='stylesheet' href='css/fullcalendar.css' />
<script src='js/fullcalendar.js'></script>
<script type="text/javascript">

$(document).ready(function() {

	$('#calendar').fullCalendar({
		
		
	    events: function(start, end, timezone, callback) {
	    	 $.ajaxSetup({
		         
		         beforeSend: function () {
		            $(".ajaxmodal").show();
		         },
		         complete: function () {
		             $(".ajaxmodal").hide();
		         }
		     });
	    	
	        $.ajax({
	        	
	            url: '<%=contextPath %>/ajaxCalendarAction.action',
	            dataType: 'xml',
	            data: {
	                // our hypothetical feed requires UNIX timestamps
	                start: start.unix(),
	                end: end.unix()
	            },
	            success: function(xml) {
	                var events = [];
	                
	                
	                $(xml).find('event').each(function() {
	                	
	                    events.push({
	                    	
	                        title: $(this).find('title').text(),
	                        start: $(this).find('start').text(),
	                        color: $(this).find('color').text(),
	                        url : $(this).find('url').text(),
	                    });
	                });
	                callback(events);
	            },
	            
	            
	        });
	    },
	    eventClick: function(event) {
	        if (event.url) {
	            window.open(event.url, "_blank");
	            return false;
	        }
	    }
	
	
	});
  
});


</script>

<style type="text/css">
#calendar {
		width: 90%;
		margin: 0 auto;
	}

.fc-event {
    font-size: 0.86em;
    
    font-weight: bold;
    line-height: 2.1;
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
  
  <div class="ajaxmodal" style="position:absolute;margin-left: 450px;">
        <div class="center">
         <img alt="" src="<%=contextPath %>/img/loader.gif" />
        </div>
        </div>
  <div id='calendar' ></div>
  </div>
  </div>
  
    
    

</div>


</body>
</html>