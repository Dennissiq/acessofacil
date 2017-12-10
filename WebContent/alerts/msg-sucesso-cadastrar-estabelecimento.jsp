<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>			
<!-- Alert -->

<c:if test="${not empty estabelecimentos}">
	
	  <div class="top-alert" > 
			<div id ="alerta-cadastro" class="alert alert-success alert-dismissable text-center " role="alert" style="display:none;"> <!-- style= "display:block;" -->
	        	<div id="list" class="row"> 
	               
	                	<c:forEach var="estabelecimento" items="${estabelecimentos}"> 
	                	              	
						<p>Estabelecimento, <strong>${estabelecimento.nome }</strong>, cadastrado com <strong> Sucesso!</strong></p> 	                                						
	                    </c:forEach>                        
	         	 </div>
	         
	                <!-- /#list -->  
	             <div id="actions" class="row">
							<button type="button" id="ok-alert" class="btn btn-default btn-alert" data-dismiss="alert">ok</button>	                																	           																							   
		 		</div>           
	   		</div> 
	  </div>          		              
</c:if>