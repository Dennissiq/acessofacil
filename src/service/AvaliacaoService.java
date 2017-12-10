package service;

import java.util.List;

import dao.AvaliacaoDAO;
import model.Avaliacao;

public class AvaliacaoService {
	AvaliacaoDAO dao = new AvaliacaoDAO();

	public int criar(Avaliacao avaliacao) {
		return dao.criar(avaliacao);
	}

	public Avaliacao carregar(int id) {
		return dao.carregar(id);
	}
	
	public List<Avaliacao> listarAvaliacoes(int estabelecimento_id) {
		return dao.listarAvaliacoes(estabelecimento_id);
	}
}
