<div id="addProductModal" title="Add New Product">
	<div class="row">
		<div class="col-md-6">
			<div class="image"><img src="<c:url value="/asset/pictures-icon.png" />" /></div>
			<div><input type="file"></div>
		</div>
		<div class="col-md-6">
			<div>
				<input type="text" placeholder="Product ID">
			</div>
			<div>
				<input type="text" placeholder="Product Name">
			</div>
			<div>
				<input type="number" placeholder="Cost Price">
			</div>
			<div>
				<input type="number" placeholder="Selling Price">
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