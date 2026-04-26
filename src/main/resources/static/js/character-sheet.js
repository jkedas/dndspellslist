$(document).ready( function () {
	
	$('section.attributes input').on('change', setMods); //automatically updates modifiers based on stat scores
	$('div.score input').trigger('change');
	
	
	
	
})

function setMods() {
	const score_type = $(this).attr('class')
	const prof_bonus = Math.floor( ( $('#level').val() - 1 ) / 4 ) + 2;
	const base_score = $('div.score input.' + score_type).val();
	let mod = Math.floor((base_score-10)/2);
	let score_mod = mod;
	
	//calculates the mod and takes into account proficiency bonus. this is used on skills and saves
	let pmod = function(prof) {
		let m = (prof ? mod + prof_bonus : mod);
		return m < 0 ? m : '+' + m;
	};
	
	//update proficiency bonus
	$('input[name="proficiencybonus"]').val("+" + prof_bonus)
	//update mods
	$(this).closest('li').find('div.modifier input').val(score_mod < 0 ? score_mod : '+' + score_mod);
	
	//update saves
	$('div.saves > ul > li > input[type="text"].' + score_type).each( function() { 
		$(this).val( pmod($(this).next().prop('checked')) ); 
	});
	
	//update skills
	$('div.skills > ul > li > input[type="text"].' + score_type).each( function() { 
		$(this).val( pmod($(this).next().prop('checked')) ); 
	});
	
	//update passive perception conditionally when wis is updated 
	if (score_type == 'wis') {
		$('input[name="passiveperception"]').val(mod + 10);
	}
	
	//update intiative conditionally when dex is updated
	if (score_type == 'dex') {
		$('[name="initiative"]').val(score_mod < 0 ? score_mod : '+' + score_mod);
	}
		
}




