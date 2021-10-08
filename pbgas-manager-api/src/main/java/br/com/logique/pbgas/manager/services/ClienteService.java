package br.com.logique.pbgas.manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.logique.pbgas.manager.exceptions.ObjectNotFoundException;
import br.com.logique.pbgas.manager.model.Cliente;
import br.com.logique.pbgas.manager.model.Usuario;
import br.com.logique.pbgas.manager.repositories.ClienteRepository;
@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente find(Long id) {
		Optional<Cliente> user = clienteRepository.findById(id);

		return user.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ",Tipo: " + Cliente.class.getName()));
	}

	public List<Cliente> findAll() {
		List<Cliente> users = clienteRepository.findAll();

		return users;
	}

	
	public Cliente insert(Cliente user) {
		clienteRepository.save(user);
		return user;
	}

	// método de update e delete
	public void delete(Long id) {
		try {
			find(id);
			clienteRepository.deleteById(id);
			
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	public Cliente update(Cliente obj) {
		// busca o obj, caso não exista lança excessão
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return clienteRepository.save(newObj);
	}
	private void updateData(Cliente newObj, Cliente obj) {
		//newObj.setLogin(obj.getLogin());
		//newObj.setSenha(obj.getSenha());
	}
}
