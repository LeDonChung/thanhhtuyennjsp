<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html lang="en">

		<head>

			<!-- Required meta tags -->
			<meta charset="utf-8">
			<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

		</head>

		<body>
			<div class="content-wrapper">
				<h1>Category Manager</h1>
				<!-- Button trigger modal -->
				<button type="button" class="btn btn-info" data-bs-toggle="modal" data-bs-target="#addModal"
					style="margin-bottom: 20px;">Add</button>

				<!-- Modal -->
				<div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Add Category</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">

								<form id="formSubmit" class="form-horizontal">
									<div class="form-group">
										<div class="col-sm-10 col-sm-offset-2">
											<label for="name">Name: </label> 
											<input type="text" class="form-control"
												id="name" placeholder="Input name">
										</div>
									</div>

									<div class="form-group">
										<div class="col-sm-10 col-sm-offset-2">
											<label for="code">Code: </label> 
											<input type="text" class="form-control"
												id="code" placeholder="Input code">
										</div>
									</div>
									
									<div class="modal-footer">
										<button type="submit" class="btn btn-success" id="btnAdd">Save</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>

				<table class="table table-bordered" style="background-color: #fff;">
					<c:if test="${ responseMessage != null }">
						<div class="alert alert-info text-center" role="alert">
							${ responseMessage }
						</div>
					</c:if>
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Code</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="category" items="${ categories }">
							<tr>
								<td>${ category.categoryId }</td>
								<td>${ category.name }</td>
								<td>${ category.code }</td>
								<td>

									<button type="button" class="btn btn-primary">Update</button>
									<c:if test="${ category.is_activated == true &&  category.is_deleted == false }">
										<button onclick="onDelete(${category.categoryId})" type="button"
											class="btn btn-danger">Delete</button>
									</c:if>
									<c:if test="${ category.is_activated == false &&  category.is_deleted == true }">
										<button onclick="onActive(${category.categoryId})" type="button"
											class="btn btn-primary">Active</button>
									</c:if>
								</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
			<script>
				function onDelete(id) {
					let data = {
						categoryId: id
					}
					$.ajax({
						url: 'http://localhost:8080/LapTrinhJavaWeb/api/categories?disable',
						type: 'PUT',
						contentType: 'application/json',
						dataType: 'json',
						data: JSON.stringify(data),
						success: function (result) { 
							window.location.href = 'http://localhost:8080/LapTrinhJavaWeb/admin/categories?message=DELETE_CATEGORY_SUCCESS';
						},
						error: function (error) {
							window.location.href = 'http://localhost:8080/LapTrinhJavaWeb/admin/categories?message=SOMETHING_WENT_WRONG'
						}
					});
				}
				function onActive(id) {
					let data = {
						categoryId: id
					}
					$.ajax({
						url: 'http://localhost:8080/LapTrinhJavaWeb/api/categories?enable',
						type: 'PUT',
						contentType: 'application/json',
						dataType: 'json',
						data: JSON.stringify(data),
						success: function (result) {
							window.location.href = 'http://localhost:8080/LapTrinhJavaWeb/admin/categories?message=ENABLE_CATEGORY_SUCCESS'
						},
						error: function (error) {
							window.location.href = 'http://localhost:8080/LapTrinhJavaWeb/admin/categories?message=SOMETHING_WENT_WRONG'
						}
					});
				}
				$('#formSubmit').submit(function(e) {
					e.preventDefault(); 
					// Khởi tạo object 
					let dataJson = {};

					// phân giải form ra mảng object
					let formData = $('#formSubmit').serializeArray();
					console.log(formData);

					// duyệt từng phẩn tử trong mảng truyền {key, value} vào dataJson object
					formData.forEach(function(data, index) {
						dataJson[data.name] = data.value;
					}); 
					console.log(dataJson);
					
					// let idElement = $('#id'); 
					// if(idElement.length == 0) {
					// 	addCategory(dataJson);
					// } else {
					// 	updateCategory(idElement.val(), dataJson);
					// }
				});
			</script>
		</body>

		</html>