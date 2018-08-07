package com.senac.dd.aula04.exercicio;

public class Caminhao extends Veiculo {
	
	private int eixos;	

	public Caminhao(int roda, String combustivel, double potencia, double tanque, String marca, String modelo, int ano,
			int eixos) {
		super(roda, combustivel, potencia, tanque, marca, modelo, ano);
		this.eixos = eixos;
	}
	
	public Caminhao() {
		
	}

	public int getEixos() {
		return eixos;
	}

	public void setEixos(int eixos) {
		this.eixos = eixos;
	}
	
	public void carregar() {
		System.out.println("Carregando");
	}
	
	public void descarregar(){
		System.out.println("Descarregando");
	}
	

}
