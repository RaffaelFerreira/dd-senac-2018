package com.senac.dd.aula05.exercicio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.SQLException;

import com.senac.dd.aula05.exercicio.vo.Produto;

public class ProdutoDAO {
	
	public void inserirProduto(Produto p) {
		
		String sql = "INSERT INTO produto(nome, fabricante, valor, peso) VALUES (?, ?, ?, ?)";
		
		Connection conn = Conexao.getConnection();
		PreparedStatement stmt = Conexao.getPreparedStatement(conn, sql);		
		
		try {
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getFabricante());
			stmt.setDouble(3, p.getValor());
			stmt.setDouble(4, p.getPeso());			
			stmt.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
			
		} finally {
			Conexao.closePreparedStatement(stmt);
			Conexao.closeConnection(conn);
		}
	}
	
	public boolean atualizar(Produto p){
		boolean sucessoUpdate = false;

		String sql = " UPDATE PRODUTO SET nome=?, fabricante=?, valor=?, peso=? "
				+ " WHERE id = ? ";

		Connection conexao = Conexao.getConnection();
		PreparedStatement stmt = Conexao.getPreparedStatement(conexao, sql);

		try {
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getFabricante());
			stmt.setDouble(3, p.getValor());
			stmt.setDouble(4, p.getPeso());
			stmt.setDouble(5, p.getId());

			int codigoRetorno = stmt.executeUpdate();

			if(codigoRetorno == 1){
				sucessoUpdate = true;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar produto");
		}finally{
			Conexao.closePreparedStatement(stmt);
			Conexao.closeConnection(conexao);
		}

		return sucessoUpdate;
	}
	
	public boolean remover(int id){
		boolean sucessoDelete = false;

		String sql = " DELETE FROM PRODUTO "
				+ " WHERE ID = ? ";

		Connection conexao = Conexao.getConnection();
		PreparedStatement Stmt = Conexao.getPreparedStatement(conexao, sql);

		try {
			Stmt.setInt(1, id);

			int codigoRetorno = Stmt.executeUpdate();

			if(codigoRetorno == 1){ //1 - sucesso na execução
				sucessoDelete = true;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao remover produto. Id = " + id);
		}finally{
			Conexao.closePreparedStatement(Stmt);
			Conexao.closeConnection(conexao);
		}
		return sucessoDelete;
	}
	
	public ArrayList<Produto> listarTodos(){
		String sql = " SELECT * FROM PRODUTO ";
		
		Connection conexao = Conexao.getConnection();
		PreparedStatement Stmt = Conexao.getPreparedStatement(conexao, sql);
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		
		try {
			ResultSet result = Stmt.executeQuery(sql);
			
			while(result.next()){
				Produto p = new Produto();
				
				//Obtendo valores pelo NOME DA COLUNA
				p.setId(result.getInt("id"));
				p.setNome(result.getString("nome"));
				p.setFabricante(result.getString("fabricante"));
				
				//Outra forma de obter (POSICIONAL)
				//p.setValor(result.getDouble(4));
				//p.setPeso(result.getDouble(5));
				produtos.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produtos;
	}
	
	public Produto obterPorId(int id){
		String sql = " SELECT * FROM PRODUTO "
				+ " WHERE ID=?";
		
		Connection conexao = Conexao.getConnection();
		PreparedStatement stmt = Conexao.getPreparedStatement(conexao, sql);
		Produto p = null;
		
		try {
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			
			while(result.next()){
				p = new Produto();
				
				//Obtendo valores pelo NOME DA COLUNA
				p.setId(result.getInt("ID"));
				p.setNome(result.getString("NOME"));
				p.setFabricante(result.getString("FABRICANTE"));
				
				//Outra forma de obter (POSICIONAL)
				p.setValor(result.getDouble(4));
				p.setPeso(result.getDouble(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	
}
