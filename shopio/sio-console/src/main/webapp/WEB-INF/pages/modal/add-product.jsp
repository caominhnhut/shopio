<div id="addProductModal" title="Add New Product">
	<div class="row">
		<div class="col-md-6">
			<div class="image"><img id="imgProduct" src="<c:url value="/asset/pictures-icon.png" />" /></div>
			<div><input id="btnChooseFile" type="file"></div>
		</div>
		<div class="col-md-6">
			<div>
				<input type="text" id="txtProductId" placeholder="Product ID">
			</div>
			<div>
				<input type="text" id="txtProductName" placeholder="Product Name">
			</div>
			<div>
				<input type="number" id="txtCostPrice" placeholder="Cost Price" min="0">
			</div>
			<div>
				<input type="number" id="txtSellingPrice" placeholder="Selling Price" min="0">
			</div>
			<div>
				<select id="categories">
					<option value="1">Wooden Toy</option>
					<option value="2">Plastic Toy</option>
				</select>
			</div>
			<button class="btn btn-primary">Create</button>
		</div>
		<div class="alert alert-danger">There is a error</div>
	</div>
</div>