package br.com.tiago.gerenciador.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.tiago.gerenciador.modelo.Recebimento;

@Repository
public class RecebimentoRepository {

	@PersistenceContext
	EntityManager manager;
	
	public List<Recebimento> lista() {
		return manager.createQuery("select r from Recebimento r").getResultList();
		
	}
	
	@Transactional
	public void insere(Recebimento recebimento) {
		manager.persist(recebimento);
		
	}
	
	@Transactional
	public void altera(Recebimento recebimento) {
		manager.merge(recebimento);
	}
	
	@Transactional
	public Recebimento mostra(Recebimento recebimento) {
		return manager.find(Recebimento.class,recebimento.getId());
		
	}
	
	@Transactional
	public void remove(Recebimento recebimento) {
		recebimento = this.mostra(recebimento);
		 manager.remove(recebimento);
	}
	
}
