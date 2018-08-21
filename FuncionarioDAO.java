package com.senac.dd.aula05.exercicio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.senac.dd.aula05.exercicio.vo.Funcionario;
import com.senac.dd.aula05.exercicio.vo.Produto;

public class FuncionarioDAO {

	public void inserirFuncionario(Funcionario f) {
		
		String sql = "INSERT INTO funcionario(nome, matricula, cpf) VALUES (?, ?, ?)";

		Connection conn = Conexao.getConnection();
		PreparedStatement stmt = Conexao.getPreparedStatement(conn, sql);

		try {
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getMatricula());
			stmt.setString(3, f.getCpf());
			
			stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();

		} finally {
			Conexao.closePreparedStatement(stmt);
			Conexao.closeConnection(conn);
		}
	}

	public boolean atualizar(Funcionario f) {
		boolean sucessoUpdate = false;

		String sql = " UPDATE funcionario SET nome=?, matricula=?, cpf=?, " + " WHERE id = ? ";

		Connection conexao = Conexao.getConnection();
		PreparedStatement stmt = Conexao.getPreparedStatement(conexao, sql);

		try {
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getMatricula());
			stmt.setString(3, f.getCpf());
			stmt.setDouble(4, f.getIdFuncionario());
			

			int codigoRetorno = stmt.executeUpdate();

			if (codigoRetorno == 1) {
				sucessoUpdate = true;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar produto");
		} finally {
			Conexao.closePreparedStatement(stmt);
			Conexao.closeConnection(conexao);
		}

		return sucessoUpdate;
	}

	public boolean remover(int id) {
		boolean sucessoDelete = false;

		String sql = " DELETE FROM funcionario " + " WHERE ID = ? ";

		Connection conexao = Conexao.getConnection();
		PreparedStatement Stmt = Conexao.getPreparedStatement(conexao, sql);

		try {
			Stmt.setInt(1, id);

			int codigoRetorno = Stmt.executeUpdate();

			if (codigoRetorno == 1) { // 1 - sucesso na execução
				sucessoDelete = true;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao remover funcionario. Id = " + id);
		} finally {
			Conexao.closePreparedStatement(Stmt);
			Conexao.closeConnection(conexao);
		}
		return sucessoDelete;
	}

	public ArrayList<Funcionario> listarTodos() {
		String sql = " SELECT * FROM funcionario ";

		Connection conexao = Conexao.getConnection();
		PreparedStatement Stmt = Conexao.getPreparedStatement(conexao, sql);
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

		try {
			ResultSet result = Stmt.executeQuery(sql);

			while (result.next()) {
				Funcionario f = new Funcionario();

				// Obtendo valores pelo NOME DA COLUNA
				f.setIdFuncionario(result.getInt("id"));
				f.setNome(result.getString("nome"));
				f.setMatricula((result.getString("matricula")));
				f.setCpf(result.getString("cpf"));

				// Outra forma de obter (POSICIONAL)
				// p.setValor(result.getDouble(4));
				// p.setPeso(result.getDouble(5));
				funcionarios.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return funcionarios;
	}

	public Funcionario obterPorId(int id) {
		String sql = " SELECT * FROM funcionario " + " WHERE ID=?";

		Connection conexao = Conexao.getConnection();
		PreparedStatement stmt = Conexao.getPreparedStatement(conexao, sql);
		Funcionario f = null;

		try {
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				f = new Funcionario();

				// Obtendo valores pelo NOME DA COLUNA
				f.setIdFuncionario(result.getInt("id"));
				f.setNome(result.getString("nome"));
				f.setMatricula((result.getString("matricula")));
				f.setCpf(result.getString("cpf"));

				// Outra forma de obter (POSICIONAL)
				//p.setValor(result.getDouble(4));
				//p.setPeso(result.getDouble(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

}
