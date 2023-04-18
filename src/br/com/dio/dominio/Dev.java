package br.com.dio.dominio;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {

	private static final int TAMANHO_MINIMO_NOME = 2;
	
	private String nome;
	private Set<Conteudo> conteudoInscrito = new HashSet<>();
	private Set<Conteudo> conteudoConcluido = new HashSet<>();
	
	
	public void inscreverBootcamp(Bootcamp bootcamp) {
		this.conteudoInscrito.addAll(bootcamp.getConteudos());
		bootcamp.getDevsIncritos().add(this);
	}
	
	public void progredir() {
		Optional<Conteudo> conteudo = this.conteudoInscrito.stream().findFirst();
		if(conteudo.isPresent()) {
			this.conteudoConcluido.add(conteudo.get());
			this.conteudoInscrito.remove(conteudo.get());
		}else {
			System.err.println("Você não está matriculado em nenhum inscrito");
		}
	}
	
	public double calacularXp() {
		return this.conteudoConcluido
				.stream()
				.mapToDouble(Conteudo::calcularXp)
				.sum();
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if(nome.isEmpty() || nome.length() <= TAMANHO_MINIMO_NOME) {
			throw new IllegalArgumentException("Nome deve conter 3 ou"
											 + " mais caracteres");
		}
		this.nome = nome;
	}
	
	public Set<Conteudo> getConteudoInscrito() {
		return conteudoInscrito;
	}
	
	public void setConteudoInscrito(Set<Conteudo> conteudoInscrito) {
		this.conteudoInscrito = conteudoInscrito;
	}
	
	public Set<Conteudo> getConteudoConcluido() {
		return conteudoConcluido;
	}
	
	public void setConteudoConcluido(Set<Conteudo> conteudoConcluido) {
		this.conteudoConcluido = conteudoConcluido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conteudoConcluido, conteudoInscrito, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dev other = (Dev) obj;
		return Objects.equals(conteudoConcluido, other.conteudoConcluido)
				&& Objects.equals(conteudoInscrito, other.conteudoInscrito) && Objects.equals(nome, other.nome);
	}
	
}
