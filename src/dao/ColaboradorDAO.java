package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import model.Colaborador;

public class ColaboradorDAO {
	public int criar(Colaborador colaborador) {
		String sqlInsert = "INSERT INTO pi4semestre.colaboradores (username, email, nome, sobrenome, senha) VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert)){
			stm.setString(1, colaborador.getUsername());
			stm.setString(2, colaborador.getEmail());
			stm.setString(3, colaborador.getNome());
			stm.setString(4, colaborador.getSobrenome());
			stm.setString(5, colaborador.getSenha());
			stm.execute();
			String sqlLastId = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlLastId); 
					ResultSet rs = stm2.executeQuery()){
				if(rs.next()) {
					colaborador.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			
			if(e2.getMessage().contains("username_UNIQUE")) {
				return -1919;
			}
				return -9999;					
		}
		return colaborador.getId();
	}
	
	public Colaborador carregar(int id) {
		Colaborador colaborador = new Colaborador();
		colaborador.setId(id);
		String sqlSelect = "SELECT username, email, nome, sobrenome, senha FROM pi4semestre.colaboradores WHERE colaboradores.id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect)){
			stm.setInt(1, colaborador.getId());
			try (ResultSet rs = stm.executeQuery()){
				if(rs.next()){
					colaborador.setUsername(rs.getString("username"));
					colaborador.setEmail(rs.getString("email"));
					colaborador.setNome(rs.getString("nome"));
					colaborador.setSobrenome(rs.getString("sobrenome"));
					colaborador.setSenha(rs.getString("senha"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return colaborador;
	}
	
	public void atualizar(Colaborador colaborador) {
		String sqlUpdate = "UPDATE pi4semestre.colaboradores SET username=?, email=?, nome=?, sobrenome=?, senha=? WHERE colaboradores.id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate)){
			stm.setString(1, colaborador.getUsername());
			stm.setString(2, colaborador.getEmail());
			stm.setString(3, colaborador.getNome());
			stm.setString(4, colaborador.getSobrenome());
			stm.setString(5, colaborador.getSenha());
			stm.setInt(6, colaborador.getId());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Colaborador buscaPorEmailESenha(String email, String senha) {
		Colaborador colaborador = new Colaborador();
		String sqlSelect = "SELECT id, username, email, nome, sobrenome, senha FROM pi4semestre.colaboradores WHERE email=? AND senha=?";
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect)){
			stm.setString(1, email);
			stm.setString(2, senha);
			try (ResultSet rs = stm.executeQuery()){
				if(rs.next()) {
					colaborador.setId(rs.getInt("id"));
					colaborador.setUsername(rs.getString("username"));
					colaborador.setEmail(rs.getString("email"));
					colaborador.setNome(rs.getString("nome"));
					colaborador.setSobrenome(rs.getString("sobrenome"));
					colaborador.setSenha(rs.getString("senha"));
				} else {
					colaborador = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return colaborador;
	}

	public void softDelete(Colaborador colaborador) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		int hash = (int) timestamp.getTime();
		String sqlSelect = "UPDATE pi4semestre.colaboradores SET username = ?, email = ?, nome = ?, sobrenome = ?, senha = ? WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, hash + "__" + colaborador.getUsername());
			stm.setString(2, hash + "__" + colaborador.getEmail());
			stm.setString(3, "Usuário Excluído");
			stm.setString(4, "");
			stm.setString(5, colaborador.getSenha());
			stm.setInt(6, colaborador.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}