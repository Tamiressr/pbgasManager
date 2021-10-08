package br.com.logique.pbgas.manager.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
 * Configurações específicas do profile de dev
 * especifica que todos os beans dentro da classe
 *  serão ativados apenas quando
 * o profile for o de dev 
 * que estiver ativo no aplication.properties 
 */
@Configuration
public class DevConfig {
	@Autowired
	private DBService dbService;
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		if(!"create".equals(strategy)) {
			return false;
		}
		
		dbService.instantiateTestDatabase();;
		return true;
	}
}
