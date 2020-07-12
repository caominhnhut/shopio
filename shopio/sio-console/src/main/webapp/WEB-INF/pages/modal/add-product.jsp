<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div id="addProductModal" title="Add New Product">
	<form:form action="save" modelAttribute="product" method="POST" acceptCharset="UTF-8">
		<div class="row">
			<div class="col-md-6">
				<div class="image">
					<img id="imgProduct"
						src="<c:url value="/asset/pictures-icon.png" />" />
				</div>
				<div>
					<input id="btnChooseFile" type="file">
				</div>
			</div>
			<div class="col-md-6">
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
					<select id="categories">
						<option value="1">Wooden Toy</option>
						<option value="2">Plastic Toy</option>
					</select>
				</div>
				<input type="submit" class="btn btn-primary" value="Create">
			</div>
			<div class="alert alert-danger">There is a error</div>
		</div>
	</form:form>
</div>