package com.senac.dd.aula05.exercicio.vo;

public class Funcionario {	
	
	private String nome;
	private String Matricula;
	private String cpf;
	private int idFuncionario;	
	
	public Funcionario(String nome, String numeroMatricula, String cpf) {
		super();
		this.nome = nome;
		this.Matricula = numeroMatricula;
		this.cpf = cpf;
	}
	
	public Funcionario() {
		
	}
	
	public int getIdFuncionario() {
		return idFuncionario;
	}
	
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMatricula() {
		return Matricula;
	}
	
	public void setMatricula(String numeroMatricula) {
		this.Matricula = numeroMatricula;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
