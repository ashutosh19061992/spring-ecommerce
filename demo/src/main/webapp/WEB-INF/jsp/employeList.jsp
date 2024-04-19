<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.modal-dialog {
	overflow-y: initial !important
}

.modal-body {
	height: 80vh;
	overflow-y: auto;
}
</style>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/2.0.3/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/2.0.3/css/dataTables.dataTables.css">
<link rel="stylesheet" href="https://code.jquery.com/jquery-3.7.1.js">

<link rel="stylesheet"
	href="https://cdn.datatables.net/2.0.3/js/dataTables.js">

<title><c:out value="${tittle}" /></title>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"></script>
</head>

<body style="background-color: #F2EAFA">
	<div class='container-fluid'>
		<div class="d-flex justify-content-center">
			<h1>
				<b><u>Employee List</u></b>
			</h1>
		</div>
		<div class="row d-flex justify-content-center">
			<table id="employees" class="table table-bordered compact">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Email-Id</th>
						<th>Occupation</th>
						<th>Company</th>
						<th>DOB</th>
						<th>House Address</th>
						<th>City</th>
						<th>State</th>
						<th>Phone No</th>
						<th>Operations</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="emp" items="${empList}">
						<tr>
							<td><c:out value="${emp.id}"></c:out></td>
							<td><c:out value="${emp.name}"></c:out></td>
							<td><c:out value="${emp.emailId}"></c:out></td>
							<td><c:out value="${emp.occupation}"></c:out></td>
							<td><c:out value="${emp.company}"></c:out></td>
							<td><c:out value="${emp.dob}"></c:out></td>
							<td><c:out value="${emp.houseAddress}"></c:out></td>
							<td><c:out value="${emp.city}"></c:out></td>
							<td><c:out value="${emp.state}"></c:out></td>
							<td><c:out value="${emp.phoneNo}"></c:out></td>
							<td><a class="btn btn-primary btn-sm editBtn"
								data-toggle="modal"
								id=<c:out
                                                value="${emp.id}" />
								type="button">Edit</a> <a class="btn btn-danger btn-sm dltBtn"
								type="button"
								id=<c:out
                                                value="${emp.id}" />
								style="margin-left: 1px;">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="row justify-content-center">
			<div class="col-10">
				<a href="${pageContext.request.contextPath}/save"
					class="btn btn-primary">Add New Employee</a>
			</div>
		</div>
		<div class="modal bd-example-modal-lg editEmployee" tabindex="-1"
			role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"></h5>
						<button type="button" class="close modalDismalBtn"
							data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body editEmployeDeatils">
						<form id="editEmployeForm">
							<div class="form-group">
								<label for="id" class="col-form-label">Id:</label> <input
									type="text" class="form-control userId" id="id" readonly>
							</div>
							<div class="form-group">
								<label for="name" class="col-form-label">Name:</label> <input
									type="text" class="form-control" id="name">
							</div>
							<div class="form-group">
								<label for="email" class="col-form-label">Email:</label> <input
									type="text" class="form-control" id="emailId" readonly>
							</div>
							<div class="form-group">
								<label for="phone-no" class="col-form-label">Phone No</label> <input
									type="text" class="form-control" id="phoneNo">
							</div>
							<div class="form-group">
								<label for="occupation" class="col-form-label">Occupation</label>
								<input type="text" class="form-control" id="occupation">
							</div>
							<div class="form-group">
								<label for="company" class="col-form-label">Company</label> <input
									type="text" class="form-control" id="company">
							</div>
							<div class="form-group">
								<label for="dob" class="col-form-label">DOB</label> <input
									type="date" class="form-control" id="dob">
							</div>
							<div class="form-group">
								<label for="houseAddress" class="col-form-label">HouseAddress</label>
								<input type="text" class="form-control" id="houseAddress">
							</div>
							<div class="form-group">
								<label for="city" class="col-form-label">City</label> <input
									type="text" class="form-control" id="city">
							</div>
							<div class="form-group">
								<label for="state" class="col-form-label">State</label> <input
									type="text" class="form-control" id="state">
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<span class='updateMsg'></span>
						<button type="button" class="modalDismalBtn btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary updateEmpDetails">Update</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/2.0.3/js/dataTables.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/2.0.3/js/dataTables.bootstrap4.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#employees').DataTable({
				columnDefs : [ {
					targets : -1,
					className : 'dt-body-right'
				} ]
			});
		});
		$(".modalDismalBtn").click(function() {
			$(".editEmployee").hide();
		});

		$(".updateEmpDetails").click(function() {
			var paramsObj = {};
			$("#editEmployeForm input").each(function() {
				var idAttribute = $(this).attr("id");
				paramsObj[idAttribute] = $(this).val();
			});
			$.ajax({
				url : "/update/employe/",
				type : 'POST',
				dataType : "JSON",
				contentType : "application/json",
				data : JSON.stringify(paramsObj),
				beforeSend : function() {
					$(".updateMsg").html("<b>Upading Please Wait..!!</b>");
					$(".updateMsg").css({
						'color' : "green"
					});
				},
				success : function(data) {
					if (data["status"] === "Ok") {
						window.location.reload();
					}
				}
			});
		});

		$(".editBtn").click(function() {
			$.ajax({
				url : "/edit/employe/" + $(this).attr("id"),
				type : 'GET',
				beforeSend : function() {

				},
				success : function(data) {
					$(".editEmployee .modal-title").text(
							"Edit " + data["name"] + " details "
									+ " - " + data["id"]);
					$(".editEmployee").show();
					var dataKeys = Object.keys(data);
					$(".editEmployee input").each(function() {
						var idAttribute = $(this).attr("id");
						for (var i = 0; i < dataKeys.length; i++) {
							if (idAttribute === dataKeys[i]) {
								$(this).val(data[idAttribute]);
							}
						}
					});
				}
			});
		});
	
		$(".dltBtn").click(function() {
			var confirmRespone = confirm("Are you sure you want to delete "
					+ $(this).attr("id"));
			if (confirmRespone) {
				$.ajax({
					url : "/delete/employe/"
							+ $(this).attr("id"),
					type : 'DELETE',
					beforeSend : function() {

					},
					success : function(data) {
						if (data["status"] === "200") {
							alert("Employe details successfully..!!");
							window.location.reload();
						}
					}
				});
			}
		});
	</script>
</body>

</html>