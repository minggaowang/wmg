/*  
Theme Name: Visio - Responsive Website Template
Theme URI: http://preview.devisio.ro/visio-v1.2/ 
Description: Visio - Responsive Website Template is a responsive website template based on the well known Bootstrap framework. Easy to work with, easy to customize and infinite solutions that can be implemented in your project are just a few attributes that recommend Visio to be one of the most complete template.
Author: Devisio
Author URI: http://www.devisio.ro
Version: 1.2
File version: 1.1                        
License URI: http://wrapbootstrap.com                  
*/

// On load functions
$(window).load(function(){
	// Isotope Masonry
	if($('.masonry-wrapper').length > 0){
		$('.masonry-wrapper').isotope({
		    itemSelector: '.masonry-block',
		    masonry: {
		      columnWidth: '.masonry-block',
		      gutter: '.masonry-gutter'
		    }
		});
	}
});

// On document ready functions
$(document).ready(function() {
	// GLOBAL VARIABLES
	var navbarOffsetTop = $('.header-affix').data('offset-top');

	// Affix navbar main
	$('.header-affix').affix({
		offset: {
			top: navbarOffsetTop
		}
	});;

	// Affix navbar before event fires
	$(".header-affix").on('affix.bs.affix', function(){
		// Variables
		var navAnimationIn = $(this).data('nav-animation');

		// Add a body class to before the affix event fires
		$('body').addClass('header-affixed');
		
		if($(this).data('offset-top') > 0){
			// Animate the affixed menu with Animate CSS (you can add any animation class you want)
	     	$(this).addClass('animated ' + navAnimationIn);
	     	$(this).one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function(){
	     		$(this).removeClass('animated ' + navAnimationIn);
	     	});
	     }
    });

	if($(".dynamic-page-cover").length > 0){
    	dynamicPageCover();
    }

    $(window).resize(function() {
	    // Dynamic Height Page Cover
	    if($(".dynamic-page-cover").length > 0){
    		dynamicPageCover();
    	}
	});
    
    function dynamicPageCover(){
    	var windowHeight = $(window).height();
    	var headerHeight = $("#header").height();
    	var searchHeight = $(".slider-opt-height").height();
    	if(searchHeight == undefined){
    		searchHeight = 0;
    	}
    	var newCoverHeight = parseInt(windowHeight) - parseInt(headerHeight) -60 + parseInt(searchHeight);
    
    	$(".dynamic-page-cover").css({"height": newCoverHeight + "px"});
    }
});