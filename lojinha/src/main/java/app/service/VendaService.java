package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Venda;
import app.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;

	public String save(Venda venda) {

		this.vendaRepository.save(venda);
		return venda.getTotal() + "Venda realizada";

	}

	public String update(long id, Venda venda) {

		venda.setIdVenda(id);
		this.vendaRepository.save(venda);

		return "Venda alterada";
	}

	public List<Venda> listAll() {

		return this.vendaRepository.findAll();

	}

	public Venda findById(long id) {

		Venda venda = this.vendaRepository.findById(id).get();

		return venda;
	}

	public String delete(long id) {

		this.vendaRepository.deleteById(id);

		return "Venda deletada";
	}
	
	public List<Venda> findByEndereco(String endereco){
		
		return vendaRepository.findByEndereco(endereco);
	}
	
	public List<Venda> findByTotal(Double total1, Double total2){
		
		return vendaRepository.findByTotal(total1,total2);
	}
	
	public List<Venda> findByFormaPagamento(String formaPagamento){
		
		return vendaRepository.findByFormaPagamento(formaPagamento);
	}

}