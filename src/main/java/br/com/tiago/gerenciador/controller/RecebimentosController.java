package br.com.tiago.gerenciador.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tiago.gerenciador.dao.RecebimentoDao;
import br.com.tiago.gerenciador.modelo.Recebimento;
import br.com.tiago.gerenciador.repository.RecebimentoRepository;

@Transactional
@Controller
@Service
public class RecebimentosController {

	
	private RecebimentoRepository repository;
	
	@Autowired
	public RecebimentosController(RecebimentoRepository recebimentoRepository) {
	this.repository = recebimentoRepository;
	}

	@RequestMapping("adicionaRecebimento")
	public String recebimento(@Valid Recebimento recebimento,BindingResult result) {
		if (result.hasFieldErrors("nome")) {
			return "recebimentos/formulario";
		}
		System.out.println("Bom dia " + recebimento.getNome());
		System.out.println("valor " + recebimento.getValor());
		System.out.println("Data " + recebimento.getData());
		repository.insere(recebimento);
				return "recebimentos/recebimento-adicionado";
		
	}
	
	@RequestMapping("novoRecebimento") 
	public String form() {
		return "recebimentos/formulario";
		
	}
	

	@RequestMapping("listaRecebimentos")
	public String lista(Model model) {
		model.addAttribute("recebimentos",repository.lista());
		return "recebimentos/lista";
		
	}
	@RequestMapping("removeRecebimento")
	public String remove(Recebimento recebimento) {
			    repository.remove(recebimento);
		return "redirect:listaRecebimentos";
	}
	
	@RequestMapping("mostraRecebimento")
    public String mostra(Long id,Model model) {
		Recebimento recebimento = new Recebimento();
		recebimento.setId(id);
		model.addAttribute("recebimento",repository.mostra(recebimento));
		return "recebimentos/mostra";
		
	}
	
	@RequestMapping("alteraRecebimento")
	public String altera(Recebimento recebimento) {
		repository.altera(recebimento);
		return "redirect:listaRecebimentos";
	}
	
	
	
}

