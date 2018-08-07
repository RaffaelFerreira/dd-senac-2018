package com.senac.dd.aula04.exercicio;

public class Principal {

	public static void main(String[] args) {
		
		Carro carro = new Carro(4, "Gasolina", 90, 45, "Fiat", "Palio",2003, 30);
		
		System.out.println("Carro");
		carro.acelera();
		carro.freia();
		carro.abastecer(20);
		System.out.println("\n");
		
		Caminhao caminhao = new Caminhao(10,"Disel",200, 100, "Autobot", "Optimus Prime", 2010,2);
		
		System.out.println("Caminhão");
		caminhao.acelera();
		caminhao.freia();
		caminhao.abastecer(50);
		caminhao.carregar();
		caminhao.descarregar();
		System.out.println("\n");
		
		Moto moto = new Moto(2, "Gasolina", 300, 15, "Honda", "Biz", 2010);
		
		System.out.println("Moto");
		moto.acelera();
		moto.freia();
		moto.abastecer(10);
		moto.empinar();
		System.out.println("\n");
		
		
		
		

	}

}
