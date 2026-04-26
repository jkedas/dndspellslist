$(document).ready(function () {
	
	
	$("#searchbar").on("keyup", function () {

	        //gets the input
	        let value = $(this).val().toLowerCase();
			
			if (value === "") {
				$('div[name="Spell Names"] > a').css('display', 'none');
				console.log("empty")
			}

	        //check each row in table. #myTable is in the body which prevents filtering headers
	        else { 
				
				let i = 0;
				$('div[name="Spell Names"] > a').each(function() {
	            let val_present = $(this).text().toLowerCase().indexOf(value) > -1;//checks if row's text has the value
	            if ( !$(this).prop('filtered') ){
	                $(this).toggle(val_present);
					i++;
					if (i===10) {return false;}
	            }
	            
	        });
			}

	});
	
	
	$('.add-spell').on('click', addSpell);
	$('.remove-spell').on('click', removeSpell);
	
	$('#show-spell-edit').on('click', edit);
	$('#show-spell-adder').on('click', function () {
		$('.spell-adder-window').removeClass('hidden');
	});
	$('#hide-spell-edit').on('click', hideEdit);
	
	$('#close-window').on('click', function () {
		location.reload()
	});
	
	
	
	
});


function edit() {
	$('#hide-spell-edit').removeClass('hidden');
	$(this).addClass('hidden');
	
	$('#show-spell-adder').removeClass('hidden');
	$('td[name="remove-spell"]').removeClass('hidden');
	$('th.remove').removeClass('hidden');
	
	
}

function hideEdit() {
	location.reload();
}

function addSpell() {
	
	let token = $('meta[name="_csrf"]').attr('content');
	let header = $('meta[name="_csrf_header"]').attr('content');
	
	let formData = new FormData();
	let spell = $( $(this).closest('tr').prop('outerHTML') );
	let pc_id = $('input[name="character_id"]').val();
	let id = spell.children('td[name="spell-id"]').text()
	formData.append('add_id', id);
	formData.append('pc_id', pc_id)
	
	$.ajax({
		type: 'POST',
		url: '/add-spell',
		data: formData,
		processData: false,
		contentType: false,
		beforeSend: function (xhr) {
			xhr.setRequestHeader(header, token);
			$('#loading').show();
		},
		complete: function () {
			$('#loading').hide();
		},
		success: function(response) {
			$('#form-container').load(response);;
		}
	})
}

function removeSpell() {
	let token = $('meta[name="_csrf"]').attr('content');
	let header = $('meta[name="_csrf_header"]').attr('content');
		
	let formData = new FormData();
	let spell = $( $(this).closest('tr').prop('outerHTML') );
	let pc_id = $('input[name="character_id"]').val();
	let id = spell.children('td[name="spell-id"]').text()
	formData.append('remove_id', id);
	formData.append('pc_id', pc_id)
	$.ajax({
		type: 'POST',
		url: '/remove-spell',
		data: formData,
		processData: false,
		contentType: false,
		beforeSend: function (xhr) {
			xhr.setRequestHeader(header, token);
			$('#loading').show();
		},
		complete: function () {
			$('#loading').hide();
		},
		success: function(response) {
			$('#form-container').load(response);
			console.log(response);
		}
	})
}

