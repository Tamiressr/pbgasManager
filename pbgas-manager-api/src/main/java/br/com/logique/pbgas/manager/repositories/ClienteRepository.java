package br.com.logique.pbgas.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.logique.pbgas.manager.model.Cliente;
@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long> {

}
