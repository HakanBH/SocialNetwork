$(window).load(function() {
	
	$('img.bgfade').hide();
	var dg_H = $(window).height();
	var dg_W = $(window).width();
	$('#wrap').css({
		'height' : dg_H,
		'width' : dg_W
	});
	function anim() {
		$("#wrap img.bgfade").first().appendTo('#wrap').fadeOut(1500);
		$("#wrap img").first().fadeIn(1500);
		setTimeout(anim, 10000);
	}
	anim();
})

$(window).resize(function() {
	window.location.href = window.location.href
})
