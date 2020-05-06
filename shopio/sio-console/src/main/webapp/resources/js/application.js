$(function() {

  $("#addProductModal").dialog({
     autoOpen: false,
     modal: true,
     minWidth: 700,
     minHeight: 500
   });

  $("#btnAddProduct").on("click", function(e) {
      e.preventDefault();
      $("#addProductModal").dialog("open");
  });

});