package app.controller;

import java.awt.SystemTray;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Venda;
import app.service.VendaService;

@RestController
@RequestMapping("/api/venda")
public class VendaController {

	@Autowired
	private VendaService vendaService;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Venda venda) {

		try {

			String salvar = this.vendaService.save(venda);
			return new ResponseEntity<>(salvar, HttpStatus.CREATED);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable long id, @RequestBody Venda venda) {

		try {

			String alterar = this.vendaService.update(id, venda);
			return new ResponseEntity<>(alterar, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/listAll")
	public ResponseEntity<List<Venda>> listAll() {

		try {

			List<Venda> lista = this.vendaService.listAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Venda> findById(@PathVariable long id) {

		try {

			Venda venda = this.vendaService.findById(id);
			return new ResponseEntity<>(venda, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {

		try {

			String deletar = this.vendaService.delete(id);
			return new ResponseEntity<>(deletar, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping("/findByEndereco")
	public ResponseEntity<List<Venda>> findByEndereco(@RequestParam String endereco){
		
		try {
			
			List<Venda> venda = this.vendaService.findByEndereco(endereco);
			return new ResponseEntity<>(venda, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}

	@GetMapping("/findByTotal")
	public ResponseEntity<List<Venda>> findByTotal(@RequestParam Double total1,@RequestParam Double total2) {

		try {

			List<Venda> venda = this.vendaService.findByTotal(total1,total2);
			return new ResponseEntity<>(venda, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping("/findByFormaPagamento")
	public ResponseEntity<List<Venda>> findByFormaPagamento(@RequestParam String formaPagamento){
		
		try {
			
			List<Venda> venda = this.vendaService.findByFormaPagamento(formaPagamento);
			return new ResponseEntity<>(venda, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			
		}
	}

}