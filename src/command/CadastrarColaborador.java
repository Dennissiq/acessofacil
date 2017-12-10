package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Colaborador;
import service.ColaboradorService;

public class CadastrarColaborador implements Command {
	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pSobrenome = request.getParameter("sobrenome");
		String pUsername = request.getParameter("username");
		String pEmail = request.getParameter("email");
		String pSenha = request.getParameter("senha");
		int id = -1;
		int varErro = 0;
		
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}

		Colaborador colaborador = new Colaborador();
		colaborador.setId(id);
		colaborador.setNome(pNome);
		colaborador.setSobrenome(pSobrenome);
		colaborador.setUsername(pUsername);
		colaborador.setEmail(pEmail);
		colaborador.setSenha(pSenha);
		ColaboradorService cs = new ColaboradorService();
		
		RequestDispatcher view = null;
		varErro = cs.criar(colaborador);
		
		if(varErro == -9999) {
			//usuario já cadastrado com esse email!
			
			request.setAttribute("erroEmail","email existente");		
			view = request.getRequestDispatcher("index.jsp");			
			view.forward(request, response);
		} else if(varErro == -1919) {
			
			//usuario já cadastrado com esse username			
			view = request.getRequestDispatcher("index.jsp");
			request.setAttribute("erroUsername","username existente");
			view.forward(request, response);
		}		
		else {
			Login.logaUsuario(request, response, colaborador);
			
		}
				
	}
}
