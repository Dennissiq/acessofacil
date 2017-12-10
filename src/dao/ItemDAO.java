package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Item;

public class ItemDAO {
	public Item carregar(int id) {
		Item item = new Item();
		item.setId(id);
		String sqlSelect = "SELECT nome FROM pi4semestre.itens WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setInt(1, item.getId());
			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					item.setNome(rs.getString("nome"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}
	
	public List<Item> listarItens() {
		List<Item> itens = new ArrayList<>();
		Item item;
		String sqlSelect = "SELECT id, nome FROM pi4semestre.itens";
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					item = new Item();
					item.setId(rs.getInt("id"));
					item.setNome(rs.getString("nome"));
					itens.add(item);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return Collections.unmodifiableList(itens);
	}
}
