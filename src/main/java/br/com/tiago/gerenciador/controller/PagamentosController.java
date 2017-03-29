package br.com.tiago.gerenciador.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tiago.gerenciador.modelo.Pagamento;
import br.com.tiago.gerenciador.repository.PagamentoRepository;

@Transactional
@Controller
@Service
public class PagamentosController {

	private PagamentoRepository repository;
	
	@Autowired
      public PagamentosController(PagamentoRepository repository) {
		this.repository = repository;
	}
	
	@RequestMapping("listaPagamentos")
	public String lista(Model model) {
		model.addAttribute("pagamentos",this.repository.lista());
	//model.addAttribute("pagamentos",this.repository.listaMes(data,data1));
		return "pagamentos/lista";
		
	}
	
	
	@RequestMapping("lista1Pagamentos")
	public String lista1(Model model) {
		Calendar data = Calendar.getInstance();
		Calendar data1 = Calendar.getInstance();
				data1.add(Calendar.MONTH, 1);
	model.addAttribute("pagamentos",this.repository.listaMes(data,data1));
		return "pagamentos/lista1";
		
	}
	
	@RequestMapping("listaPagamentosMes")
	public String listaMes(Model model,GregorianCalendar data,GregorianCalendar data1) {
		
	model.addAttribute("pagamentos",this.repository.listaMes(data,data1));
		return "pagamentos/lista1";	
		
	}
	
	
	@RequestMapping("adicionaPagamento")
	public String adiciona(@Valid Pagamento pagamento,BindingResult result) {
		if (result.hasFieldErrors("nome")) {
			return "pagamentos/formulario";
		}
		this.repository.cadastra(pagamento);
		return "redirect:listaPagamentos";
	}
	
	@RequestMapping("novoPagamento")
	public String formulario() {
		return "pagamentos/formulario";
	}
	
	@RequestMapping("mostraPagamento")
	public String mostra(Long id,Model model) {
		Pagamento pagamento = new Pagamento();
		pagamento.setId(id);
		model.addAttribute("pagamento", repository.mostra(pagamento));
		return "pagamentos/mostra";
	}
	
	@RequestMapping("alteraPagamento")
	public String altera(Pagamento pagamento) {
	repository.altera(pagamento);
		return "redirect:listaPagamentos";
	}
	
	@RequestMapping("removePagamento") 
	public String remove(Long id) {
		Pagamento pagamento = new Pagamento();
		pagamento.setId(id);
		repository.remove(pagamento);
		return "redirect:listaPagamentos";
	}
	
	
}
