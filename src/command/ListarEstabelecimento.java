package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EstabelecimentoDAO;

import java.util.List;

import model.Estabelecimento;
import service.EstabelecimentoService;

public class ListarEstabelecimento implements Command {
	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String chave = request.getParameter("data[search]");
		int page = 1;
		int recordsPerPage = 5;
		if(request.getParameter("page") != null) page = Integer.parseInt(request.getParameter("page"));
		EstabelecimentoService es = new EstabelecimentoService();
		List<Estabelecimento> estabelecimentos = null;
		HttpSession session = request.getSession();
		if (chave != null && chave.length() > 0) {
			estabelecimentos = es.listarEstabelecimentos(chave);
		} else {			
			estabelecimentos = es.listarTodosEstabelecimentos((page-1)*recordsPerPage,recordsPerPage);
			int noOfRecords = EstabelecimentoDAO.getNOfEstabelecimentos();
			int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
			session.setAttribute("noOfPages", noOfPages);
			session.setAttribute("currentPage", page);
		}
		session.setAttribute("estabelecimentos", estabelecimentos);
		response.sendRedirect("view/estabelecimentos.jsp");
	}
}