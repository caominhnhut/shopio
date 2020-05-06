$(function() {

  $("#dialog").dialog({
     autoOpen: false,
     modal: true
   });

  $("#btnAddProduct").on("click", function(e) {
      e.preventDefault();
      $("#dialog").dialog("open");
  });

});