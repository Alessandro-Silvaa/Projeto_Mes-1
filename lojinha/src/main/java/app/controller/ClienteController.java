package app.controller;

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

import app.entity.Cliente;
import app.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Cliente cliente) {

		try {

			String salvar = this.clienteService.save(cliente);
			return new ResponseEntity<>(salvar, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable long id, @RequestBody Cliente cliente) {

		try {

			String alterar = this.clienteService.update(id, cliente);
			return new ResponseEntity<>(alterar, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/listAll")
	public ResponseEntity<List<Cliente>> listAll() {
		try {

			List<Cliente> lista = this.clienteService.listAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable long id) {

		try {

			Cliente cliente = this.clienteService.findById(id);
			return new ResponseEntity<>(cliente, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {

		try {

			String deletar = this.clienteService.delete(id);
			return new ResponseEntity<>(deletar, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findByNome")
	public ResponseEntity<List<Cliente>> findByNome(@RequestParam String nome) {

		try {
			List<Cliente> cliente = this.clienteService.findByNome(nome);
			return new ResponseEntity<>(cliente, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findByIdade")
	public ResponseEntity<List<Cliente>> findByIdade(@RequestParam int idade) {

		try {
			List<Cliente> cliente = this.clienteService.findByIdade(idade);
			return new ResponseEntity<>(cliente, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findByCpf")
	public ResponseEntity<List<Cliente>> findByCpf(@RequestParam String cpf) {

		try {

			List<Cliente> cliente = this.clienteService.findByCpf(cpf);
			return new ResponseEntity<>(cliente, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}