//acessibilidade
(function($) {
  function changeFont(fontSize) {
      return function() {
         $('.table, .paginacao, label, .container-visualizacao p').css('font-size', fontSize + '%');
         sessionStorage.setItem('fSize', fontSize);
      }
    }

    var normalFont = changeFont(85),
        mediumFont = changeFont(100),
        largeFont  = changeFont(115);

    $('.js-font-decrease').on('click', function(){
      normalFont();
    });

    $('.js-font-normal').on('click', function(){
      mediumFont();
    });

    $('.js-font-increase').on('click', function(){
      largeFont();
    });

    if (sessionStorage.length !== 0) {
      $('.table, .paginacao, label, .container-visualizacao p').css('font-size', sessionStorage.getItem('fSize') + '%');
    }
  
})(jQuery);