package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Categoria;

public class CategoriaDAO {
	public Categoria carregar(int id) {
		Categoria categoria = new Categoria();
		categoria.setId(id);
		String sqlSelect = "SELECT nome FROM pi4semestre.categorias WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setInt(1, categoria.getId());
			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					categoria.setNome(rs.getString("nome"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoria;
	}
	
	public List<Categoria> listarCategorias() {
		List<Categoria> categorias = new ArrayList<>();
		String sqlSelect = "SELECT id, nome FROM pi4semestre.categorias";
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect)){
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Categoria categoria = new Categoria();
					categoria.setId(rs.getInt("id"));
					categoria.setNome(rs.getString("nome"));
					categorias.add(categoria);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.unmodifiableList(categorias);
	}
}
