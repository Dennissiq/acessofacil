package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Categoria;
import model.Colaborador;
import model.Item;
import service.CategoriaService;
import service.ColaboradorService;
import service.ItemService;

public class Login implements Command {
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		ColaboradorService colService = new ColaboradorService();
		Colaborador colaborador = colService.buscarPorEmailESenha(email, senha);
		if(colaborador == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			request.setAttribute("erro", "Email e/ou senha não correspondem a um usuário cadastrado.");
			dispatcher.forward(request, response);
		} else {
			logaUsuario(request, response, colaborador);
		}
	}

	public static void logaUsuario(HttpServletRequest request, HttpServletResponse response, Colaborador colaborador)
			throws IOException {
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(10 * 60);
		session.setAttribute("usuarioLogado", colaborador);
		// setar itens e categorias
		ItemService itService = new ItemService();
		List<Item> itens = itService.listarItens();
		session.setAttribute("itens", itens);
		CategoriaService catService = new CategoriaService();
		List<Categoria> categorias = catService.listarCategorias();
		session.setAttribute("categorias", categorias);
		// redireciona para estabelecimentos logado
		System.out.println("Colaborador logando " + colaborador.getEmail());
		response.sendRedirect("controller.do?command=ListarEstabelecimento");
	}
}
