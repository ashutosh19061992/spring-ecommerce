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
				<b><u>Category List</u></b>
			</h1>
		</div>
		<div class="d-flex justify-content-center alertMsg"></div>
		<div class="row d-flex justify-content-center">
			<table id="catgories" class="table table-bordered compact">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="cat" items="${categories}">
						<tr>
							<td><c:out value="${cat.id}"></c:out></td>
							<td><c:out value="${cat.name}"></c:out></td>
							<td><a class="btn btn-primary btn-sm editBtn"
								href="${pageContext.request.contextPath}/category/editCategory/<c:out value="${cat.id}" />">Edit</a>
								<a class="btn btn-danger btn-sm dltCat" type="button"
								id=<c:out value="${cat.id}" /> style="margin-left: 1px;">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
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
			$('#catgories').DataTable({
				columnDefs : [ {
					targets : -1,
					className : 'dt-body-right'
				} ]
			});
		});
		
		$(".dltCat").click(function() {
			var confirmRespone = confirm("Are you sure you want to delete "
					+ $(this).attr("id"));
			if (confirmRespone) {
				$.ajax({
					url : "/category/delete/"
							+ $(this).attr("id"),
					type : 'DELETE',
					beforeSend : function() {
						$(".alertMsg").html("");
					},
					success : function(data) {	
						console.log(data);
						if (data["status"] === "200") {
							$(".alertMsg").html("<div class='alert alert-success' role='alert'>"+
							"<strong>"+data.object.status+"</strong>"+
							"</div>");
							setTimeout(window.location.reload.bind(window.location), 2000);
						} else {
							$(".alertMsg").html(
							"<div class='alert alert-danger' role='alert'>"+
							"<strong>"+data.object.status+"</strong>"+
							"</div>");
							setTimeout(window.location.reload.bind(window.location), 2000);
						}
					}
				});
			}
		});
	</script>
</body>

</html>