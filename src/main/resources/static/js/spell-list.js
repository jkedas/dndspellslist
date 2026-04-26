$(document).ready(function() {
	$('.spell-content > div[name="description"] > span').each( function() {$(this).html(marked.parse($(this).html())) } )
	//switches table to the level tab you click on
	$('.level-nav > li').on('click', function() {
		
		$('.level-nav > li').removeClass('active')
		$(this).addClass('active')
		$('div.spell-list > table').css('display', 'none');
		
		switch( $(this).attr('value') ) {
			case"0": 
				$('table.cantrips').css('display', ''); 
				break;
			case "1": 
				$('table.first-level').css('display', '');
				break;
			case "2": 
				$('table.second-level').css('display', '');
				break;
			case "3": 
				$('table.third-level').css('display', '');
				break;
			case "4": 
				$('table.fourth-level').css('display', '');
				break;
			case "5": 
				$('table.fifth-level').css('display', '');
				break;
			case "6": 
				$('table.sixth-level').css('display', '');
				break;
			case "7": 
				$('table.seventh-level').css('display', '');
				break;
			case "8": 
				$('table.eighth-level').css('display', '');
				break;
			case "9": 
				$('table.ninth-level').css('display', '');
				break;
			default:
				console.log("none");
				break;
		}
		
	});
	
	//shows spellcard when you click a spell's name in the table
	
	$('tbody').on('click', '.spell-row > td[name="spell-name"] > button', close_card);
	$('tbody').on('keyup', '.spell-row > td[name="spell-name"] > button', function(e) {
		if(e.key === "Escape") {
			close_card();
		}
	});

	
	//sorts spells by class
	$('#class-filters').on('change', filter_classes_rows );
	
})


function filter_classes_rows() {
    let selection = $("#class-filters").val().toLowerCase();
    if(selection === 'none') {
        $('.spell-row').each(function() {
            $(this).toggle(true);
        })
        return;
    }
    let val_present;
	
    $('.spell-row').each(function() {
        val_present = $(this).find('td[name="class-list"]').text().toLowerCase().indexOf(selection) > -1;//checks if spell has a class
        $(this).toggle(val_present);
        
        if(val_present) {
            $(this).prop('filtered', false);
        }
        else {
            $(this).prop('filtered', true);
        }
    });
}

function close_card() {
	$('.spellcard.active').toggle();
	$('.spellcard.active').removeClass('active');
	
	$('.spellcard[name="' + $(this).text() + '"]').toggle()
	$('.spellcard[name="' + $(this).text() + '"]').addClass('active');
	console.log($(this).text())
	
	$('.close-btn').on('click', function() {		
		$('.spellcard.active').toggle();
		$('.spellcard.active').removeClass('active');
	});
}