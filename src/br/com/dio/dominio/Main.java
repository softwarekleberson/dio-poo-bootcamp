package br.com.dio.dominio;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		
		Curso curso1 = new Curso();
		curso1.setTitulo("Poo");
		curso1.setDescricao("Avançado, curso indicado para seniors");
		curso1.setCargaHoraria(2);
		System.out.println(curso1.toString());
		
		Mentoria mentoria1 = new Mentoria();
		mentoria1.setTitulo("Dio ensina programação");
		mentoria1.setDescricao("para todas as pessoas");
		mentoria1.setData(LocalDate.now());
		
		Curso curso2 = new Curso();
		curso2.setTitulo("Modelagem dados");
		curso2.setDescricao("modele banco relacional");
		curso2.setCargaHoraria(2);
		
		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("DIO");
		bootcamp.setDescricao("Parceria com o Banco Inter");
		bootcamp.getConteudos().add(curso1);
		bootcamp.getConteudos().add(curso2);
		bootcamp.getConteudos().add(mentoria1);
		
		Dev devKleberson = new Dev();
		devKleberson.setNome("kleberson");
		devKleberson.inscreverBootcamp(bootcamp);
		System.out.println("Conteudos Inscritos" + devKleberson.getConteudoInscrito());
		devKleberson.progredir();
		devKleberson.progredir();
		System.out.println("Conteudos Concluidos" + devKleberson.getConteudoConcluido());
		System.out.println("Calculando xp " + devKleberson.calacularXp());
	}

}
