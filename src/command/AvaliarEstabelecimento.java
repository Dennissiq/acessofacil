package command;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Avaliacao;
import model.Colaborador;

import service.AvaliacaoService;
import service.EstabelecimentoService;
import service.ItemService;

public class AvaliarEstabelecimento implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pEstabelecimentoId = request.getParameter("EstabelecimentoId");
		String pItemId = request.getParameter("itemId");
		String pNota = request.getParameter("nota");
		String pComentario = request.getParameter("comentario");
		java.sql.Timestamp dataAvaliacao = new Timestamp(System.currentTimeMillis());
		
		int itemId = 0, idEstab = 0;
		double nota = 0.0;
		
		try {
			idEstab = Integer.parseInt(pEstabelecimentoId);
			itemId = Integer.parseInt(pItemId);
			nota = Double.parseDouble(pNota);
		} catch (NumberFormatException e) {

		}

		Avaliacao avaliacao = new Avaliacao();
		
		HttpSession session = request.getSession();
		Colaborador colaborador = (Colaborador) session.getAttribute("usuarioLogado");
		
		EstabelecimentoService esService = new EstabelecimentoService();
		ItemService iteService = new ItemService();
		
		avaliacao.setEstabelecimento(esService.carregar(idEstab));
		avaliacao.setColaborador(colaborador);
		avaliacao.setItem(iteService.carregar(itemId));
		avaliacao.setNota(nota);
		avaliacao.setComentario(pComentario);
		avaliacao.setDt_avaliacao(dataAvaliacao);
		
		AvaliacaoService as = new AvaliacaoService();				
		as.criar(avaliacao);
		
		response.sendRedirect("controller.do?command=ListarEstabelecimento");
	}
}