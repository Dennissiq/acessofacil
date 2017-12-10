package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Categoria;
import model.Estabelecimento;
import service.CategoriaService;

public class EstabelecimentoDAO {
	private static int totalRecords;
	
	public int criar(Estabelecimento estabelecimento) {
		String sqlInsert = "INSERT INTO pi4semestre.estabelecimentos (nome, logradouro, bairro, cidade, cep, categoria_id, numero, uf) values (?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, estabelecimento.getNome());
			stm.setString(2, estabelecimento.getLogradouro());
			stm.setString(3, estabelecimento.getBairro());
			stm.setString(4, estabelecimento.getCidade());
			stm.setString(5, estabelecimento.getCep());
			Categoria categoria = estabelecimento.getCategoria();
			stm.setInt(6, categoria.getId());
			stm.setString(7, estabelecimento.getNumero());
			stm.setString(8, estabelecimento.getUf());
			stm.execute();
			String sqlLastId = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlLastId); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					estabelecimento.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			
			if(e2.getMessage().contains("nome_UNIQUE")) {
				return -1919;
			}
		}
		return estabelecimento.getId();
	}

	public Estabelecimento carregar(int id) {
		Estabelecimento estabelecimento = new Estabelecimento();
		estabelecimento.setId(id);
		String sqlSelect = "SELECT nome, logradouro, numero, bairro, cidade, uf, cep, categoria_id FROM pi4semestre.estabelecimentos WHERE estabelecimentos.id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setInt(1, estabelecimento.getId());
			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					estabelecimento.setNome(rs.getString("nome"));
					estabelecimento.setLogradouro(rs.getString("logradouro"));
					estabelecimento.setBairro(rs.getString("bairro"));
					estabelecimento.setCidade(rs.getString("cidade"));
					estabelecimento.setCep(rs.getString("cep"));
					CategoriaService caService = new CategoriaService();
					estabelecimento.setCategoria(caService.carregar(rs.getInt("categoria_id")));
					estabelecimento.setNumero(rs.getString("numero"));
					estabelecimento.setUf(rs.getString("uf"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return estabelecimento;
	}
	
	public List<Estabelecimento> listarTodosEstabelecimentos(int offset, int nOfEstabelecimentos){
		Estabelecimento estabelecimento;
		CategoriaService categoria;
		ArrayList<Estabelecimento> estabelecimentos = new ArrayList<>();
		String sqlSelect = "SELECT SQL_CALC_FOUND_ROWS e.id, nome, logradouro, numero, bairro, cidade, uf, cep, categoria_id, a.id, estabelecimento_id, ROUND(avg(a.nota), 1) as nota " +
						   "FROM pi4semestre.estabelecimentos e " +
						   "LEFT JOIN pi4semestre.avaliacoes a ON a.estabelecimento_id = e.id " +
						   "GROUP BY e.id " +
						   "ORDER BY nota DESC, nome ASC " +
						   "LIMIT " + offset + ", " + nOfEstabelecimentos;		
		try (Connection conn = ConnectionFactory.obtemConexao();PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try {
				ResultSet rs = stm.executeQuery();
				while (rs.next()) {
					estabelecimento = new Estabelecimento();
					estabelecimento.setNome(rs.getString("nome"));
					estabelecimento.setLogradouro(rs.getString("logradouro"));
					estabelecimento.setBairro(rs.getString("bairro"));
					estabelecimento.setCidade(rs.getString("cidade"));
					estabelecimento.setCep(rs.getString("cep"));
					estabelecimento.setNumero(rs.getString("numero"));
					estabelecimento.setUf(rs.getString("uf"));
					estabelecimento.setId(rs.getInt("id"));
					estabelecimento.setNotaMedia(rs.getDouble("nota"));
					categoria = new CategoriaService();
					estabelecimento.setCategoria(categoria.carregar(rs.getInt("categoria_id")));
					estabelecimentos.add(estabelecimento);
				}
				rs.close();
				rs = stm.executeQuery("SELECT FOUND_ROWS()");
				if(rs.next()) {
					EstabelecimentoDAO.totalRecords = rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		} 
		
		return Collections.unmodifiableList(estabelecimentos);
	}
	
	public static int getNOfEstabelecimentos() {
		return totalRecords;
	}
	
	public List<Estabelecimento> listarEstabelecimentos(String chave){
		Estabelecimento estabelecimento;
		CategoriaService categoria;
		ArrayList<Estabelecimento> estabelecimentos = new ArrayList<>();
		
		//String sqlSelect = "SELECT id, nome, logradouro, numero, bairro, cidade, uf, cep, categoria_id FROM pi4semestre.estabelecimentos WHERE upper(nome) like ?";
		String sqlSelect = "SELECT e.id, nome, logradouro, numero, bairro, cidade, uf, cep, categoria_id, a.id, estabelecimento_id, ROUND(avg(a.nota), 1) as nota " +
				   "FROM pi4semestre.estabelecimentos e " +
				   "LEFT JOIN pi4semestre.avaliacoes a ON a.estabelecimento_id = e.id " +
				   "WHERE upper(nome) like ? " +
				   "GROUP BY e.id " +
				   "ORDER BY nota DESC";
		try (Connection conn = ConnectionFactory.obtemConexao();PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					estabelecimento = new Estabelecimento();
					estabelecimento.setNome(rs.getString("nome"));
					estabelecimento.setLogradouro(rs.getString("logradouro"));
					estabelecimento.setBairro(rs.getString("bairro"));
					estabelecimento.setCidade(rs.getString("cidade"));
					estabelecimento.setCep(rs.getString("cep"));
					estabelecimento.setNumero(rs.getString("numero"));
					estabelecimento.setUf(rs.getString("uf"));
					estabelecimento.setId(rs.getInt("id"));
					categoria = new CategoriaService();
					estabelecimento.setCategoria(categoria.carregar(rs.getInt("categoria_id")));
					estabelecimento.setNotaMedia(rs.getDouble("nota"));
					estabelecimentos.add(estabelecimento);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		} 	
		return Collections.unmodifiableList(estabelecimentos);
	}
}