$(document).ready(function() {
        		
    $('#horseNo').on('change', function() {
        const result = $(this).find('option:selected').val();
                
          if(result == 10) {
               $('#map').show();
            $('#sample5_address').show();
            $('#address').show();            			
        } else {
            $('#map').hide();
            $('#sample5_address').hide();
            $('#address').hide();
        }
    });   
    
    
            
});
        
        
window.addEventListener('load', function() {
    const saveBtn = document.getElementById('saveBtn');
    
    saveBtn.addEventListener('click', function() {
    const form = document.getElementById('form');
    form.submit();
    }); 
});

       