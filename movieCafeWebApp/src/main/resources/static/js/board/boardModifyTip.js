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
    
    if(document.getElementById("input_check").checked) {
    document.getElementById("input_check_hidden").disabled = true;
}
    
    saveBtn.addEventListener('click', function() {
    const form = document.getElementById('form');
    form.submit();
    }); 
});

       