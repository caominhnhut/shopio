<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="createOrUpdateProduct" title="Add New Product">
	<c:url var="productSaveOrUpdateUrl" value="/product/save-or-update" />
	
	<form:form action="${productSaveOrUpdateUrl}" commandName="product" method="POST" enctype="multipart/form-data">
		<div class="row">
			<div class="col-md-4">
				<div class="image">
					<img id="imgProduct" src="<c:url value="/asset/pictures-icon.png" />" />
				</div>
				<div>
					<input id="btnChooseFile" type="file" name="images" multiple="multiple">
				</div>
			</div>
			<div class="col-md-8">
				<div>
					<form:hidden path="id" />
				</div>
				<div>
					<form:input path="code" type="text" id="txtProductId"
						placeholder="Product ID" />
				</div>
				<div>
					<form:input path="name" type="text" id="txtProductName"
						placeholder="Product Name" />
				</div>
				<div>
					<form:input path="costPrice" type="number" id="txtCostPrice"
						placeholder="Cost Price" min="0" />
				</div>
				<div>
					<form:input path="sellingPrice" type="number" id="txtSellingPrice"
						placeholder="Selling Price" min="0" />
				</div>
				<div>
					<form:select path="category" id="category">
						<c:forEach var="category" items="${categories}">							
							<option value="${category.id}">${category.name}</option>
						</c:forEach>
					</form:select>
				</div>
				<input type="submit" class="btn btn-primary" value="Create">
				<c:if test="${not empty errorMessage}">
					<div class="alert alert-danger">${errorMessage}</div>
				</c:if>
			</div>
		</div>
	</form:form>
</div>