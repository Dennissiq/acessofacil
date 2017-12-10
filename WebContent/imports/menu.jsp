<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
      	<div class=container>
  	        <div class="navbar-header">
  	            <button id ="btn-navbar-toggle" type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
  	                <span class="sr-only">Toggle navigation</span>
  	                <span class="icon-bar"></span>
  	                <span class="icon-bar"></span>
  	                <span class="icon-bar"></span>
  	            </button>
  	            <a class="navbar-brand" href="<c:url value="/view/estabelecimentos.jsp"/>"><img src="<c:url value="/images/logo.png"/>" alt=""></a>
  	        </div>

  	        <div id="navbar" class="navbar-collapse collapse">
  	            <ul class="nav navbar-nav navbar-right">
  	            	<li class="acessibilidade">
  	            		<a class="js-font-decrease">A-</a>
  	            		<a class="js-font-normal">A</a>
  	            		<a class="js-font-increase">A+</a>
  	            	</li>
    	            <li class="estabelecimento">
    	                <a href="<c:url value="/view/estabelecimentos.jsp"/>"><span class="icon_building"></span> Estabelecimentos</a>
    	            </li>
  	                <li class ="perfil">					
                        <a data-toggle="dropdown" href="#">
                          <span class="nome-colaborador">
                        	  <span class="icon_profile"></span> <c:if test="${not empty usuarioLogado }">${ usuarioLogado.nome }</c:if>
                          </span><b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu" role="menu">
                          <li>
                          	<a data-toggle="modal" data-target="#editarColaboradorModal"><span class="icon_cog"></span> Editar Perfil</a>
                          </li>
                          <li role="presentation" class="divider"></li>
                          <li>
                          	<a href="<c:url value="/controller.do?command=Logout"/>"><span class="arrow_back"></span> Sair</a>
                          </li>
                        </ul>                    
  	                </li>
  	            </ul>
  	        </div>
      	</div>
    </div>
</nav>
