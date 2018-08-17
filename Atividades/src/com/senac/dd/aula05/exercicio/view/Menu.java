package com.senac.dd.aula05.exercicio.view;

import java.util.ArrayList;

import com.senac.dd.aula05.exercicio.dao.ProdutoDAO;
import com.senac.dd.aula05.exercicio.vo.Produto;

public class Menu {

	public static void main(String[] args) {
		
		//System.out.println("ola");
		
		//Produto produto = new Produto("Coca-Cola zERO", "Coca-Cola", 5, 1);
		//produto.setId(3);
		
		ProdutoDAO produtoDao = new ProdutoDAO();				
		//produtoDao.inserirProduto(produto);
		//produtoDao.atualizar(produto);
		
		
		//ArrayList<Produto> produtos =  produtoDao.listarTodos();
		//System.out.print("\n--------- RESULTADO DA CONSULTA ---------");
		//System.out.printf("\n%3s   %-20s   %-30s \n", "ID", "NOME", "FABRICANTE");
		//for(int i = 0; i < produtos.size(); i++){
		//	System.out.println(produtos.get(i));
		//}
	}

}
