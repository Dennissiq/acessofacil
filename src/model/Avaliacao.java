package model;

import java.sql.Timestamp;

public class Avaliacao {
	private int id;
	private double nota;
	private String comentario;
	private Timestamp dt_avaliacao;
	private Estabelecimento estabelecimento;
	private Colaborador colaborador;
	private Item item;
	
	public Avaliacao() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Timestamp getDt_avaliacao() {
		return dt_avaliacao;
	}
	public void setDt_avaliacao(Timestamp dt_avaliacao) {
		this.dt_avaliacao = dt_avaliacao;
	}
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	public Colaborador getColaborador() {
		return colaborador;
	}
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}	
}
