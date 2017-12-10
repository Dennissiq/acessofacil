package model;

public class Estabelecimento implements Comparable<Estabelecimento> {
	private String nome, logradouro, bairro, cidade, cep, uf, numero;
	private int id;
	private double notaMedia;

	Categoria categoria;
	Avaliacao avaliacao;
	
	public Estabelecimento() {
	}

	public Estabelecimento(String nome, String logradouro, String bairro, String cidade, String cep, String uf, int id,
			String numero, Categoria categoria, Avaliacao avaliacao) {
		this.nome = nome;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.uf = uf;
		this.id = id;
		this.numero = numero;
		this.categoria = categoria;
		this.avaliacao = avaliacao;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String pNumero) {
		this.numero = pNumero;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}

	@Override
	public int compareTo(Estabelecimento o) {
		// implementar sort para media.
		return 0;
	}
}