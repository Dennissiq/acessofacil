package service;

import java.util.List;

import dao.ItemDAO;
import model.Item;

public class ItemService {
	ItemDAO dao = new ItemDAO();
	
	public Item carregar(int id) {
		return dao.carregar(id);
	}
	
	public List<Item> listarItens() {
		return dao.listarItens();
	}
}
