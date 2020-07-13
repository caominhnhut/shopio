$(function() {

	$("#loginModal").dialog({
		modal : true,
		minWidth : 350,
		closeOnEscape : false,
		open : function(event, ui) {
			$(".ui-widget-overlay").css({
				background : "#DDDDDD",
				opacity : 1
			});

			$(".ui-dialog .ui-dialog-titlebar-close").css({
				display : "none"
			});
		}
	});

	$("#accessDeniedModal").dialog({
		modal : true,
		minWidth : 500,
		closeOnEscape : false,
		open : function(event, ui) {
			$(".ui-widget-overlay").css({
				background : "#DDDDDD",
				opacity : 1
			});

			$(".ui-dialog .ui-dialog-titlebar-close").css({
				display : "none"
			});
		}
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

	$("#txtProductCode").keyup(function() {
		$("#lbProductCodeError").hide();
		$("#lbProductError").hide();
	});
	
	$("#txtProductName").keyup(function() {
		$("#lbProductNameError").hide();
		$("#lbProductError").hide();
	});
	
	$("#txtCostPrice").keyup(function() {
		$("#lbCostPriceError").hide();
		$("#lbProductError").hide();
	});
	
	$("#txtSellingPrice").keyup(function() {
		$("#lbSellingPriceError").hide();
		$("#lbProductError").hide();
	});
	
	$("#btnResetDataOnProductForm").click(function(){
		resetProductModal();
	});
	
	function resetProductModal() {
		$("#txtProductCode").val('');
		$("#txtProductName").val('');
		$("#txtCostPrice").val(0);
		$("#txtSellingPrice").val(0);
		$("#imgProduct").attr('src', '/sio-console/asset/pictures-icon.png');
		
		cleanUpErrorMessageOnProductForm();
	}

	function cleanUpErrorMessageOnProductForm()
	{
		$("#lbProductCodeError").hide();
		$("#lbProductNameError").hide();
		$("#lbCostPriceError").hide();
		$("#lbSellingPriceError").hide();
		$("#lbProductError").hide();
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