package br.com.dio.dominio;

public class Curso extends Conteudo{
	
	private static final int MINIMO_HORAS = 1;
	
	private int cargaHoraria;
	
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	
	public void setCargaHoraria(int cargaHoraria) {
		if(cargaHoraria < MINIMO_HORAS) {
			throw new IllegalArgumentException("Carga horaria deve "
											 + "ser mair ou igual a 1 hora"); 
		}
		this.cargaHoraria = cargaHoraria;
	}
	
	@Override
	public double calcularXp() {
		return XP_PADRAO * this.cargaHoraria;
	}
	
	@Override
	public String toString() {
		return "Curso [titulo=" + titulo + ", descricao=" + descricao + ", cargaHoraria=" + cargaHoraria + "]";
	}

}
