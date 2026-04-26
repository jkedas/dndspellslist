//on document load
$(document).ready(function() {

	$('div[name="description"] > span, div[name="higher-levels"] > span').each(function() {
		let text = $(this).text()
		$(this).empty();
		$(this).append(text);
	})
    //track input when a keypress occurs
    

    //handle class filtering
    //$("#class-filters").on('change', filter_classes);

    //school filtering
    $("#school-filters").on('change', filter_schools); 

    //level filtering
    $("#level-filters").on('change', filter_levels);
        
});


//toggle functions
function filter_classes() {
    let selection = $("#class-filters").val().toLowerCase();
    if(selection === 'none') {
        $('.spellcard').each(function() {
            $(this).toggle(true);
        })
        return;
    }
    let val_present;

    $('.spellcard').each(function() {
        val_present = $(this).find('[name="spell-lists"]').text().toLowerCase().indexOf(selection) > -1;//checks if spell has a class
        $(this).toggle(val_present);
        
        if(val_present) {
            $(this).prop('filtered', false);
        }
        else {
            $(this).prop('filtered', true);
        }
    });
}

function filter_schools() {
    let selection = $("#school-filters").val().toLowerCase();
    console.log(selection);
    if(selection === 'none') {
        $('.spellcard').each(function() {
            $(this).toggle(true);
        })
        return;
    }
    let val_present = true;

    $('.spellcard').each(function() {
        val_present = $(this).find('[name="level-school"]').text().toLowerCase().indexOf(selection) > -1;//checks if spell has a class
        console.log(val_present);
        $(this).toggle(val_present);

        if(val_present) {
            $(this).prop('filtered', false);
        }
        else {
            $(this).prop('filtered', true);
        }
    }); 
}

function filter_levels() {
    let selection = $("#level-filters").val().toLowerCase();
    console.log(selection);
    if(selection === 'none') {
        $('.card-category').each(function() {
            $(this).toggle(true);
        })
        return;
    }
    let val_present = true;

    $('.card-category').each(function() {
        val_present = $(this).attr('name').toLowerCase().indexOf(selection) > -1;
        console.log(val_present);
        $(this).toggle(val_present);

        if(val_present) {
            $(this).prop('filtered', false);
        }
        else {
            $(this).prop('filtered', true);
        }
    });
}