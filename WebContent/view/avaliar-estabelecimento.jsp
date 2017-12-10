<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" href="<c:url value="/images/favicon.png"/>"/>
	
    <title>Acesso Fácil | Avaliar Estabelecimento</title>

    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/estilo.css"/>" >
    <link rel="stylesheet" href="<c:url value="/css/estabelecimento.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/elegant-icons.css"/>">

    <script src="<c:url value="/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
  </head>
  <body>
  	<!-- Modais -->
	<c:import url="modal/editar-perfil.jsp"/>

    <div class="wrapper">
      <!-- Menu -->
      <c:import url="../imports/menu.jsp"/>

      <!-- Container Principal -->
      <div class="container">
      	<div class="wrap">
	        <h1 class="titulo-pagina">Avaliar Estabelecimento</h1>
	
	        <div class="pull-right">
	        	<a href="<c:url value="/view/estabelecimentos.jsp"/>" class="btn btn-info voltar">voltar</a>
	        </div>
	
		    <form id="avaliar-estabelecimento" action="/acessofacil/controller.do" method="post">
		        <div class="container_avaliacao col-sm-12 col-md-8 col-md-push-2">
					<input type="hidden" id="username" name="username" value="${usuarioLogado.username }" readonly/>
					<input type="hidden" id="ColaboradorId" name="ColaboradorId" value="${colaborador.id }" readonly/>
					<input type="hidden" id="EstabelecimentoId" name="EstabelecimentoId" value="${estabelecimento.id }" readonly/>
	
		            <div class="row">
		              <div class="form-group col-md-12 col-sm-12 col-xs-12">
		                <label>Nome Estabelecimento: </label>
		                <p class="nome">${estabelecimento.nome}</p>
		              </div>
		            </div>
	
		            <div class="row">
		              <div class="form-group col-md-6 col-sm-12 col-xs-12">
		                <label for="pItem">Item de avaliação</label>
	
		                <select class="form-control" id="pItem" name="itemId" autofocus>
		                  	<option value="0">	- Selecione um item -	</option>
		                    <c:forEach var="item" items="${itens}">
							  <option value="${item.id }">${item.nome }</option>
						    </c:forEach>
		                </select>
		              </div>

		              <div class="form-group nota col-md-6 col-sm-12 col-xs-12">
		                <label for="pNota">Nota</label>
		                <select class="form-control" id="pNota" name="nota">
		                <option value="0">	- Selecione uma Nota -	</option>
		                <option value="1">	1 - Péssimo </option>
		                <option value="2">	2 - Ruim </option>
		                <option value="3">	3 - Regular	</option>
		                <option value="4">	4 - Bom  </option>
		                <option value="5">  5 - Ótimo </option>
		                </select>
		              </div>
		            </div>
	
		            <div class="row">
		              <div class="form-group col-md-12 col-sm-12 col-xs-12">
		                <label for="pComentario">Comentário <span class="info">(opcional)</span></label>
		                <div class="row">
		                  <textarea id="pComentario" name="comentario" maxlength="140" placeholder="Digite um comentário de até 140 caracteres"></textarea>
		                </div>
		              </div>
		            </div>
					
					<div class="row">
			            <div id="acoes" class="pull-right acoes">
			                <button type="submit" id="avaliar-estab" class="btn btn-primary btn-lg cadastrar avaliar" name="command" value="AvaliarEstabelecimento">Avaliar</button>
			            </div>
		            </div>
		        </div><!-- /.container-avaliacao -->
	        </form><!-- /.avaliar-estabelecimento -->
	     </div><!-- /.wrap -->
      </div><!-- /.container -->
    </div><!-- /.wrapper -->

    <!-- Rodapé -->
    <c:import url="../imports/footer.jsp"/>

    <!-- JS -->
    <script src="<c:url value="/js/avaliar_estabelecimento.js"/>"></script>
    <script src="<c:url value="/js/visualizar_estabelecimento.js"/>"></script>
    <script src="<c:url value="/js/editar_colaborador.js"/>"></script>
    <script src="<c:url value="/js/acessibilidade.js"/>"></script>
  </body>
</html>
