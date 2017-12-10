<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Modal -->
<div class="modal fade" id="editarColaboradorModal" role="dialog" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content container_modal form_estabelecimento">
			<div class="modal-header">
			  <button type="button" class="close_modal close-editar" data-dismiss="modal">&times;</button>
			  <h1 class="modal-title">Editar Perfil</h1>
			</div>

			<!-- form principal de edição de colaborador-->
			<form id ="editar-colaborador" name ="formulario" action="/acessofacil/controller.do" method="post">
				
				<!-- Alert deletar Colaborador -->						
				<c:import url="modal/modal-confirmacao-deletar-colaborador.jsp"/>
				
				<div class="modal-body">
					<div class ="container_cadastro col-sm-12 col-md-12">
						<div class ="form_estabelecimento col-sm-12 col-md-12">
							<!-- area de campos do form -->
							<input type="hidden" name="id" value="${usuarioLogado.id }" />
							<div class="row ">
								<div class="form-group col-md-12 col-sm-12 col-xs-12 ">
									<label for="username">Nome de usuário </label>
									<input type="text" class="form-control" name="username" id="username" maxlength="100" placeholder="Informe um nome de usuário" value = "${ usuarioLogado.username }" readonly> <%--<c:if test="${not empty usuarioLogado }"></c:if>--%>
								</div>
							</div>

							<div class="row ">
								<div class="form-group col-md-12 col-sm-12 col-xs-12 ">
									<label for="nome">Nome</label>
									<input type="text" class="form-control editonly" name="nome" id="nome" required maxlength="100" placeholder="Informe o seu nome." value = "${ usuarioLogado.nome }" readonly >
								</div>
							</div>

							<div class="row ">
								<div class="form-group col-md-12 col-sm-12 col-xs-12">
									<label for="sobrenome">Sobrenome</label>
									<input type="text" class="form-control editonly" name="sobrenome" id="sobrenome" required maxlength="100" placeholder="Informe o seu sobrenome." value = "${ usuarioLogado.sobrenome }" readonly>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-12 col-sm-12 col-xs-12">
									<label for="email">Email</label>
									<input type="email" class="form-control editonly" name="email" id="email" size="50" required maxlength="50"  placeholder="Informe um email" value = "${ usuarioLogado.email }" readonly>
								</div>
							</div>

							<div class="row">
								<div class="form-group senha col-md-12 col-sm-12 col-xs-12">
									<label for="pSenha">Senha</label>
									<div class="input-group col-md-12 col-sm-12 col-xs-12">
										<input type="password" class="form-control editonly" name="senha" id="pSenha" required min="6" maxlength="10" placeholder="Informe uma senha" value ="${ usuarioLogado.senha }" title ="A senha deve ter pelo menos 6 e no máximo 10 caracteres e conter uma letra e um número."  readonly>
										<span class="input-group-btn"> <button id ="btnEye" class="btn btn-default" type="button"> <span id ="iEye" class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></button></span>
									</div>
								</div>
							</div>						
						</div><!-- /.form_estabelecimento -->
					</div><!-- /.container-cadastro -->

					<div id="actions" class="row">
						<button type="button" id="deletar-colab" class="btn btn-lg cancelar" data-toggle="modal" data-target="#confimacao-deletar">Deletar</button>
						<button type="button" id="editar-colab" class="btn btn-lg editar">Editar</button>

						<button type="button" id="cancelar-edicao" class="btn btn-lg cancelar hidden" >Cancelar</button>
						<button type="submit" id ="salvar-edicao" class="btn btn-lg salvar hidden" value="EditarColaborador" name="command" >Salvar Alterações</button>
					</div>
				</div> <!-- /.modal-body-->
			</form> <!-- /.editar-colaborador -->
		</div><!-- /.modal-content-->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal-->
