$(document).ready(function(){        
         /*  var originalSize = $('body').css('font-size');         
          // reset        
           $(".resetMe").click(function(){           
          $('body').css('font-size', originalSize); 
   $(".increase").prop('disabled', false); 
   $(".decrease").prop('disabled', false);          
           });
         
           // Increase Font Size          
           $(".increase").click(function(){         
          var currentSize = $('body').css('font-size');         
          var currentSize = parseFloat(currentSize)*1.2;

          $('body').css('font-size', currentSize);  
              $(".increase").prop('disabled', true);                 
          return false;          
          });        
		  
           // Decrease Font Size       
           $(".decrease").click(function(){        
           var currentFontSize = $('body').css('font-size');        
           var currentSize = $('body').css('font-size');        
           var currentSize = parseFloat(currentSize)*0.8;        
           $('body').css('font-size', currentSize);
           $(".decrease").prop('disabled', true);         
           return false;         
           });         
         });
         


function increaseFontSizeBy100px() {
    txt = document.getElementById('a');
    style = window.getComputedStyle(txt, null).getPropertyValue('font-size');
    currentSize = parseFloat(style);
    txt.style.fontSize = (currentSize + 100) + 'px';
}*/

$('.increase').click(function() {
		curSize = parseInt($('.adapt').css('font-size')) + 2;
		if (curSize <=20)
			$('.adapt').css('font-size', curSize);
	});

	$('.resetMe').click(function() {
		if (curSize != 16)
			$('.adapt').css('font-size', 16);
	});

	$('.decrease').click(function() {
		curSize = parseInt($('.adapt').css('font-size')) - 2;
		if (curSize >= 12)
			$('.adapt').css('font-size', curSize);
	});





/*
   $(".font-button").bind("click", function () {
                var size = parseInt($('body').css("font-size"));
                if ($(this).hasClass("increase")) {
                    size = size + 2;
                } else {
                    size = size - 2;
                    if (size <= 10) {
                        size = 10;
                    }
                }
                $('body').css("font-size", size);
            });*/


});
