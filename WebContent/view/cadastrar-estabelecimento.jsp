<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" href="<c:url value="/images/favicon.png"/>"/>
	
    <title>Acesso Fácil | Cadastrar Estabelecimento</title>
    
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
			<h1 class="titulo-pagina">Cadastrar Estabelecimento</h1>
			
			<div class="pull-right">
        		<a href="<c:url value="/view/estabelecimentos.jsp"/>" class="btn btn-info voltar">voltar</a>
        	</div>
			
			<form id ="cadastrar-estabelecimento" action="/acessofacil/controller.do" method="post"> 						
				<div class ="container-cadastro col-sm-12 col-md-8 col-md-push-2 no-padding">  												          
					<div class="row ">                 
						<div class="form-group col-md-8 col-sm-12 col-xs-12">              
							<label for="pNome">Nome Estabelecimento</label>                     
							<input type="text" class="form-control" name="nome" id="pNome" required maxlength="100" placeholder="Digite o nome do estabelecimento" title="Campo de preenchimento obrigatório." autofocus>                
						</div>                            
						<div class="form-group col-md-4 col-sm-12 col-xs-12">                     
							<label for="pCategoria">Categoria</label>                     
							
							<select class="form-control categoria" id="pCategoria" name="categoriaId" title="Campo de preenchimento obrigatório.">
							<option value="0">	- Selecione uma categoria -	</option>
							<c:forEach var="categoria" items="${categorias}">
								<option value="${categoria.id }">${categoria.nome }</option>
							</c:forEach>
							</select>												
						</div>             
					</div> 
						
					<!-- API BUSCA CEP  -->		
					<form id="busca-cep" action="." method="get"> 
						<div class="row">                 
							<div class="form-group col-md-4 col-sm-4 col-xs-6">                     
								<label for="cep">CEP <span class="info">(opcional)</span></label>                     
								<input type="text" class="form-control" name="cep" id="cep" maxlength="9" placeholder="Digite o CEP">																			
							</div>											  										
						</div>         
						<div class="row">                
							<div class="form-group col-md-10 col-sm-12 col-xs-12">                    
								<label for="endereco">Endereço</label>                     
								<input type="text" class="form-control" name="endereco" id="endereco" size="60" required maxlength="60" placeholder="Digite o nome da rua, avenida..." title="Campo de preenchimento obrigatório." required>                 
							</div> 								 
							<div class="form-group col-md-2 col-sm-3 col-xs-4">                     
								<label for="pNumEdereco">Nº</label>                     
								<input type="text" class="form-control" name="numEndereco" id="pNumEdereco" required maxlength="6" placeholder="Número">                
							</div>            
						</div>
						<div class="row">                 
							<div class="form-group col-md-5 col-sm-5 col-xs-9">                     
								<label for="bairro">Bairro</label>                     
								<input type="text" class="form-control" name="bairro" id="bairro" size="40" required maxlength="40"  placeholder="Digite o nome do bairro" title="Campo de preenchimento obrigatório." required>      
							</div>                             
							<div class="form-group col-md-5 col-sm-5 col-xs-9">                     
								<label for="cidade">Cidade</label>                     
								<input type="text" class="form-control" name="cidade" id="cidade" size="40" required maxlength="40"  placeholder="Digite o nome da cidade" title="Campo de preenchimento obrigatório." required>      
							</div>             																					   
							<div class="form-group col-md-2 col-sm-2 col-xs-3">                     
								<label for="uf">UF</label>                     
								<select class="form-control" name="uf" id="uf" title="Campo de preenchimento obrigatório." required>
									<option value=""> - - </option>
									<option value="AC">AC</option>
									<option value="AL">AL</option>
									<option value="AP">AP</option>
									<option value="AM">AM</option>
									<option value="BA">BA</option>
									<option value="CE">CE</option>
									<option value="DF">DF</option>
									<option value="ES">ES</option>
									<option value="GO">GO</option>
									<option value="MA">MA</option>
									<option value="MT">MT</option>
									<option value="MS">MS</option>
									<option value="MG">MG</option>
									<option value="PA">PA</option>
									<option value="PB">PB</option>
									<option value="PR">PR</option>
									<option value="PE">PE</option>
									<option value="PI">PI</option>
									<option value="RJ">RJ</option>
									<option value="RN">RN</option>
									<option value="RS">RS</option>
									<option value="RO">RO</option>
									<option value="RR">RR</option>
									<option value="SC">SC</option>
									<option value="SP">SP</option>
									<option value="SE">SE</option>
									<option value="TO">TO</option>
								</select>
							</div>             
						</div> 						
					</form><!-- ./#busca-cep -->									

					<div id="acoes" class="row pull-right acoes">
						<button type="submit" id="cadastrar-estab" class="btn btn-primary btn-lg cadastrar" name="command" value="CadastrarEstabelecimento">Cadastrar</button>
					</div> 												
				 </div><!-- /.container-cadastro --> 	  												
			  </form> <!-- /.cadastrar-estabelecimento -->
		  </div><!-- /.wrap -->
		</div><!-- /.container -->
	</div><!-- /.wrapper -->
	
	<!-- Rodapé -->
    <c:import url="../imports/footer.jsp"/>

    <!-- JS -->
    <script src="<c:url value="/js/cadastrar_estabelecimento.js"/>"></script>
    <script src="<c:url value="/js/editar_colaborador.js"/>"></script>  
    <c:if test="${not empty erroNomeEstab}"><script>alert("Já existe um estabelecimento cadastrado com esse nome!");</script></c:if>
    <script src="<c:url value="/js/acessibilidade.js"/>"></script>
  </body>
</html>