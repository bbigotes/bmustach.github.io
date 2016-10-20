console.log('This would be the main JS file.');
 $(document ).ready(function() {
        console.log( "document loaded" );
});


$.ajax({
  url: "/blog/post",
  success: function(data){
     $(data).find("a:contains(.xml)").each(function(){
        // will loop through 
        var images = $(this).attr("href");

        $('<p></p>').html(images).appendTo('contenedor')

     });
  }
});