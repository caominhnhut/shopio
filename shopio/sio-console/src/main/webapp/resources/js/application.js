$(function() {

	$("#loginModal").dialog({
		modal : true,
		minWidth : 350,
		closeOnEscape: false,
		open : function(event, ui) {
			$(".ui-widget-overlay").css({
				background : "#DDDDDD",
				opacity : 1
			});
			
			$(".ui-dialog .ui-dialog-titlebar-close").css({
				display: "none"
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
	
	$("#accessDeniedModal").dialog({
		modal : true,
		minWidth : 500,
		closeOnEscape: false,
		open : function(event, ui) {
			$(".ui-widget-overlay").css({
				background : "#DDDDDD",
				opacity : 1
			});
			
			$(".ui-dialog .ui-dialog-titlebar-close").css({
				display: "none"
			});
		}
	});
	
	$("#btnAddProduct").on("click", function(e) {
		e.preventDefault();
		$("#addProductModal").dialog("open");
	});

	$("#btnChooseFile").change(function() {
		showImage(this);
	});
	
	$("#ssoId").keyup(function() {
		$("#loginErrorMessage").hide();
	});
	
	$("#password").keyup(function() {
		$("#loginErrorMessage").hide();
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