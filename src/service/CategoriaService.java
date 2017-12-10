package service;

import java.util.List;

import dao.CategoriaDAO;
import model.Categoria;

public class CategoriaService {
	CategoriaDAO dao = new CategoriaDAO();

	public Categoria carregar(int id) {
		return dao.carregar(id);
	}
	
	public List<Categoria> listarCategorias() {
		return dao.listarCategorias();
	}
}
