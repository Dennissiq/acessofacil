// Adicionando Jquery 	
		//Verifica senha ao enviar o cadastro
        $(document).ready(function() {
			
			$("#cadastrar-colaborador").submit(function(){
				
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
		
		function myFunction() {
			$('#cadastrar-colab').click(function() {
				  $('.alert').toggle()
				});
		}
    