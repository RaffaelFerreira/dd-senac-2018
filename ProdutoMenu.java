package com.senac.dd.aula05.exercicio.view;

import javax.swing.JOptionPane;

import com.senac.dd.aula05.exercicio.dao.ProdutoDAO;
import com.senac.dd.aula05.exercicio.vo.Produto;

public class ProdutoMenu {

	private static final int OPCAO_SAIR = 5;
	private static final int OPCAO_CADASTRAR_PRODUTO = 1;
	private static final int OPCAO_CONSULTAR_PRODUTO = 2;
	private static final int OPCAO_ATUALIZAR_PRODUTO = 3;
	private static final int OPCAO_EXCLUIR_PRODUTO = 4;
	private static final int OPCAO_SAIR_MENU_CONSULTA = 3;
	private static final int OPCAO_CONSULTA_TODOS_FUNCIONARIOS = 1;
	private static final int OPCAO_CONSULTA_FUNCIONARIOS_PORID = 2;

	Produto produto = new Produto();

	public void apresentaMenuProduto() {

		try {

			int opcaoMenu = -1;

			while (opcaoMenu != OPCAO_SAIR) {

				String mensagemMenu = construirMenuProduto();
				String opcao = JOptionPane.showInputDialog(null, mensagemMenu, "Título",
						JOptionPane.INFORMATION_MESSAGE);
				opcaoMenu = Integer.parseInt(opcao);

				switch (opcaoMenu) {
				case OPCAO_CADASTRAR_PRODUTO:
					cadastrarProduto();
					break;
				case OPCAO_CONSULTAR_PRODUTO:
					consultarProduto();
					break;
				case OPCAO_ATUALIZAR_PRODUTO:
					atualizarProduto();
					break;
				case OPCAO_EXCLUIR_PRODUTO:
					excluiurProduto();
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

	private void cadastrarProduto() {
		// TODO Auto-generated method stub

		produto.setNome(JOptionPane.showInputDialog("Nome do produto: "));
		produto.setFabricante(JOptionPane.showInputDialog("Fabricante: "));
		produto.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Peso do produto: ")));
		produto.setValor(Double.parseDouble(JOptionPane.showInputDialog("Valor do produto: ")));

		ProdutoDAO produtodao = new ProdutoDAO();
		produtodao.inserirProduto(produto);

	}

	private void excluiurProduto() {
		// TODO Auto-generated method stub

	}

	private void atualizarProduto() {
		// TODO Auto-generated method stub

	}

	private void consultarProduto() {

		try {
			int opcaoMenuConsulta = 0;

			while (opcaoMenuConsulta != OPCAO_SAIR_MENU_CONSULTA) {

				String mensagemMenu = construirMenuConsultaProduto();
				String opcao = JOptionPane.showInputDialog(null, mensagemMenu, "Título",
						JOptionPane.INFORMATION_MESSAGE);
				opcaoMenuConsulta = Integer.parseInt(opcao);

				switch (opcaoMenuConsulta) {

				case OPCAO_CONSULTA_TODOS_FUNCIONARIOS:

					ProdutoDAO produtoDAO = new ProdutoDAO();

					for (Produto p : produtoDAO.listarTodos()) {

						JOptionPane.showMessageDialog(null,
								"ID PRODUTO: " + p.getId() + "NOME: " + p.getNome() + "FABRICANTE : "
										+ p.getFabricante() + "PESO : " + p.getPeso() + "VALOR: " + p.getValor());
					}
					break;

				case OPCAO_CONSULTA_FUNCIONARIOS_PORID:
					ProdutoDAO produtodao = new ProdutoDAO();

					break;

				case OPCAO_SAIR_MENU_CONSULTA:
					break;

				default:
					JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA!");
					;
				}
			}
		} catch (Exception e) {

		}
		// TODO: handle exception
	}

	private String construirMenuProduto() {

		String mensagem = "Menu Produto";
		mensagem += "\n [1] - Cadastrar Produto";
		mensagem += "\n [2] - Consultar Produto";
		mensagem += "\n [3] - Atualizar Produto";
		mensagem += "\n [4] - Excluir Produto";
		mensagem += "\n [5] - Sair";

		return mensagem;
	}

	public String construirMenuConsultaProduto() {

		String mensagem = " Menu Consulta Produto";
		mensagem += "\n [1] - Consultar todos os produtos";
		mensagem += "\n [2] - Consultar produto por ID ";
		mensagem += "\n [3] - SAIR";

		return mensagem;
	}

}
