package br.com.logique.pbgas.manager.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.logique.pbgas.manager.model.Cliente;
import br.com.logique.pbgas.manager.model.Usuario;
import br.com.logique.pbgas.manager.services.ClienteService;
import br.com.logique.pbgas.manager.services.UsuarioService;

@RestController
@RequestMapping(value = "v1/usuario")
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> find(@PathVariable Long id) {

		Usuario obj = usuarioService.find(id);
		return ResponseEntity.ok().body(obj);

	}

	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> findAll() {

		List<Usuario> listUsuario = usuarioService.findAll().stream().map(obj -> new Usuario(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listUsuario);

	}

	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Usuario> insert(@Valid @RequestBody Usuario user) {

	
		Usuario u=usuarioService.insert(user);
		return ResponseEntity.ok().body(u);

	}


	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Usuario> delete(@PathVariable Long id) {
		usuarioService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/addCliente",method = RequestMethod.POST)
	public ResponseEntity<Cliente> insertClient(@Valid @RequestBody Cliente cliente) {

	
		Cliente u=clienteService.insert(cliente);
		return ResponseEntity.ok().body(u);

	}

}
