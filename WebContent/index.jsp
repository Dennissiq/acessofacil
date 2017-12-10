<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang ="pt-br">
	<head>
		<c:if test="${not empty usuarioLogado }"><c:redirect url="/view/estabelecimentos.jsp"/></c:if>
		
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
	 	<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="icon" href="images/favicon.png" />
		
		<title>Acesso Fácil - Entrar</title>

		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link href="css/estilo.css" rel="stylesheet">
		<link href="css/estabelecimento.css" rel="stylesheet">

		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>

	</head>
	<body class ="home">
		
		<div class="wrapper">
			<div class="grafismo-top"></div>
			
			<!-- Modal Cadastrar Colaborador -->
			<c:import url="view/modal/cadastrar-colaborador.jsp"/>

			<!-- Alert Cadastrar Colaborador -->
			<c:import url="alerts/msg-sucesso-cadastrar-colaborador.jsp"/>

			<div class="container login">
				<form class="form-signin" action="controller.do" method="POST">
					<div class="logo"></div>
					
					<h3 class="form-signin-heading">Por favor, insira seus dados</h3>
					<c:if test="${not empty erro }">${erro}</c:if>
					<input type="email" id="email" name="email" class="form-control" placeholder="E-mail" required autofocus>
					<input type="password" id="senha" name="senha" class="form-control" placeholder="Senha" required>
					<!-- div class="checkbox">
						<input type="checkbox" value="lembrar-senha"> Lembrar-me
					</div-->

					<button type="submit" value="Login" name="command" class="btn btn-lg entrar">Entrar</button>
				</form>
				<p class="criar-conta">
        			Não possui uma conta?
        			<a data-toggle="modal" data-target="#cadastrarColaboradorModal">Cadastrar-se</a>.
   				</p>
			</div> <!-- /container -->
    	</div><!-- /.wrapper -->
		
		<div class="footer-home">     
			<div class="container">
		      <p>Acesso Fácil | Todos os direitos reservados &copy; <%= new java.text.SimpleDateFormat("yyyy").format(new java.util.Date()) %></p>
		    </div>
		</div>
		<div class="grafismo-bottom"></div>
		
    	<!-- JS -->
		<script src="js/cadastrar_colaborador.js"></script>
		<c:if test="${not empty erroUsername}"><script>alert("Já existe um colaborador cadastrado com o nome de usuário informado!");</script></c:if>
		<c:if test="${not empty erroEmail}"><script>alert("Já existe um colaborador cadastrado com o email informado!");</script></c:if>
    </body>
</html>
