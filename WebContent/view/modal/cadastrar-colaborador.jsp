<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>			
<!-- Modal -->
<div class="modal fade" id="cadastrarColaboradorModal" role="dialog" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog">			  
		<!-- Modal content-->
		<div class="modal-content container_modal form_estabelecimento">
			<div class="modal-header">
			  <button type="button" class="close_modal" data-dismiss="modal">&times;</button>
			  <h1 class="modal-title">Cadastro de Colaborador</h1>
			</div>
			
			<!-- form principal de cadastro de colaborador-->
			<form id ="cadastrar-colaborador" name ="formulario" action="controller.do" method="post"> 
				<div class="modal-body">							
					<div class ="container_cadastro col-sm-12 col-md-12">  		
						<div class ="form_estabelecimento col-sm-12 col-md-12">												  
							<!-- area de campos do form -->             
							<div class="row ">                 
								<div class="form-group col-md-12 col-sm-12 col-xs-12 ">                     
									<label for="pNomeUsuario">Nome de usuário</label>                     
									<input type="text" class="form-control" name="username" id="pNomeUsuario" required maxlength="100" placeholder="Digite seu nome de usuário" title="Campo de preenchimento obrigatório.">                
								</div>             
							</div>
							
							<div class="row ">                 
								<div class="form-group col-md-12 col-sm-12 col-xs-12 ">                     
									<label for="pNome">Nome</label>                     
									<input type="text" class="form-control" name="nome" id="pNome" required maxlength="100" placeholder="Digite o seu nome" title="Campo de preenchimento obrigatório.">                
								</div>             
							</div> 
								
							<div class="row ">                 
								<div class="form-group col-md-12 col-sm-12 col-xs-12 ">                     
									<label for="pSobreNome">Sobrenome</label>                     
									<input type="text" class="form-control" name="sobrenome" id="pSobreNome" required maxlength="100" placeholder="Digite o seu sobrenome" title="Campo de preenchimento obrigatório.">                
								</div>             
							</div> 
																		
							<div class="row">                 
								<div class="form-group col-md-12">                     
									<label for="pEmail">Email</label>                     
									<input type="email" class="form-control" name="email" id="pEmail" size="50" required maxlength="50"  placeholder="exemplo@exemplo.com" title="Campo de preenchimento obrigatório.">      
								</div>             
							</div>	
																				  												
							<div class="row">  
								<div class="form-group col-md-12"> 
									<label for="pSenha">Senha</label>
									<div class="input-group col-md-12"> 
										<input type="password" class="form-control" name="senha" id="pSenha" required min="6" maxlength="10" placeholder="Digite sua senha" title="Campo de preenchimento obrigatório."> 
										<span class="input-group-btn"> <button id ="btnEye" class="btn btn-default" type="button"> <span id ="iEye" class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></button></span> 
									</div>
									<span class="info">a senha deve conter no mínimo 6 e no máximo 10 caracteres, uma letra e um número.</span>
								</div>
							</div>																														 																			
						</div><!-- /.form_estabelecimento --> 									
					</div><!-- /.container_cadastro --> 
					
					<div id="actions" class="row">
						<button type="button" id="cancelar-cadastro" class="btn btn-lg cancelar" data-dismiss="modal">Cancelar</button>	                 																	 
						<button type="submit" id ="cadastrar-colab" class="btn btn-lg cadastrar" name="command" value="CadastrarColaborador">Cadastrar</button>           																							   
					</div>
												   											
				</div> <!-- /.modal-body-->								
			</form> <!-- /.cadastrar-colaborador-->
		</div><!-- /.modal-content-->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->