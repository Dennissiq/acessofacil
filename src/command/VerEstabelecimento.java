package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Avaliacao;
import model.Categoria;
import model.Colaborador;
import model.Estabelecimento;
import model.Item;
import service.AvaliacaoService;
import service.EstabelecimentoService;


public class VerEstabelecimento implements Command {
	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pAvaliacaoId = request.getParameter("avaliacao_id");
		
		int id = -1;
		int avaliacao_id = -1;
		
		try {
			id = Integer.parseInt(pId);
			avaliacao_id = Integer.parseInt(pAvaliacaoId);
		} catch (NumberFormatException e) {

		}

		Estabelecimento estabelecimento = new Estabelecimento();
		Avaliacao avaliacao = new Avaliacao();
		
		EstabelecimentoService es = new EstabelecimentoService();	
		AvaliacaoService as = new AvaliacaoService();
		
		estabelecimento.setId(id);
				
		List<Avaliacao> avaliacoes;
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		estabelecimento = es.carregar(id);
		Categoria categoria = estabelecimento.getCategoria();
		avaliacoes = as.listarAvaliacoes(estabelecimento.getId());
		avaliacao = as.carregar(avaliacao_id);	
		Colaborador colaborador = avaliacao.getColaborador();
		Item item = avaliacao.getItem();
		
		session.setAttribute("estabelecimento", estabelecimento);
		session.setAttribute("categoria", categoria);
		session.setAttribute("avaliacoes", avaliacoes);
		session.setAttribute("avaliacao", avaliacao);
		session.setAttribute("colaborador", colaborador);
		session.setAttribute("item", item);
		
		view = request.getRequestDispatcher("view/visualizar-estabelecimento.jsp");
		view.forward(request, response);

	}
}
