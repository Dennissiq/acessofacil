//Trata o evento 
$("#avaliar-estabelecimento").submit(function() {

  if ($("#pItem").val() == "0") {
    alert('Selecione um item de avaliação!');
    return false;
  }

  if ($("#pNota").val() == "0") {
    alert('Selecione uma nota!');
    return false;
  }

});
