$(document).ready(function(){
	
	
  $("#searchbar").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#character-table tbody tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
  
  
  
});