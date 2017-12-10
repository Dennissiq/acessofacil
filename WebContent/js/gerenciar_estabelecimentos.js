$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();   
    
    $(".action-plus").mouseover(function(){
    	$(this).removeClass('icon_plus_alt2');
        $(this).addClass('icon_plus_alt');
    });
    
    $(".action-plus").mouseout(function(){
    	$(this).removeClass('icon_plus_alt');
        $(this).addClass('icon_plus_alt2');
    });
    
    $(".action-star").mouseover(function(){
    	$(this).removeClass('icon_star_alt');
        $(this).addClass('icon_star');
    });
    
    $(".action-star").mouseout(function(){
    	$(this).removeClass('icon_star');
        $(this).addClass('icon_star_alt');
    });
    
    $(".estabelecimento").addClass('active');
});