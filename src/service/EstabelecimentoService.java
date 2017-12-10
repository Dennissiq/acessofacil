package service;

import java.util.List;

import dao.EstabelecimentoDAO;
import model.Estabelecimento;

public class EstabelecimentoService {
	EstabelecimentoDAO dao = new EstabelecimentoDAO();

	public int criar(Estabelecimento estabelecimento) {
		return dao.criar(estabelecimento);
	}

	public Estabelecimento carregar(int id) {
		return dao.carregar(id);
	}
	
	public List<Estabelecimento> listarTodosEstabelecimentos(int offset, int nOfEstabelecimentos) {
		return dao.listarTodosEstabelecimentos(offset, nOfEstabelecimentos);		
	}
	
	public List<Estabelecimento> listarEstabelecimentos(String chave){
		return dao.listarEstabelecimentos(chave);
	}
}