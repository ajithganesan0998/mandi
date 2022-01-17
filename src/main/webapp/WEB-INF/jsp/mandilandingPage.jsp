<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mandi</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>


</head>
<core:set var="cityState" value="${cityState}" />

<body>
	<div class="container h-100">
	<form id="stateForm" method = "Post">
		<div class="bd-example"  style= "padding : 30 px">
				<div class="form-group">
					<label for="exampleInputEmail1">State</label>
						<select id = "state" name = "state" class="form-control"   onchange = "getDistrict(this.value)">
				<core:forEach items="${cityState}" var="iter">
					<option value="${iter}">${iter}</option>
				</core:forEach>

			</select>
				</div>
			<%-- 	<select id = "state" name = "state" class="custom-select" onchange = "getDistrict(this.value)">
				<core:forEach items="${cityState}" var="iter">
					<option value="${iter}">${iter}</option>
				</core:forEach>

			</select> --%>
		</div>
				<div class="bd-example" id="citySelect" style= "display:none ;padding : 30 px" >
			<select id = "city" name = "city" class="custom-select">
		

			</select>
		</div>
		
			<div class="d-flex justify-content-center mt-3 login_container">
				 	<button type="button" name="button" class="btn login_btn" onclick = "statesubmit()">Submit</button>
				   </div>
				   </form>
	</div>

</body>
<script>
function getDistrict(state)
{
alert("ji"+state);
var redirectUrl = "getDitictDtls";
$.ajax({
         			 type: "POST",
         		     url: redirectUrl,
         		     dataType: "text",
         		     headers: {'Content-Type': 'application/x-www-form-urlencoded'},
         		     data: { "state" : state},
         		   
         		     success:function(response)	{
         		    	 var cityList = JSON.parse(response);
         		    	console.log(cityList.length);
         		    	 
         		    	// cityList = response;
         		    	 alert(cityList.length);
         		    	 var $el = $("#city");
         		    	 $el.empty();
     					for (index = 0; index < cityList.length; index++) {
     					console.log(cityList[index]);
     					$el.append($("<option></option>").attr("value", cityList[index]).text(cityList[index]));
							}		
						document.getElementById("citySelect").style.display = "";	
         		    	 
         		     },
         		     error : function(error) {
         		    	 
         				 //alert("Due to technical error, cannot process your request at the moment. Please retry later.");
						 alert("Due to technical error, cannot process your request at the moment. Please retry later.");
         				// document.getElementById("citySelect").disabled = false;
         				}
         		});
         	}
         	
function statesubmit()
{
document.getElementById("stateForm").action = "mandiDashBoard";
document.getElementById("stateForm").submit();

}
</script>
</html>