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
import br.com.tiago.gerenciador.modelo.Pagamento;



public class PagamentoDao {

	private Connection connection;

	public PagamentoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void insere(Pagamento pagamento) {
		String sql = "insert into pagamento" +
	"(nome,valor,data)" +
 		"values (?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, pagamento.getNome());
			stmt.setDouble(2, pagamento.getValor());
			stmt.setDate(3,new Date (pagamento.getData().getTimeInMillis()));
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
		throw new RuntimeException(e);
		}
	}
	
	public List<Pagamento> getLista() {
		List<Pagamento> lista = new ArrayList<Pagamento>();
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from pagamento");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Pagamento pagamento = new Pagamento();
				pagamento.setId(rs.getLong("id"));
				pagamento.setNome(rs.getString("nome"));
				pagamento.setValor(rs.getDouble("valor"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data"));
				pagamento.setData(data);
				lista.add(pagamento);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return lista;
		
	}
	
	public void altera(Pagamento pagamento) {
		String sql = "update pagamento set nome=?,valor=?,data=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, pagamento.getNome());
			stmt.setDouble(2, pagamento.getValor());
			stmt.setDate(3, new Date (pagamento.getData().getTimeInMillis()));
			stmt.setLong(4, pagamento.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Pagamento pagamento) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from pagamento where id=?");
			stmt.setLong(1, pagamento.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	
	

	
}
