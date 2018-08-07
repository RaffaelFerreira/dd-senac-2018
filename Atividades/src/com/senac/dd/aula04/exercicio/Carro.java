package com.senac.dd.aula04.exercicio;

public class Carro extends Veiculo {
	
	private double portamala;	

	public Carro(int roda, String combustivel, double potencia, double tanque, String marca, String modelo, int ano,
			double portamala) {
		super(roda, combustivel, potencia, tanque, marca, modelo, ano);
		this.portamala = portamala;
	}
	
	public Carro( ) {
		
	}

	public double getPortamala() {
		return portamala;
	}

	public void setPortamala(double portamala) {
		this.portamala = portamala;
	}
	
	public void passear() {
		System.out.println("Passeando");
	}

}
