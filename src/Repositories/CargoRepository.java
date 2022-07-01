package Repositories;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Entities.Cargo;

public class CargoRepository {
	
	public List<Cargo> GetCargos(){
		Conexao connection = new Conexao();

		var query = new StringBuilder("SELECT * FROM Cargo order by id");
		ArrayList<Cargo> lista = new ArrayList<Cargo>();
		
		try {
			ResultSet result = connection.Buscar(query.toString());
			while(result.next()) {
				Cargo c = new Cargo();
				
				c.setID(result.getInt("id"));
				c.setDescricao(result.getString("descricao"));			
				
				lista.add(c);
			}
		}catch(Exception ex){
			ex.getMessage();
		}
		return lista;
	}
}
