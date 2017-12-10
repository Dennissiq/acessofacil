<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<!-- msg confirmação -->
<div class="modal fade alert-delet" id="confimacao-deletar" role="dialog" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog"> <!-- modal-sm -->
      <div class="modal-content form_estabelecimento">
        <div>  
          <h4 class="modal-alert-title">Confirmação de exclusão de Conta</h4>
        </div>
        <div class="modal-body">
          		
         <p><strong>${usuarioLogado.username }</strong>, deseja apagar sua conta do sistema? Os dados da conta serão apagados permanentemente.</p> 	                                						
          
        </div>             
        <div id="actions" class="row">
          	<button type="button" id="ok-alert" class="btn btn-danger cancelar btn-alert cancel-alert" >Não</button>	
			<button type="submit" id="ok-alert" class="btn btn-default confirmar btn-alert" name="command" value="ExcluirColaborador">Sim</button>							  	                																	           																							   
		</div>     
      </div>
    </div>
  </div>