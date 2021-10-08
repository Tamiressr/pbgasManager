package br.com.logique.pbgas.manager.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import br.com.logique.pbgas.manager.exceptions.ObjectNotFoundException;
import br.com.logique.pbgas.manager.model.Usuario;
import br.com.logique.pbgas.manager.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario find(Long id) {
		Optional<Usuario> user = usuarioRepository.findById(id);

		return user.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ",Tipo: " + Usuario.class.getName()));
	}

	public List<Usuario> findAll() {
		List<Usuario> users = usuarioRepository.findAll();

		return users;
	}

	
	public Usuario insert(Usuario user) {
		usuarioRepository.save(user);
		return user;
	}

	// método de update e delete
	public void delete(Long id) {
		try {
			find(id);
			usuarioRepository.deleteById(id);
			
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	public Usuario update(Usuario obj) {
		// busca o obj, caso não exista lança excessão
		Usuario newObj = find(obj.getId());
		updateData(newObj, obj);
		return usuarioRepository.save(newObj);
	}
	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setLogin(obj.getLogin());
		newObj.setSenha(obj.getSenha());
	}
}
