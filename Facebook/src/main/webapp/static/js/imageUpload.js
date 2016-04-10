/**
 * 
 */$(document).on('click', '#close-preview', function(){ 
    $('.image-preview').popover('hide');
    // Hover before close the preview
    $('.image-preview').hover(
        function () {
           $('.image-preview').popover('show');
        }, 
         function () {
           $('.image-preview').popover('hide');
        }
    );    
});
 
 $(document).on('click', '#close-preview', function(){ 
	    $('.image-preview1').popover('hide');
	    // Hover before close the preview
	    $('.image-preview1').hover(
	        function () {
	           $('.image-preview1').popover('show');
	        }, 
	         function () {
	           $('.image-preview1').popover('hide');
	        }
	    );    
	});

$(function() {
    // Create the close button
    var closebtn = $('<button/>', {
        type:"button",
        text: 'x',
        id: 'close-preview',
        style: 'font-size: initial;',
    });
    closebtn.attr("class","close pull-right");
    // Set the popover default content
    $('.image-preview').popover({
        trigger:'manual',
        html:true,
        title: "<strong>Preview</strong>"+$(closebtn)[0].outerHTML,
        content: "There's no image",
        placement:'bottom'
    });
    // Clear event
    $('.image-preview-clear').click(function(){
        $('.image-preview').attr("data-content","").popover('hide');
        $('.image-preview-filename').val("");
        $('.image-preview-clear').hide();
        $('.image-preview-input input:file').val("");
        $(".image-preview-input-title").text("Browse"); 
    }); 
    // Create the preview image
    $(".image-preview-input input:file").change(function (){     
        var img = $('<img/>', {
            id: 'dynamic',
            width:250,
            height:200
        });      
        var file = this.files[0];
        var reader = new FileReader();
        // Set preview image into the popover data-content
        reader.onload = function (e) {
            $(".image-preview-input-title").text("Change");
            $(".image-preview-clear").show();
            $(".image-preview-filename").val(file.name);            
            img.attr('src', e.target.result);
            $(".image-preview").attr("data-content",$(img)[0].outerHTML).popover("show");
        }        
        reader.readAsDataURL(file);
    });  
});

$(function() {
    // Create the close button
    var closebtn = $('<button/>', {
        type:"button",
        text: 'x',
        id: 'close-preview',
        style: 'font-size: initial;',
    });
    closebtn.attr("class","close pull-right");
    // Set the popover default content
  $('.image-preview1').popover({
  trigger:'manual',
  html:true,
  title: "<strong>Preview</strong>"+$(closebtn)[0].outerHTML,
  content: "There's no image",
  placement:'bottom'
});
    // Clear event
  $('.image-preview-clear1').click(function(){
      $('.image-preview1').attr("data-content","").popover('hide');
      $('.image-preview-filename1').val("");
      $('.image-preview-clear1').hide();
      $('.image-preview-input1 input:file').val("");
      $(".image-preview-input-title1").text("Browse"); 
  }); 
    // Create the preview image
  $(".image-preview-input1 input:file").change(function (){     
      var img = $('<img/>', {
          id: 'dynamic',
          width:250,
          height:200
      });      
      
      var file = this.files[0];
      var reader = new FileReader();
      // Set preview image into the popover data-content
      reader.onload = function (e) {
          $(".image-preview-input-title1").text("Change");
          $(".image-preview-clear1").show();
          $(".image-preview-filename1").val(file.name);            
          img.attr('src', e.target.result);
          $(".image-preview1").attr("data-content",$(img)[0].outerHTML).popover("show");
      }        
      reader.readAsDataURL(file);
  });  
});