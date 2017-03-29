package br.com.tiago.gerenciador.repository;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.tiago.gerenciador.modelo.Pagamento;

@Repository
public class PagamentoRepository {


	@PersistenceContext
	EntityManager manager;
	
	public List<Pagamento> lista() {
		return manager.createQuery("select p from Pagamento p").getResultList();		
	}
	
	public List<Pagamento> listaMes(Calendar data,Calendar data1) {
				data1.add(Calendar.MONTH,1);
		//data.set(3,Calendar.DAY_OF_YEAR);
		return manager.createQuery("select p from Pagamento p where data between :data and :data1 order by data").
				setParameter("data", data).
				setParameter("data1",data1).
				getResultList();		
	}
	
	
	public void cadastra(Pagamento pagamento) {
		manager.persist(pagamento);
	}
	
	public void altera(Pagamento pagamento) {
		manager.merge(pagamento);
	}
	
	public Pagamento mostra(Pagamento pagamento) {
		return manager.find(Pagamento.class, pagamento.getId());
	}
	
	public void remove(Pagamento pagamento) {
	pagamento = 	this.mostra(pagamento);
		manager.remove(pagamento);
	}
}
