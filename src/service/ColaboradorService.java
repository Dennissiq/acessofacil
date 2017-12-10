package service;

import dao.ColaboradorDAO;
import model.Colaborador;

public class ColaboradorService {

	ColaboradorDAO dao = new ColaboradorDAO();

	public int criar(Colaborador colaborador) {
		return dao.criar(colaborador);
	}

	public void atualizar(Colaborador colaborador) {
		dao.atualizar(colaborador);
	}

	public Colaborador carregar(int id) {
		return dao.carregar(id);
	}
	
	public Colaborador buscarPorEmailESenha(String email, String senha) {
		return dao.buscaPorEmailESenha(email, senha);
	}
	
	public void softDelete(Colaborador colaborador) {
		dao.softDelete(colaborador);
	}
}
