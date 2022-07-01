package Repositories;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Entities.Pessoa;
import Repositories.Shared.IRepository;

public class PessoaRepository implements IRepository<Pessoa> {

    @Override
	public void Insert(Pessoa p) {
    	Conexao connection = new Conexao();
		var sql = new StringBuilder();
		sql.append("INSERT INTO PESSOA(cpf, nome, datanascimento, enderecoid) ");
		sql.append("VALUES ('"+ p.getCpf() +"', '"+ p.getNome() +"', '"+ p.getDataNascimento() +"', '"+ p.getEnderecoId() +"')");
		
		var query = String.format(sql.toString(), p.getCpf(), p.getNome(), p.getDataNascimento(), p.getEnderecoId());
		
		System.out.println(sql.toString());
		try {
			connection.AlterandoDadosSQL(sql.toString());
		}
		catch(Exception ex) {
			ex.getMessage();
		}
		
	}

	@Override
	public void Update(Pessoa p, String identificador) {
    	Conexao connection = new Conexao();

		var sql = new StringBuilder();
		sql.append("UPDATE Pessoa");
		sql.append(" SET nome = '"+ p.getNome() +"', datanascimento = '"+ p.getDataNascimento() +"', enderecoid = " + p.getEnderecoId());
		sql.append(" WHERE cpf = '"+ p.getCpf() +"'");
		
		System.out.println(sql.toString());
		try {
			connection.Update(sql.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}

	@Override
	public boolean Remove(String identificador) {
    	Conexao connection = new Conexao();

		var sql = new StringBuilder("DELETE FROM Pessoa WHERE cpf = '%s'");
		var query = String.format(sql.toString(), identificador);
		
		System.out.println(query);
		
		try {
			connection.AlterandoDadosSQL(query);
		} catch (Exception ex) {
			ex.getMessage();
		}
			return true;
	}	

	@Override
	public Pessoa Get(String identificador) {
    	Conexao connection = new Conexao();

		var sql = new StringBuilder("SELECT * FROM Pessoa WHERE Cpf = '%s'");
		var query = String.format(sql.toString(), identificador);
		var pessoa = new Pessoa();
		try {
			ResultSet result = connection.Buscar(query);
			while(result.next()) {
				pessoa.setCpf(result.getString("cpf"));
				pessoa.setNome(result.getString("nome"));
				pessoa.setDataNascimento(result.getDate("datanascimento"));
				pessoa.setEnderecoId(result.getInt("enderecoid"));
			}
		} catch (Exception ex) {
			ex.getMessage();
		}			
		
		return pessoa;
	}
	
	public Pessoa GetByEndereco(String identificador) {
    	Conexao connection = new Conexao();

		var sql = new StringBuilder("SELECT * FROM Pessoa WHERE enderecoid = '%d'");
		var query = String.format(sql.toString(), Integer.parseInt(identificador));
		var pessoa = new Pessoa();
		try {
			ResultSet result = connection.Buscar(query);
			while(result.next()) {
				pessoa.setCpf(result.getString("cpf"));
				pessoa.setNome(result.getString("nome"));
				pessoa.setDataNascimento(result.getDate("datanascimento"));
				pessoa.setEnderecoId(result.getInt("enderecoid"));
			}
		} catch (Exception ex) {
			ex.getMessage();
		}			
		
		return pessoa;
	}

	@Override
	public List<Pessoa> GetAll() {
    	Conexao connection = new Conexao();

		var sql = new StringBuilder("SELECT * FROM Pessoa");
		var pessoas = new ArrayList<Pessoa>();
		
		try {
			ResultSet result = connection.Buscar(sql.toString());
			while(result.next()) {
				var pessoa = new Pessoa();
				
				pessoa.setCpf(result.getString("cpf"));
				pessoa.setNome(result.getString("nome"));
				pessoa.setDataNascimento(result.getDate("datanascimento"));
				pessoa.setEnderecoId(result.getInt("enderecoid"));
				
				pessoas.add(pessoa);
			}
			
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return pessoas;
	}

}
