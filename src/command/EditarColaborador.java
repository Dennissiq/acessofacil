package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Colaborador;
import service.ColaboradorService;

public class EditarColaborador implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pSobrenome = request.getParameter("sobrenome");
		String pUsername = request.getParameter("username");
		String pEmail = request.getParameter("email");
		String pSenha = request.getParameter("senha");
		int id = -1;
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

		cs.atualizar(colaborador);
		request.setAttribute("usuarioLogado", colaborador);
		view = request.getRequestDispatcher("view/estabelecimentos.jsp");		
		
		view.forward(request, response);
	}

}
