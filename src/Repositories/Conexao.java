package Repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
	private String url, user, password;
	private static Connection connection;
	
	public Conexao() {
		url = "jdbc:postgresql://localhost:5432/LM_Stocks_BD";
		user = "postgres";
		password = "*******";
	
		try {			
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, user, password);
			
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void AlterandoDadosSQL(String query) {
		try {
			Statement stm = connection.createStatement();			
			stm.executeUpdate(query);
			connection.close();
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	public ResultSet Buscar(String query) {
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			connection.close();
			
			return result;
		}catch(Exception e) {
		e.getMessage();	
		return null;
		}		
	}
	
	public void Update (String query) {		
		try
			{			    
			    PreparedStatement ps = connection.prepareStatement(query);			    
			    ps.executeUpdate();
			    connection.close();
			}
		catch (SQLException se)
		   {
		      se.getMessage();
		  }
	}	
}



