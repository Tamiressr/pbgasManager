package br.com.logique.pbgas.manager.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.logique.pbgas.manager.model.Perfil;
import br.com.logique.pbgas.manager.model.Usuario;
import br.com.logique.pbgas.manager.services.UsuarioService;

@Service
public class DBService {
	@Autowired
	private UsuarioService usuarioService;

	public void instantiateTestDatabase() throws ParseException {
		
		Usuario u=new Usuario();
		u.setLogin("root");
		u.setSenha("123456");
		Perfil p= new Perfil();
		p.setNome("ADMINISTRADOR");
		u.setPerfil(p);
		usuarioService.insert(u);
	}
}
