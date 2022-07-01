package Repositories;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Entities.Endereco;
import Repositories.Shared.IRepository;

public class EnderecoRepository implements IRepository<Endereco> {
		
	@Override
	public void Insert(Endereco e) {
		Conexao connection = new Conexao();

		var query = new StringBuilder();
		query.append("INSERT INTO Endereco");
		query.append("(estado, cidade, bairro, logradouro, numero, cep)");
		query.append("VALUES ('%s', '%s', '%s', '%s', %d, '%s');");
		
		var queryInsert = String.format(query.toString(),
						  e.getEstado(),
						  e.getCidade(),
						  e.getBairro(),
						  e.getLogradouro(),
						  e.getNumero(),
						  e.getCep());
		
		System.out.println(queryInsert);		
		try {
			connection.AlterandoDadosSQL(queryInsert);
		}
		catch(Exception ex) {
			ex.getMessage();
		}
	}

	@Override
	public void Update(Endereco e, String identificador) {
		Conexao c = new Conexao();
		var query = new StringBuilder();
		
		query.append("UPDATE Endereco");
		query.append(" SET estado = '%s', cidade = '%s',  bairro = '%s', logradouro = '%s', numero = %d, cep= '%s'");
		query.append(" WHERE Id = %s");
		
		var queryUpdate = String.format(query.toString(), 
						  e.getEstado(), 
						  e.getCidade(), 
						  e.getBairro(), 
						  e.getLogradouro(), 
						  e.getNumero(), 
						  e.getCep(), 
						  identificador);	
		System.out.println(queryUpdate);

		try {
			c.Update(queryUpdate);
		} catch (Exception ex) {
			ex.getMessage();
		}		
	}

	@Override
	public boolean Remove(String identificador) {		
		Conexao c = new Conexao();

		var query = new StringBuilder("DELETE FROM Endereco WHERE Id = %d");
		var queryDelete = String.format(query.toString(), Integer.parseInt(identificador));
		System.out.println(queryDelete);
		try {
			c.AlterandoDadosSQL(queryDelete);
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return false;
	}

	@Override
	public Endereco Get(String identificador) {
		Conexao c = new Conexao();

		var query = new StringBuilder("SELECT * FROM Endereco WHERE Id = %d");
		var queryGet = String.format(query.toString(), Integer.parseInt(identificador));
		var endereco = new Endereco();
		
		System.out.println(queryGet);		
		try {
			ResultSet result = c.Buscar(queryGet.toString());
			while(result.next()) {			
				endereco.setId(result.getInt("id"));
				endereco.setEstado(result.getString("estado"));
				endereco.setCidade(result.getString("cidade"));
				endereco.setBairro(result.getString("bairro"));
				endereco.setLogradouro(result.getString("logradouro"));
				endereco.setNumero(result.getInt("numero"));
				endereco.setCep(result.getString("cep"));	
			}
		} catch (Exception ex) {
			ex.getMessage();
		}			
		
		return endereco;
	}

	@Override
	public List<Endereco> GetAll() {
		Conexao connection = new Conexao();

		var query = new StringBuilder("SELECT * FROM Endereco order by id");
		var enderecos = new ArrayList<Endereco>();
		
		try {
			ResultSet result = connection.Buscar(query.toString());
			while(result.next()) {
				var endereco = new Endereco();
				
				endereco.setId(result.getInt("id"));
				endereco.setEstado(result.getString("estado"));
				endereco.setCidade(result.getString("cidade"));
				endereco.setBairro(result.getString("bairro"));
				endereco.setLogradouro(result.getString("logradouro"));
				endereco.setNumero(result.getInt("numero"));
				endereco.setCep(result.getString("cep"));
				
				enderecos.add(endereco);
			}
			
		} catch (Exception ex) {
			ex.getMessage();
		}		
		
		return enderecos;
	}

}
