package com.senac.dd.aula04.exercicio;

public class Moto extends Veiculo {
	
	public Moto(int roda, String combustivel, double potencia, double tanque, String marca, String modelo, int ano) {
		super();
		this.roda = roda;
		this.combustivel = combustivel;
		this.potencia = potencia;
		this.tanque = tanque;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
	}
	
	public Moto() {
		
	}	
	
	public void empinar() {
		System.out.println("Empinando");
	}

}
