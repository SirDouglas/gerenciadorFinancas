package br.com.tiago.gerenciador.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.tiago.gerenciador.app.ConnectionFactory;
import br.com.tiago.gerenciador.modelo.Recebimento;



public class RecebimentoDao {

	private Connection connection;

	public RecebimentoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Recebimento recebimento) {
		String sql = "insert into recebimento " +
				"(nome,valor,data)" +
				"values (?,?,?)";
				try {
					PreparedStatement stmt = connection.prepareStatement(sql);
					stmt.setString(1, recebimento.getNome());
					stmt.setDouble(2, recebimento.getValor());
				stmt.setDate(3, new Date (recebimento.getData().getTimeInMillis()));
				stmt.execute();
				stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e);
				}
	}
	

	
	
	public void altera(Recebimento recebimento) {
		String sql = "update recebimento set nome=?,valor=?,data=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, recebimento.getNome());
			stmt.setDouble(2, recebimento.getValor());
			stmt.setDate(3,new Date(recebimento.getData().getTimeInMillis()));
			stmt.setLong(4, recebimento.getId());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Recebimento recebimento) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from recebimento where id=?");
			stmt.setLong(1, recebimento.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public List<Recebimento> lista() {
		// TODO Auto-generated method stub
		List<Recebimento> lista = new ArrayList<Recebimento>();
		try {
			PreparedStatement stmt = connection.prepareStatement("select * from recebimento");
			ResultSet rs = stmt.executeQuery();
     while	(rs.next()) {
    	 Recebimento recebimento = new Recebimento();
    	 recebimento.setId(rs.getLong("id"));
    	 recebimento.setNome(rs.getString("nome"));
    	 recebimento.setValor(rs.getDouble("valor"));
    	 Calendar data = Calendar.getInstance();
    	 data.setTime(rs.getDate("data"));
    	 recebimento.setData(data);
    	 lista.add(recebimento);
     }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		throw new RuntimeException(e);
		}
		
		return lista;
	
	}
	
	
	public Recebimento mostra(Long id) {
		Recebimento recebimento = new Recebimento();
		try {
			PreparedStatement stmt = connection.prepareStatement("select * from recebimento where id=?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
		    	 recebimento.setId(rs.getLong("id"));
		    	 recebimento.setNome(rs.getString("nome"));
		    	 recebimento.setValor(rs.getDouble("valor"));
		    	 Calendar data = Calendar.getInstance();
		    	 data.setTime(rs.getDate("data"));
		    	 recebimento.setData(data);
		    	 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return recebimento;
		
	}
	
}
