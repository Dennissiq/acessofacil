package command;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Item;
import service.ItemService;


public class ListarItensAvaliacao implements Command{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ItemService is = new ItemService();
		List<Item> listaItens = new ArrayList<>();
		HttpSession session = request.getSession();			
		listaItens = is.listarItens(); 
		session.setAttribute("listaItens", listaItens);
		
		RequestDispatcher view = request.getRequestDispatcher("estabelecimentos.jsp");

		view.forward(request, response);
	}

	
}
