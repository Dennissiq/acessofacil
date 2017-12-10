package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Estabelecimento;
import service.CategoriaService;
import service.EstabelecimentoService;

public class CadastrarEstabelecimento implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pNome = request.getParameter("nome");
		String pLogradouro = request.getParameter("endereco");
		String pBairro = request.getParameter("bairro");
		String pCidade = request.getParameter("cidade");
		String pNumero = request.getParameter("numEndereco");
		String pCep = request.getParameter("cep");
		String pUf = request.getParameter("uf");
		String pIdCategoria = request.getParameter("categoriaId");
		pCep = pCep.replace("-", "");
		int varErro = 0;
		
		Estabelecimento estabelecimento = new Estabelecimento();
		CategoriaService catService = new CategoriaService();
    
		estabelecimento.setNome(pNome);
		estabelecimento.setLogradouro(pLogradouro);
		estabelecimento.setBairro(pBairro);
		estabelecimento.setCidade(pCidade);
		estabelecimento.setNumero(pNumero);
		estabelecimento.setCep(pCep);
		estabelecimento.setUf(pUf);
		estabelecimento.setCategoria(catService.carregar(Integer.parseInt(pIdCategoria)));
		
		EstabelecimentoService es = new EstabelecimentoService();	
		RequestDispatcher view = null;
		varErro = es.criar(estabelecimento);
		
		if(varErro == -1919) {		
			//usuario já cadastrado com esse username
			request.setAttribute("erroNomeEstab","erroNomeEstab");
			view = request.getRequestDispatcher("view/cadastrar-estabelecimento.jsp");			
			view.forward(request, response);			
		}else {		
			response.sendRedirect("controller.do?command=ListarEstabelecimento");
		}	
		
		
	}
	
	public int busca(Estabelecimento estabelecimento, ArrayList<Estabelecimento> estabelecimentos) {
		Estabelecimento to;
		for (int i = 0; i < estabelecimentos.size(); i++) {
			to = estabelecimentos.get(i);
			if (to.getId() == estabelecimento.getId()) {
				return i;
			}
		}
		return -1;
	}
	
}