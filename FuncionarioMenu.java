package com.senac.dd.aula05.exercicio.view;

import javax.swing.JOptionPane;

import com.senac.dd.aula05.exercicio.dao.FuncionarioDAO;
import com.senac.dd.aula05.exercicio.vo.Funcionario;

public class FuncionarioMenu {

	private static final int OPCAO_SAIR = 5;
	private static final int OPCAO_CADASTRAR_FUNCIONARIO = 1;
	private static final int OPCAO_CONSULTAR_FUNCIONARIO = 2;
	private static final int OPCAO_ATUALIZAR_FUNCIONARIO = 3;
	private static final int OPCAO_EXCLUIR_FUNCIONARIO = 4;
	private static final int OPCAO_SAIR_MENU_CONSULTA = 3;
	private static final int OPCAO_CONSULTA_TODOS_FUNCIONARIOS = 1;
	private static final int OPCAO_CONSULTA_FUNCIONARIOS_PORID = 2;

	Funcionario funcionario = new Funcionario();

	public void apresentaMenuFuncionario() {

		try {

			int opcaoMenu = -1;

			while (opcaoMenu != OPCAO_SAIR) {

				String mensagemMenu = construirMenuFuncionario();
				String opcao = JOptionPane.showInputDialog(null, mensagemMenu, "Título",
						JOptionPane.INFORMATION_MESSAGE);
				opcaoMenu = Integer.parseInt(opcao);

				switch (opcaoMenu) {
				case OPCAO_CADASTRAR_FUNCIONARIO:
					cadastrarFuncionario();
					break;

				case OPCAO_CONSULTAR_FUNCIONARIO:
					consultarFuncionario();
					break;

				case OPCAO_ATUALIZAR_FUNCIONARIO:
					atualizarFuncionario();
					break;

				case OPCAO_EXCLUIR_FUNCIONARIO:
					excluirFuncionario();
					break;

				case OPCAO_SAIR:
					break;

				default:
					break;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void excluirFuncionario() {
		// TODO Auto-generated method stub

	}

	private void atualizarFuncionario() {
		// TODO Auto-generated method stub

	}

	private void consultarFuncionario() {

		try {
			int opcaoMenuConsulta = 0;

			while (opcaoMenuConsulta != OPCAO_SAIR_MENU_CONSULTA) {

				String mensagemMenu = construirMenuConsultaFuncionario();
				String opcao = JOptionPane.showInputDialog(null, mensagemMenu, "Título",
						JOptionPane.INFORMATION_MESSAGE);
				opcaoMenuConsulta = Integer.parseInt(opcao);

				switch (opcaoMenuConsulta) {

				case OPCAO_CONSULTA_TODOS_FUNCIONARIOS:

					FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

					for (Funcionario f : funcionarioDAO.listarTodos()) {

						JOptionPane.showMessageDialog(null,
								"ID FUNCIONÁRIO: " + f.getIdFuncionario() + "NOME: " + f.getNome() + "CPF : "
										+ f.getCpf() + "NÚMERO DE MATRICULA: " + f.getMatricula());
					}
					break;

				case OPCAO_CONSULTA_FUNCIONARIOS_PORID:
					FuncionarioDAO funcinarioDAO = new FuncionarioDAO();

					break;

				case OPCAO_SAIR_MENU_CONSULTA:
					break;

				default:
					JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA!");
					;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void cadastrarFuncionario() {
		// TODO Auto-generated method stub

		funcionario.setNome(JOptionPane.showInputDialog("Nome do funcionário: "));
		funcionario.setCpf(JOptionPane.showInputDialog("CPF: "));
		funcionario.setMatricula(JOptionPane.showInputDialog("Número da matricula: "));

		FuncionarioDAO funcionariodao = new FuncionarioDAO();
		funcionariodao.inserirFuncionario(funcionario);

	}

	private String construirMenuFuncionario() {

		String mensagem = "Menu Funcionario";
		mensagem += "\n [1] - Cadastrar Funcionário";
		mensagem += "\n [2] - Consultar Funcionário";
		mensagem += "\n [3] - Atualizar Funcionário";
		mensagem += "\n [4] - Excluir Funcionário";
		mensagem += "\n [5] - Sair";

		return mensagem;
	}

	public String construirMenuConsultaFuncionario() {

		String mensagem = " Menu Consulta Funcionário";
		mensagem += "\n [1] - Consultar todos os funcionarios";
		mensagem += "\n [2] - Consultar Funcionarios por ID ";
		mensagem += "\n [3] - SAIR";

		return mensagem;
	}

}
