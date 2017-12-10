<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" href="<c:url value="/images/favicon.png"/>"/>
	
    <title>Acesso Fácil | Visualizar Estabelecimento</title>
    
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/estilo.css"/>" >
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/estabelecimento.css"/>">
    
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/elegant-icons.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/slick.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/slick-theme.css"/>"/>
   
    <script type="text/javascript" src="<c:url value="/js/jquery.min.js"/>"></script>	    
    <script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>
  </head>
  <body>   
  	<!-- Modais -->
	<c:import url="modal/editar-perfil.jsp"/>
	  
    <div class="wrapper">
      <!-- Menu -->
      <c:import url="../imports/menu.jsp"/>

      <!-- Container Principal -->
      <div class="container">
        <h1 class="titulo-pagina">Visualizar Estabelecimento</h1>
        
        <div class="pull-right">
        	<a href="<c:url value="/view/estabelecimentos.jsp"/>" class="btn btn-info voltar">voltar</a>
        </div>
			
          <div class="container-visualizacao">	
            <div class="wrap">	
               <div class="col-md-8 col-md-push-2 col-sm-12 col-xs-12">		        	              							
	               <div class="row">
	                  <label>Nome Estabelecimento: </label>
	                  <p>${estabelecimento.nome}</p>
	               </div>											               
				   <div class="row">                                   
						<label>Endereço: </label> 
						<c:if test="${not empty estabelecimento.cep}">                    
							<p>${estabelecimento.logradouro}, ${estabelecimento.numero} - ${estabelecimento.bairro},  ${estabelecimento.cidade} - ${estabelecimento.uf}, ${estabelecimento.cep}</p>           
				   		</c:if>
				   		<c:if test="${empty estabelecimento.cep}">                    
							<p>${estabelecimento.logradouro}, ${estabelecimento.numero} - ${estabelecimento.bairro},  ${estabelecimento.cidade} - ${estabelecimento.uf}</p>           
				   		</c:if>
				   </div> 
				   <div class="row">                                   
						<label>Categoria: </label>                     
						<p>${estabelecimento.categoria.nome}</p>           
				   </div> 
			   </div>
			   <div class="col-md-12 col-sm-12 col-xs-12">	
				   <div class="row">
				   		<div class="visualizar-avaliacoes">
				   			<c:forEach var="avaliacao" items="${avaliacoes}">
							  <div>							  	
							  	<p class="nota"><span class="icon_star"></span> ${avaliacao.nota}</p>
							  	<p class="nome">${avaliacao.colaborador.nome} ${avaliacao.colaborador.sobrenome}</p>	
							  	<p class="data"><fmt:formatDate type="date" dateStyle="long" value="${avaliacao.dt_avaliacao}" /></p>
							  	<p class="comentario">${avaliacao.comentario}</p>
							  	<p class="item">- ${avaliacao.item.nome}</p>							  	
							  </div>
						  	</c:forEach>
						</div>
				   </div>
			   </div>
			   <c:if test="${empty avaliacoes}">
		          	<div class="col-md-8 col-md-push-2 col-sm-12 col-xs-12 info-avaliacao">
		          		<p class="retorno-vazio">Este estabelecimento ainda não foi avaliado. 
		          		<a
						href="<c:url value="/controller.do?command=CarregarAvaliacao&EstabelecimentoId=${estabelecimento.id }&ColaboradorId=${usuarioLogado.id }"/>"
						>Colabore adicionando a primeira avaliação!</a>
		          		</p>
		          	</div>
		        </c:if>
			</div>	        				                
          </div><!-- /.container-visualizacao -->	
	  </div><!-- /.container -->
    </div><!-- /.wrapper -->
   
    <!-- Rodapé -->
    <c:import url="../imports/footer.jsp"/>

    <!-- JS -->
    <script type="text/javascript" src="<c:url value="/js/editar_colaborador.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/slick.min.js"/>"></script>
    <script src="<c:url value="/js/acessibilidade.js"/>"></script>
    
    <script>
    if(screen.width <= 600 ) {  
    	$('.visualizar-avaliacoes').slick({
   	   	  infinite: true,
   	   	  slidesToShow: 1,
   	   	  slidesToScroll: 1
   	   	});  
    } else {
    	$('.visualizar-avaliacoes').slick({
   	   	  infinite: true,
   	   	  slidesToShow: 3,
   	   	  slidesToScroll: 3
   	   	});
    }
    </script>
  </body>
</html>
