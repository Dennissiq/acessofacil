package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Avaliacao;
import model.Colaborador;
import model.Estabelecimento;
import model.Item;
import service.ColaboradorService;
import service.EstabelecimentoService;
import service.ItemService;

public class AvaliacaoDAO {
	public int criar(Avaliacao avaliacao) {
		String sqlInsert = "INSERT INTO pi4semestre.avaliacoes (estabelecimento_id, colaborador_id, item_id, dt_avaliacao, nota, comentario) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert)){
			Estabelecimento estabelecimento = avaliacao.getEstabelecimento();
			stm.setInt(1, estabelecimento.getId());
			Colaborador colaborador = avaliacao.getColaborador();
			stm.setInt(2, colaborador.getId());
			Item item = avaliacao.getItem();
			stm.setInt(3, item.getId());
			stm.setTimestamp(4, avaliacao.getDt_avaliacao());
			stm.setDouble(5, avaliacao.getNota());
			stm.setString(6, avaliacao.getComentario());
			stm.execute();
			String sqlLastId = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlLastId); ResultSet rs = stm2.executeQuery()){
				if(rs.next()) {
					avaliacao.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return avaliacao.getId();
	}
	
	public Avaliacao carregar(int id) {
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setId(id);
		String sqlSelect = "SELECT estabelecimento_id, colaborador_id, item_id, dt_avaliacao, nota, comentario FROM pi4semestre.avaliacoes WHERE avaliacoes.id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect)){
			stm.setInt(1, avaliacao.getId());
			try (ResultSet rs = stm.executeQuery()){
				if(rs.next()) {
					EstabelecimentoService estService = new EstabelecimentoService();
					avaliacao.setEstabelecimento(estService.carregar(rs.getInt("estabelecimento_id")));
					ColaboradorService coService = new ColaboradorService();
					avaliacao.setColaborador(coService.carregar(rs.getInt("colaborador_id")));
					ItemService itService = new ItemService();
					avaliacao.setItem(itService.carregar(rs.getInt("item_id")));
					avaliacao.setDt_avaliacao(rs.getTimestamp("dt_avaliacao"));
					avaliacao.setNota(rs.getDouble("nota"));
					avaliacao.setComentario(rs.getString("comentario"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return avaliacao;
	}
	
	public List<Avaliacao> listarAvaliacoes(int estabelecimento_id){
		Avaliacao avaliacao;
		ColaboradorService colaborador;
		ItemService item;
		List<Avaliacao> avaliacoes = new ArrayList<>();
		String sqlSelect = "SELECT id, colaborador_id, item_id, dt_avaliacao, nota, comentario FROM pi4semestre.avaliacoes WHERE avaliacoes.estabelecimento_id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect)){
			stm.setInt(1, estabelecimento_id);
			try (ResultSet rs = stm.executeQuery();){
				while (rs.next()) {
					avaliacao = new Avaliacao();
					avaliacao.setId(rs.getInt("id"));
					avaliacao.setNota(rs.getDouble("nota"));
					avaliacao.setComentario(rs.getString("comentario"));
					avaliacao.setDt_avaliacao(rs.getTimestamp("dt_avaliacao"));
					colaborador = new ColaboradorService();
					avaliacao.setColaborador(colaborador.carregar(rs.getInt("colaborador_id")));
					item = new ItemService();
					avaliacao.setItem(item.carregar(rs.getInt("item_id")));
					avaliacoes.add(avaliacao);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.unmodifiableList(avaliacoes);
	}
	
}