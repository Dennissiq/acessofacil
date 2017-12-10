package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Estabelecimento;
import service.EstabelecimentoService;


public class CarregarAvaliacao implements Command  {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pEstabelecimentoId = request.getParameter("EstabelecimentoId");
		String pNomeEstabelecimento = request.getParameter("nomeEstabelecimento");
			
		int idEstab = 0;
		
		try {
			idEstab = Integer.parseInt(pEstabelecimentoId);
		} catch (NumberFormatException e) {

		}
		
		Estabelecimento estabelecimento = new Estabelecimento();		
		estabelecimento.setNome(pNomeEstabelecimento);
	
		RequestDispatcher view = null;
		
		EstabelecimentoService es = new EstabelecimentoService();	
		
		estabelecimento = es.carregar(idEstab);
		request.setAttribute("estabelecimento", estabelecimento);
		
		
		view = request.getRequestDispatcher("view/avaliar-estabelecimento.jsp");
		
		view.forward(request, response);		
	}

}
