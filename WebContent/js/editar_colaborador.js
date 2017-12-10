// Adicionando Jquery 
	//Verifica senha ao enviar o fomulario de edicão	
	$("#editar-colaborador").ready(function() {	
		
		$("#editar-colab").on("click", function(){
			
			$("#deletar-colab").addClass("hidden");
			$("#editar-colab").addClass("hidden");
			$("#cancelar-edicao").removeClass("hidden");
			$("#salvar-edicao").removeClass("hidden");
			$(".obs").removeClass("hidden");	
			$(".lbCamposObrigatorios").text("* ");
			
			$('.editonly').prop('readonly', false);
			
		});
		
		$("#cancelar-edicao, .close-editar").on("click", function(){ 
									
			$("#deletar-colab").removeClass("hidden");
			$("#editar-colab").removeClass("hidden");
			$("#cancelar-edicao").addClass("hidden");
			$("#salvar-edicao").addClass("hidden");
			$(".obs").addClass("hidden");
			$(".lbCamposObrigatorios").text("");
			
			$('.editonly').prop('readonly', true);
		});
	});
	
	
	$(document).ready(function() {

		$("#editar-colaborador").submit(function(){
				
			var senha = document.formulario.senha.value;
			var regex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{6,10}$/;
				
			if(senha.length < 6){
				alert("A senha deve conter no minímo 6 caracteres!");
				document.formulario.senha.focus();
				return false;
			}
			else if(!regex.exec(senha)){
				
				alert("A senha deve ter no mínimo 6 e no máximo 10 caracteres e conter uma letra e um número!");
				document.formulario.senha.focus();
				return false;
			}
			return true;
		});
	});
	
	
	$(document).ready(function() {			
		$(".cancel-alert").click(function(){
	        $("#confimacao-deletar").modal("hide");
	    });
	});
	
	
	//Altera icone e tipo de visualização da senha quando o botão é clicado (pag. cadastro colab)
	$(document).ready(function () {
		$("#btnEye").click(function () {
			if ($("#pSenha").attr("type") === "password") {
				$("#pSenha").attr("type", "text");
				$("#iEye").attr("class", "glyphicon glyphicon-eye-close");
				
			} else {
				$("#pSenha").attr("type", "password");
				$("#iEye").attr("class", "glyphicon glyphicon-eye-open");
			}
		});
	}); 