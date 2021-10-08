package br.com.logique.pbgas.manager.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.logique.pbgas.manager.model.Cliente;
import br.com.logique.pbgas.manager.services.ClienteService;
@RestController
@RequestMapping(value = "v1/cliente")
public class ClienteResource {
	

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> find(@PathVariable Long id) {

		Cliente obj = clienteService.find(id);
		return ResponseEntity.ok().body(obj);

	}

	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> findAll() {

		List<Cliente> listUsuario = clienteService.findAll().stream().map(obj -> new Cliente(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listUsuario);

	}

	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Cliente> insert(@Valid @RequestBody Cliente user) {

	
		Cliente u=clienteService.insert(user);
		return ResponseEntity.ok().body(u);

	}


	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Cliente> delete(@PathVariable Long id) {
		clienteService.delete(id);
		return ResponseEntity.noContent().build();
	}



}
