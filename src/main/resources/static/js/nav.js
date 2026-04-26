
$(document).ready(function() {
	$(".nav-item").each(function() {
		$(this).removeClass('active');
	})
	
	const current = $('.navbar').attr('data-current-page');
	$('#'+current).addClass('active');
})




