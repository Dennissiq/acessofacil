<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" href="<c:url value="/images/favicon.png"/>"/>
	
    <title>Acesso Fácil | Gerenciar Estabelecimento</title>
    
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
      <div class="container ">
        <div class="col-md-12 col-sm-12 col-xs-12 no-padding">
          <form action="/acessofacil/controller.do" method="post">    
            <div class="pesquisa col-md-12 col-sm-12 col-xs-12 no-padding">
              <input name="data[search]" type="text" class="form-control text" id="search" maxlength="300" placeholder="Nome do estabelecimento" autofocus>
              <button type="submit" id="busca-estabelecimento" class="btn btn-primary btn-lg" name="command" value="ListarEstabelecimento">Buscar</button>
            </div><!-- ./form-group -->
            
            <div class="cadastro col-md-11 col-md-push-1 col-sm-12 col-xs-12 no-padding">
		  	  <p>Não localizou o estabelecimento desejado?</p>
		  	  <a href="<c:url value="/view/cadastrar-estabelecimento.jsp"/>" class="btn btn-info btn-lg">Cadastrar</a>
		    </div>		  
          </form>
		  
		  <c:if test="${not empty estabelecimentos}">
			<table class="table estabelecimento">
				<thead>
					<tr>
						<th>Estabelecimentos</th>
						<th>Avaliação Média</th>
						<th>Ações</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="estabelecimento" items="${estabelecimentos}">
						<tr>
							<td>${estabelecimento.nome}</td>
							<td>${estabelecimento.notaMedia != 0.0 ? estabelecimento.notaMedia : 'N/A'}
							</td>
							<td><a
								href="<c:url value="/controller.do?command=VerEstabelecimento&id=${estabelecimento.id }"/>"
								class="action-plus icon_plus_alt2" data-toggle="tooltip"
								data-placement="left" title="Ver"></a> <a
								href="<c:url value="/controller.do?command=CarregarAvaliacao&EstabelecimentoId=${estabelecimento.id }&ColaboradorId=${usuarioLogado.id }"/>"
								class="action-star icon_star_alt" data-toggle="tooltip"
								data-placement="right" title="Avaliar"></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<span class="pull-right info">N/A = Não Avaliado</span>

			<div class="col-md-12 col-sm-12 col-xs-12 paginacao">
				<c:if test="${currentPage != 1}">
					<a href="/acessofacil/controller.do?command=ListarEstabelecimento&page=${currentPage - 1}"  class="prev arrow_carrot-left_alt2"></a>
				</c:if>

				<c:forEach begin="1" end="${noOfPages}" var="i">
					<c:choose>
						<c:when test="${currentPage eq i}">
							<span class="item active">${i}</span>
						</c:when>
						<c:otherwise>							
							<a href="/acessofacil/controller.do?command=ListarEstabelecimento&page=${i}" class="item">${i}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:if test="${currentPage lt noOfPages}">
					<a href="/acessofacil/controller.do?command=ListarEstabelecimento&page=${currentPage + 1}" class="next arrow_carrot-right_alt2"></a>
				</c:if>
			</div>
          </c:if>  
          <c:if test="${empty estabelecimentos}">
          	<div class="col-md-10 col-md-push-2 col-sm-12 col-xs-12">
          		<p class="retorno-vazio">Nenhum estabelecimento corresponde a busca realizada.
          		<a href="<c:url value="/controller.do?command=ListarEstabelecimento"/>">Clique aqui para retornar a lista.</a>
          		</p>
          	</div>
          </c:if>  
        </div>
      </div><!-- /.container --> 
    </div><!-- /.wrapper -->

    <!-- Rodapé -->
    <c:import url="../imports/footer.jsp"/>

    <!-- JS -->
    <script src="<c:url value="/js/cadastrar_estabelecimento.js"/>"></script> 
    <script src="<c:url value="/js/visualizar_estabelecimento.js"/>"></script>   
    <script src="<c:url value="/js/avaliar_estabelecimento.js"/>"></script> 
    <script src="<c:url value="/js/editar_colaborador.js"/>"></script>   
    <script src="<c:url value="/js/gerenciar_estabelecimentos.js"/>"></script>
    <script src="<c:url value="/js/acessibilidade.js"/>"></script>
  </body>
</html>