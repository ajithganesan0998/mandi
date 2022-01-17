<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<meta charset="ISO-8859-1">
<title>Mandi</title>
</head>
<body>
<core:set var="vegPriceList" value="${vegPriceList}" />
<script>
console.log("veg::"+"${vegPriceList}");
</script>
<div class="container">
	<div class="row">
	<div class="col-md-6">
						<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">
		</div>
		<div class="col-md"></div>
		<div class="col-md-11">
		
			<div class="table-responsive">
			  <table id="myTable" class="table table-hover table-striped center">
				<thead class="table-dark">
					<tr>
						<th class="align-middle" scope="col" style="text-align:center"><h6>State</h6></th>
					 	<th class="align-middle" scope="col" style="text-align:center"><h6>District</h6></th>
						<th class="align-middle" scope="col" style="text-align:center"><h6>Market</h6></th>
						<th class="align-middle" scope="col" style="text-align:center"><h6>commodity</h6></th>
						<th class="align-middle" scope="col" style="text-align:center"><h6>Price</h6></th>
					</tr>
				</thead>
				<tbody>		  			
		  			 <core:forEach var="itr" items="${vegPriceList}" >		  			
			    		<tr>
			    			<td class="align-middle" scope="col" style="text-align:left"><h6>${itr.state}</h6></td>
			    			<td class="align-middle" scope="col" style="text-align:center"><h6>${itr.district}</h6></td>
			    			<td class="align-middle" scope="col" style="text-align:center"><h6>${itr.market}</h6></td>
			    			<td class="align-middle" scope="col" style="text-align:center"> <h6>${itr.commodity}</h6></td>
							<td class="align-middle" scope="col" style="text-align:center"> <h6>${itr.modal_price}</h6></td>		    		
			    		</tr>
		    		</core:forEach>
		    	</tbody>
				</table>
				</div>
				</div>
				</div>
				</div>
</body>
<script>
function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}
</script>
<style>
* {
  box-sizing: border-box;
}

#myInput {
  /* background-image: url('/css/searchicon.png'); */
  background-position: 10px 10px;
  background-repeat: no-repeat;
  width: 100%;
  font-size: 16px;
  padding: 12px 20px 12px 40px;
  border: 1px solid #ddd;
  margin-bottom: 12px;
}

#myTable {
  border-collapse: collapse;
  width: 100%;
  border: 1px solid #ddd;
  font-size: 18px;
}

#myTable th, #myTable td {
  text-align: left;
  padding: 12px;
}

#myTable tr {
  border-bottom: 1px solid #ddd;
}

#myTable tr.header, #myTable tr:hover {
  background-color: #f1f1f1;
}
</style>
</html>

