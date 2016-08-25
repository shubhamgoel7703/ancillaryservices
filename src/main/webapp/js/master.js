// JavaScript Document
// Author Name: Saptarang
// Author URI: http://www.saptarang.org
// Themeforest: http://themeforest.net/user/saptarang?ref=saptarang
// Creation Date: 22 Oct, 2015


( function ( $ ) {
    'use strict';
  
		// Top Arrow
		$(window).scroll(function() {
			if ($(window).scrollTop() > 1000) { 
				$('a.top').fadeIn('slow'); 
			} else { 
				$('a.top').fadeOut('slow');
			}
		});
	
		// Collapse menu for small devices
		var winWidth = $('body').width();
		if (winWidth <= 767) {
			
			// Add attribs to menu
			$('#menu .navbar-nav li a').attr('data-toggle', 'collapse');
			$('#menu .navbar-nav li a').attr('data-target', '#menu');
			
			// smooth page Scroll
			$('nav a[href^=#], a.top[href^=#], a.smooth[href^=#]').on("click", function(event) {
			  event.preventDefault();
			  $('html,body').animate({
			  scrollTop: $(this.hash).offset().top - 150},
			  1000);	
			});
			
			// clone subscribe
			$(".subscribe").appendTo("#hidCon");
			
		} else {
		
			// smooth page Scroll
			$('nav a[href^=#], a.top[href^=#], a.smooth[href^=#]').on("click", function(event) {
			  event.preventDefault();
			  $('html,body').animate({
			  scrollTop: $(this.hash).offset().top - 0},
			  1000);	
			});
		}
		
		// Slider option 3
		$('#image-slider.carousel').carousel({
			pause: 'false',
		  interval: 7000 // slideshow speed
		})
		function captionReset() {
			$('.carousel .active').each(function() {
					$(this).find('.carousel-caption h3').animate({marginLeft:'25.250em', opacity:'0'}, 200);	
					$(this).find('.carousel-caption h6').animate({marginLeft:'-25.250em', opacity:'0'}, 200);		
			});
		}
		function carouselCustom() {
			$('.carousel .active').each(function() {
				$(this).find('.carousel-caption h3, .carousel-caption h6').animate({marginLeft:'0', opacity:'1'}, 400);	
				$(this).find('.carousel-caption h6').animate({marginLeft:'0', opacity:'1'}, 400);	
			});
		}
		// Set First Slide Caption to Transparent
		$('#image-slider .carousel-caption h3, .carousel-caption h6').css("opacity", "0");
		$('#image-slider .carousel-caption h3').after('<br />');
	
		// first slide show
		carouselCustom();
	
		$('#image-slider').bind('slide.bs.carousel', function (e) {
			captionReset();
		});
		$('#image-slider').bind('slid.bs.carousel', function (e) {
			carouselCustom();
		});
	
		// Instanciating a custom countdown
		var countdown = new Countdown({
			selector: '#timer',
			msgBefore: "Be Ready!",
			msgAfter: "Sorry Folks, try our next Tour!",
			msgPattern: "<div><span>{months}</span> months</div> <div><span>{days}</span> days</div> <div><span>{hours}</span> hours</div> <div><span>{minutes}</span>mins</div> <div><span>{seconds}</span> sec</div>",
			//msgPattern: "<div><span>{years}</span> years</div> <div><span>{months}</span> months</div> <div><span>{days}</span> days</div> <div><span>{hours}</span> hours</div> <div><span>{minutes}</span>minutes</div> <div><span>{seconds}</span> seconds</div>",
			dateStart: new Date('2013/12/25 12:00'),
			dateEnd: new Date('Jan 1, 2018 12:00')
		});
	  
	

		
		
	  // OWL CAROUSEL: ITINARARY - Layout option 2
	  $("#itinarary2").owlCarousel({
      		navigation : true, // Show next and prev buttons
			navigationText : ["<img class='svg' src='images/svg/arrow-left-s.svg' onerror='this.src='arrow-left-s.png' alt='Prev' />","<img class='svg' src='images/svg/arrow-right-s.svg' onerror='this.src='arrow-right-s.png'' alt='Next' />"],
      		slideSpeed : 300,
      		paginationSpeed : 400,
      		singleItem:true,
	  		pagination: false
		});
	  
	  // OWL CAROUSEL: GALLERY
	  $("#galleryCarousel").owlCarousel({
		  	autoPlay: false, //Set AutoPlay to 3 seconds
		  	items : 5,
		  	itemsDesktop : [1199,4],
		  	itemsDesktopSmall : [979,3],
		  	itemsMobile : [600,2],
		  	navigation : true, // Show next and prev buttons
		  	navigationText : ["<img class='svg' src='images/svg/arrow-left-s.svg' onerror='this.src='arrow-left-s.png' alt='Prev' />","<img class='svg' src='images/svg/arrow-right-s.svg' onerror='this.src='arrow-right-s.png'' alt='Next' />"],
		  	pagination: false
	  });
	  
	  // OWL CAROUSEL: LINED UP
	  $("#upcoming").owlCarousel({
		  autoPlay: false, //Set AutoPlay to 3 seconds
		  items : 3,
		  itemsDesktop : [1199,3],
		  itemsDesktopSmall : [979,3],
		  itemsMobile : [600,1],
		  navigation : true, // Show next and prev buttons
		  navigationText : ["<img class='svg' src='images/svg/arrow-left-s.svg' onerror='this.src='arrow-left-s.png' alt='Prev' />","<img class='svg' src='images/svg/arrow-right-s.svg' onerror='this.src='arrow-right-s.png'' alt='Next' />"],
		  pagination: false
	  });
	  
	  // Testimonials
		$('#testimonial.carousel').carousel({
		  	interval: 7000 // slideshow speed
		})
		
	  // Input placeholder in IE
	  $('input, textarea').placeholder();
	  
	  // Image Lightbox
	  $("a[data-rel^='prettyPhoto']").prettyPhoto({overlay_gallery: true});
	
	  
	  // Contact Form
	  $('.loader').hide();
	   
	  $("#contact_form").submit(function() {
		  // validate and process form here
		  var name = $("#name").val();
				if (name == "") {
				$('#name').addClass('reqfld');
				$('<span class="error" style="display:none; margin-top:0px;"><i class="fa fa-hand-o-right"></i> Required!</span>').insertBefore('#name').fadeIn(400);
				$("#name").focus(function() {  $('#name').removeClass('reqfld');  $(this).prev().fadeOut(400);});
				return false;
		  }
		  
		  var email = $("#email").val();
		  if (email == "") {
				$('#email').addClass('reqfld');
				$('<span class="error" style="display:none;"><i class="fa fa-hand-o-right"></i> Required!</span>').insertBefore('#email').fadeIn(400);
				$("#email").focus(function() {  $('#email').removeClass('reqfld');  $(this).prev().fadeOut(400);});
				return false;
		   } else if(email.indexOf('@') == -1 || email.indexOf('.') == -1) {
				$('#email').addClass('reqfld');
				$('<span class="error" style="display:none;">Invalid Email Address!</span>').insertBefore('#email').fadeIn(400);
				$("#email").focus(function() {  $('#email').removeClass('reqfld');  $(this).prev().fadeOut(400);});
				return false;
		  } 
			
		  var phone = $("#phone").val();
				if (phone == "") {
				$('#phone').addClass('reqfld');
				$('<span class="error" style="display:none;"><i class="fa fa-hand-o-right"></i> Required!</span>').insertBefore('#phone').fadeIn(400);
				$("#phone").focus(function() {  $('#phone').removeClass('reqfld');  $(this).prev().fadeOut(400);});
				return false;
		  }
		  var comment = $("#comment").val();
				if (comment == "") {
				$('#comment').addClass('reqfld');
				$('<span class="error" style="display:none;"><i class="fa fa-hand-o-right"></i> Required!</span>').insertBefore('#comment').fadeIn(400);
				$("#comment").focus(function() {  $('#comment').removeClass('reqfld');  $(this).prev().fadeOut(400);});
				return false;
		  }
		  
		  $('#contact_form').animate({opacity:'0.3'}, 500);
	
		  var security = $("#security").val();
	
		  var dataString = 'name='+ name + '&email=' + email + '&phone=' + phone + '&comment=' + comment + '&security=' + security;
		  
		  //alert (dataString);return false;
		  $.ajax({
			type: "POST",
			url: "form/contact.php",
			data: dataString,
			success: function() {
			  $("#contact_form").animate({opacity:'1'}, 500);
			  $('.loader').hide();
			  $("<div id='success' class='alert alert-success' style='border:#"+successBox_Border_Color+" 1px "+successBoxBorderStyle+"; background:#"+successBoxColor+";' ></div>").insertAfter('#contact_form');
			  $('#contact_form').slideUp(300);
			  $('#success').html("<h5 style='color:#"+textColor+";'>"+submitMessage+"</h5><p style='color:#"+textColor+";'>"+successParagraph+"</p>")
			  .hide().delay(300)
			  .fadeIn(1500);
			}
		  });
		  return false;
	  });
  
	  // Subscription Form Validation
		$("#subscribeForm input").on("focus", (function() {
			  $(this).prev("label").hide();
			  $(this).prev().prev("label").hide();	 		 	
		}));
		   
		$("#subscribeForm").submit(function() {
			  // validate and process form here
			  var name1Subscribe = $("#name1Subscribe").val();
			  
			  var name2Subscribe = $("#name2Subscribe").val();
			  
			  var emailSubscribe = $("#emailSubscribe").val();
			  if (emailSubscribe == "") {
					$('#emailSubscribe').addClass('reqfld');
					$('<span class="error" style="display:none; margin-top:0px;"><i class="fa fa-hand-o-right"></i> Required!</span>').insertBefore('#emailSubscribe').fadeIn(400);
					$("#emailSubscribe").on("focus", (function() {  $('#emailSubscribe').removeClass('reqfld');  $(this).prev().fadeOut(400);}));
					return false;
			   } else if(emailSubscribe.indexOf('@') == -1 || emailSubscribe.indexOf('.') == -1) {
					$('#emailSubscribe').addClass('reqfld');
					$('<span class="error" style="display:none; margin-top:0px;"><i class="fa fa-hand-o-right"></i> Invalid!</span>').insertBefore('#emailSubscribe').fadeIn(400);
					$("#emailSubscribe").on("focus", (function() {  $('#emailSubscribe').removeClass('reqfld');  $(this).prev().fadeOut(400);}));
					return false;
			  }
		  
			  var sub_security = $("#sub-security").val();
				  
			  var dataString = '&name1Subscribe=' + name1Subscribe + '&name2Subscribe=' + name2Subscribe + '&emailSubscribe=' + emailSubscribe + '&sub-security=' + sub_security;
			  
			  $.ajax({
				type: "POST",
				url: "form/subscribe.php",
				data: dataString,
				success: function() {
				  $("#subscribeForm .form-row").hide();
				  $('#subscribeForm').append("<div id='subscribesuccess' class='alert alert-success' style='border:#"+sub_successBox_Border_Color+" 1px "+sub_successBoxBorderStyle+"; background:#"+sub_successBoxColor+";' ></div>");
				  $('#subscribesuccess').html("<h5 class='text-center' style='color:#"+sub_textColor+";'><i class='fa fa-check-circle'></i> "+sub_submitMessage+"</h5>")
				  .hide().delay(300)
				  .fadeIn(1500);
				  
				  $('#subscribeForm .form-row').delay(6000).slideUp('fast');
				  
				}
			  });
			  return false;
		});	
		
		  
		/*  Replace all SVG images with inline SVG */
		$('img.svg').each(function(){
			var $img = $(this);
			var imgID = $img.attr('id');
			var imgClass = $img.attr('class');
			var imgURL = $img.attr('src');
  
			$.get(imgURL, function(data) {
			// Get the SVG tag, ignore the rest
			var $svg = $(data).find('svg');
  
			// Add replaced image's ID to the new SVG
			if(typeof imgID !== 'undefined') {
				$svg = $svg.attr('id', imgID);
			}
			// Add replaced image's classes to the new SVG
			if(typeof imgClass !== 'undefined') {
				$svg = $svg.attr('class', imgClass+' replaced-svg');
			}
  
			// Remove any invalid XML tags as per http://validator.w3.org
			$svg = $svg.removeAttr('xmlns:a');
  
			// Replace image with new SVG
			$img.replaceWith($svg);
  
			}, 'xml');
  
		});
		
		// WOW - animated content
		var wow = new WOW(
		  {
		  boxClass:     'wow',      // default
		  animateClass: 'animated', // default
		  offset:       100,          // default
		  mobile:       true,       // set false if you dont want animation on mobile phones
		  live:         true        // default
		}
		)
		wow.init();
		
		var dataCount = "";
		$("#travelInfo .itineraryBlock").click(function(){
		var rowBlock = $(this).parent();
		if($(this).attr("data-count") == dataCount) {
			rowBlock.removeClass("active");
			rowBlock.find(".owl-demo").css("display","none");
			rowBlock.find(".fa-plus").css("display","block");
			rowBlock.find(".fa-minus").css("display","none");
			dataCount = "";
		} else {
			$("#travelInfo .row").each(function() {
				if($(this).hasClass("active")) {
					$(this).removeClass("active");
					$(this).find(".owl-demo").css("display","none");
			rowBlock.find(".fa-plus").css("display","block");
			rowBlock.find(".fa-minus").css("display","none");
				}
			});
			
			 // OWL CAROUSEL: TRAVEL INFO
			rowBlock.find(".owl-demo").css("display","block");
			rowBlock.find(".fa-plus").css("display","none");
			rowBlock.find(".fa-minus").css("display","block");
			rowBlock.find(".owl-demo").owlCarousel({
				autoPlay: 8000, //Set AutoPlay to 3 seconds
				items : 3,
				itemsDesktop : [1199,3],
				itemsDesktopSmall : [979,2],
				itemsTablet : [768,2],
				itemsMobile : [600,1],
				navigation : true, // Show next and prev buttons
				navigationText : ["<img class='svg' src='images/svg/arrow-left-s.svg' onerror='this.src='arrow-left-s.png' alt='Prev' />","<img class='svg' src='images/svg/arrow-right-s.svg' onerror='this.src='arrow-right-s.png'' alt='Next' />"],
				pagination: false
			});
			
				equalheight(rowBlock.find(".owl-demo").find(".item"));
				
				rowBlock.addClass("active");
				$('html,body').animate({scrollTop: $('#cart').offset().top},'slow'); 
				dataCount = $(this).attr("data-count");
			}
		});
		
} ( jQuery ) );

	// Equal Height for Owl carousel
	equalheight = function(container){

	var currentTallest = 0,
     	currentRowStart = 0,
    	 rowDivs = new Array(),
     	$el,
     	topPosition = 0;
 	$(container).each(function() {

   		$el = $(this);
   		$($el).height('auto')
   		topPostion = $el.position().top;

		 if (currentRowStart != topPostion) {
		   for (currentDiv = 0 ; currentDiv < rowDivs.length ; currentDiv++) {
			 rowDivs[currentDiv].height(currentTallest);
		   }
		   rowDivs.length = 0; // empty the array
		   currentRowStart = topPostion;
		   currentTallest = $el.height();
		   rowDivs.push($el);
		 } else {
		   rowDivs.push($el);
		   currentTallest = (currentTallest < $el.height()) ? ($el.height()) : (currentTallest);
		}
		 for (currentDiv = 0 ; currentDiv < rowDivs.length ; currentDiv++) {
		   rowDivs[currentDiv].height(currentTallest);
		 }
 	});
	}

	$(window).load(function() {
	  $(".owl-demo").each(function() {
			equalheight($(this).find('.item'));
		});
	});
	
	
	$(window).resize(function(){
	  $(".owl-demo").each(function() {
			equalheight($(this).find('.item'));
		});
	});