$(function() {

	$("#loginModal").dialog({
		modal : true,
		minWidth : 700,
		minHeight : 500,
		open : function(event, ui) {
			$(".ui-widget-overlay").css({
				background : "#DDDDDD",
				opacity : 1
			});
		}
	});

	$("#addProductModal").dialog({
		autoOpen : false,
		modal : true,
		minWidth : 700,
		minHeight : 500,
		close : function(event, ui) {
			resetProductModal();
		}
	});

	$("#btnAddProduct").on("click", function(e) {
		e.preventDefault();
		$("#addProductModal").dialog("open");
	});

	$("#btnChooseFile").change(function() {
		showImage(this);
	});

	function resetProductModal() {
		$("#txtProductId").val('');
		$("#txtProductName").val('');
		$("#txtCostPrice").val('');
		$("#txtSellingPrice").val('');
		$("#categories").val('1');
		$("#imgProduct").attr('src', 'asset/pictures-icon.png');
	}

	function showImage(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#imgProduct').attr('src', e.target.result);
			}

			reader.readAsDataURL(input.files[0]);
		}
	}
});