<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>



<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

</head>
<body>
	<div class="content-wrapper">
		<h1>Category Manager</h1>


		<!-- Button trigger modal -->
		<button type="button" class="btn btn-info" data-bs-toggle="modal"
			data-bs-target="#exampleModal" style="margin-bottom: 20px;">Add</button>

		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Add Category</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">

						<form action="" method="POST" class="form-horizontal" role="form">
							<div class="form-group">
								<div class="col-sm-10 col-sm-offset-2">
									<label for="name">Name: </label>
									<input type="text" class="form-control" id="name" placeholder="Input name">
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-10 col-sm-offset-2">
									<label for="code">Code: </label>
									<input type="text" class="form-control" id="code" placeholder="Input code">
								</div>
							</div>
						</form>


					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-success" id="btnAdd">Save</button>
					</div>
				</div>
			</div>
		</div>

		<table class="table table-bordered" style="background-color: #fff;">
			<thead>
				<tr>
					<th>Category ID</th>
					<th>Name</th>
					<th>Code</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="category" items="${categories}">
					<tr>
						<td>${category.id}</td>
						<td>${category.name}</td>
						<td>${category.code}</td>
						<td>
							<button type="button" class="btn btn-primary">Update</button>

							<button type="button" class="btn btn-danger">Delete</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script>
		//lay data
		nameElement = document.getElementById('name');
		codeElement = document.getElementById('code');

		buttonSave = document.getElementById('btnAdd');
		buttonSave.onclick = function(){
			nameValue = nameElement.value;
			codeValue = codeElement.value;
			
			//tao object
			objectJson = {};

			//them value bao object theo cap key: value
			objectJson['name'] = nameValue;
			objectJson['code'] = codeValue;

			//convert object json
			//console.log(JSON.stringify(objectJson));

			//call api
			document.ajax({
				url: 'http://localhost:8080/LapTrinhJavaWeb/api/categories',
				type: 'POST',
				contentType: 'application/json',
				dataType: 'json',
				data: JSON.stringify(objectJson),
				success: function(result){
					console.log(result);
					//window.location.href = "${NewURL}?type=edit&&id=" + result.id + "&message=UPDATE_SUCCESS";
				},
				error: function(error){
					console.log(error);
					//window.location.href = "${NewURL}?type=list&maxPageItem=1&page=1&message=ERROR_SYS"
				}
			});
		}

		
	</script>
</body>
</html>