package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Colaborador;
import service.ColaboradorService;

public class ExcluirColaborador implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Colaborador colaborador = (Colaborador) session.getAttribute("usuarioLogado");
		ColaboradorService colService = new ColaboradorService();
		colService.softDelete(colaborador);
		request.getSession().invalidate();
		response.sendRedirect("/acessofacil");
	}

}
