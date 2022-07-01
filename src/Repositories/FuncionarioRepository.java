package Repositories;

import Repositories.Shared.IRepository;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Entities.Funcionario;

public class FuncionarioRepository implements IRepository<Funcionario> {	

	@Override
	public void Insert(Funcionario f) {
		Conexao connection = new Conexao();
		StringBuilder sb = new StringBuilder();
			
		if(f.getLoginSupervisor() == "")
			f.setLoginSupervisor(null);
		
		sb.append("	Insert into Funcionario");
		sb.append("(login, senha, ativo, salario, contratadodesde, loginsupervisor, cpfpessoa, cargoid)	");
		sb.append("	values('"+f.getLogin() +"', '"+f.getSenha() +"', '"+f.getAtivo() +"', '"+f.getSalario() +"', '"+f.getContratadoDesde() +"', '"+f.getLoginSupervisor() +"', '"+f.getPessoaCpf() +"', '"+f.getCargoId() +"')");

		String query = sb.toString().trim();
		
		System.out.println(query);		
		try {
			connection.AlterandoDadosSQL(sb.toString());
		}
		catch(Exception ex) {
			ex.getMessage();
		}		
	}

	@Override
	public void Update(Funcionario f, String identificador) {
		Conexao connection = new Conexao();
		StringBuilder sb = new StringBuilder();
			
		if(f.getLoginSupervisor() == "")
			f.setLoginSupervisor(null);
		
		sb.append("	Update funcionario set");
		sb.append(" login =	'" +f.getLogin()+ "'" + ",");
		sb.append(" senha ='" +	f.getSenha()+ "'" + ",");
		sb.append(" ativo  =" +	f.getAtivo()+ ",");
		sb.append(" salario =" +f.getSalario()+ ",");
		sb.append(" contratadodesde ='" +f.getContratadoDesde()+ "'" + ",");
		
		if(f.getLoginSupervisor() == null)
			sb.append("loginsupervisor" +f.getLoginSupervisor()+ "," );
		else
			sb.append(" loginsupervisor ='" +f.getLoginSupervisor()+ "'" + ",");		
		
		sb.append("cargoid ="+f.getCargoId());
		sb.append(" where login = '" + identificador + "';"); 

		String queryUpdate = sb.toString();
		
		System.out.println(queryUpdate);		
		try {
			connection.Update(queryUpdate);
		} catch (Exception ex) {
			ex.getMessage();
		}	
		
	}

	@Override
	public boolean Remove(String identificador) {
		Conexao connection = new Conexao();

		var query = new StringBuilder("DELETE FROM Funcionario WHERE login = '%s'");
		var queryDelete = String.format(query.toString(), identificador);
		
		System.out.println(queryDelete);
		
		try {
			connection.AlterandoDadosSQL(queryDelete);
			return true;
		} catch (Exception ex) {
			ex.getMessage();
			return false;
		}		
	}

	@Override
	public Funcionario Get(String identificador) {
		Conexao connection = new Conexao();

		var query = new StringBuilder("SELECT * FROM Funcionario WHERE Login = '%s'");
		var queryGet = String.format(query.toString(), identificador);
		Funcionario f = new Funcionario();
		
		try {
			ResultSet result = connection.Buscar(queryGet);
			while(result.next()) {
				f.setLogin(result.getString("login"));
				f.setSenha(result.getString("senha"));
				f.setAtivo(result.getBoolean("ativo"));
				f.setSalario(result.getDouble("salario"));
				f.setContratadoDesde(result.getDate("contratadodesde"));
				f.setLoginSupervisor(result.getString("loginsupervisor"));
				f.setPessoaCpf(result.getString("cpfpessoa"));
				f.setCargoId(result.getInt("cargoid"));
			}
		}catch(Exception ex){
			ex.getMessage();
		}
		return f;
	}

	@Override
	public List<Funcionario> GetAll() {
		Conexao connection = new Conexao();

		var query = new StringBuilder("SELECT \r\n"
				+ " f.login, \r\n"
				+ "f.senha, \r\n"
				+ "f.ativo, \r\n"
				+ "f.salario, \r\n"
				+ "f.contratadodesde, \r\n"
				+ "f.loginsupervisor, \r\n"
				+ "f.cpfpessoa, \r\n"
				+ "f.cargoid, \r\n"
				+ "p.nome, \r\n"
				+ "c.descricao \r\n"
				+ " FROM Funcionario f \r\n"
				+ " inner join Pessoa p on p.cpf = f.cpfpessoa\r\n"
				+ " inner join Cargo c on c.id = f.cargoid");
		
		ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
		
		try {
			ResultSet result = connection.Buscar(query.toString());
			while(result.next()) {
				Funcionario f = new Funcionario();
				
				f.setLogin(result.getString("login"));
				f.setSenha(result.getString("senha"));
				f.setAtivo(result.getBoolean("ativo"));
				f.setSalario(result.getDouble("salario"));
				f.setContratadoDesde(result.getDate("contratadodesde"));
				f.setLoginSupervisor(result.getString("loginsupervisor"));
				f.setPessoaCpf(result.getString("cpfpessoa"));
				f.setCargoId(result.getInt("cargoid"));
				f.setNomePessoa(result.getString("nome"));
				f.setNomeCargo(result.getString("descricao"));
				
				lista.add(f);
			}
		}catch(Exception ex){
			ex.getMessage();
		}
		return lista;
	}
	
	public Funcionario GetByCPF(String cpf) {
		Conexao connection = new Conexao();

		var query = new StringBuilder("SELECT * FROM Funcionario WHERE cpfpessoa = '%s'");
		var queryGet = String.format(query.toString(), cpf);
		Funcionario f = new Funcionario();
		
		try {
			ResultSet result = connection.Buscar(queryGet);
			while(result.next()) {
				f.setLogin(result.getString("login"));
				f.setSenha(result.getString("senha"));
				f.setAtivo(result.getBoolean("ativo"));
				f.setSalario(result.getDouble("salario"));
				f.setContratadoDesde(result.getDate("contratadodesde"));
				f.setLoginSupervisor(result.getString("loginsupervisor"));
				f.setPessoaCpf(result.getString("cpfpessoa"));
				f.setCargoId(result.getInt("cargoid"));
			}
		}catch(Exception ex){
			ex.getMessage();
		}
		return f;
	}
	

	
}
