package com.senac.dd.aula05.exercicio.view;

import javax.swing.JOptionPane;

public class PrincipalMenu {

	private static final int OPCAO_SAIR = 3;
	private static final int OPCAO_MENU_FUNCIONARIO = 1;
	private static final int OPCAO_MENU_PRODUTO = 2;

	public void apresentarMenuPrincipal() {

		try {

			int opcaoMenu = -1;

			while (opcaoMenu != OPCAO_SAIR) {

				String mensagemMenu = construirMenuPrincipal();
				String opcao = JOptionPane.showInputDialog(null, mensagemMenu, "Título",
						JOptionPane.INFORMATION_MESSAGE);
				opcaoMenu = Integer.parseInt(opcao);

				switch (opcaoMenu) {

				case OPCAO_MENU_FUNCIONARIO:
					FuncionarioMenu menuFuncionario = new FuncionarioMenu();
					menuFuncionario.apresentaMenuFuncionario();
					break;

				case OPCAO_MENU_PRODUTO:
					ProdutoMenu menuProduto = new ProdutoMenu();
					menuProduto.apresentaMenuProduto();
					break;

				case OPCAO_SAIR:
					JOptionPane.showMessageDialog(null, "SAINDO", "INFORMAÇÂO", JOptionPane.PLAIN_MESSAGE);
					break;
				default:
					mostrarMensagemOpcaoInvalida();
					apresentarMenuPrincipal();
					break;
				}
			}
			mostrarMensagemOpcaoInvalida();
		} catch (NumberFormatException ex) {
			// TODO tratar
		}
	}

	private void mostrarMensagemOpcaoInvalida() {
		// TODO Auto-generated method stub

	}

	private String construirMenuPrincipal() {

		String mensagem = "      Menu Principal    ";
		mensagem += "\n [1] - Menu Funcionário";
		mensagem += "\n [2] - Menu Produto";
		mensagem += "\n [3] - Sair";

		return mensagem;
	}

}
