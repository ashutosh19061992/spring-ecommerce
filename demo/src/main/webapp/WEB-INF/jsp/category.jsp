<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
<title><c:out value="${tittle}" /></title>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"></script>
</head>


<script type="text/javascript" charset="utf-8">
	
</script>
<body style="background-color: #F2EAFA">
	<div class='container-fluid'>

		<div class="d-flex justify-content-center">
			<h1>
				<b><u>Add Category</u></b>
			</h1>
		</div>
		<c:if test="${hasError}">
			<div class="d-flex justify-content-center">
				<div class="alert alert-<c:out value="${messageType}"/>"
					role="alert">
					<c:if test="${not empty validMessages}">
						<c:forEach var="valdMsg" items="${validMessages}">
							<strong><li><c:out value="${valdMsg}" /></li></strong>
						</c:forEach>
					</c:if>
					<c:if test="${not empty message}">
						<strong><c:out value="${message}" /></strong>
					</c:if>
				</div>
			</div>
		</c:if>
		<c:if test="${!hasError}">
			<div class="d-flex justify-content-center">
				<div class="alert alert-<c:out value="${messageType}"/>"
					role="alert">
					<strong><c:out value="${message}" /></strong>
				</div>
			</div>
		</c:if>
		<div id="cat-details">
			<form method="POST" action="/category/saveCategory">
				<div
					class="h-100 d-flex align-items-center justify-content-center mb-3 row">
					<label class="col-sm-1 col-form-label">Name</label>
					<div class="col-sm-4">
						<input type="text" class="form-control name" name="name"
							value="${category != null ? category.name : '' }">
					</div>
				</div>
				<div
					class="h-100 d-flex align-items-center justify-content-center mb-3 row">
					<c:if test="${messageType.equals('danger')}">
						<button type="submit" class="btn btn-primary" id="categyDetails">Add
							New Category</button>

						<a
							href="${pageContext.request.contextPath}/category/save/category/save"
							class="btn btn-success" style="margin-left: 2px;">Refresh</a>
					</c:if>
					<c:if test="${messageType.equals('success')}">
						<a href="${pageContext.request.contextPath}/category/save"
							class="btn btn-primary">Go Back</a>
					</c:if>
					<c:if
						test="${!messageType.equals('success') && !messageType.equals('danger')}">
						<button type="submit" class="btn btn-primary" id="categyDetails">Save</button>
						<a href="${pageContext.request.contextPath}/category/list"
							class="btn btn-success" style="margin-left: 2px;">List</a>
					</c:if>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
