package br.com.dio.dominio;

public abstract class Conteudo {

	protected static final int TAMANHO_MINIMO = 3; 
	
	protected static final double XP_PADRAO = 10d;
	protected String titulo;
	protected String descricao;
	
	public abstract double calcularXp();

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if(titulo.isEmpty() || titulo.length() < TAMANHO_MINIMO) {
			throw new IllegalArgumentException("Titutlo deve conter 3 ou mais letras");
		}
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		if(descricao.isEmpty() || descricao.length() < TAMANHO_MINIMO) {
			throw new IllegalArgumentException("Descrição deve conter mais de 3 letras");
		}
		this.descricao = descricao;
	}
	
}
