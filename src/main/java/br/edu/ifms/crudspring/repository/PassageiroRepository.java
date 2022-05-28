package br.edu.ifms.crudspring.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.crudspring.model.Passageiro;

public interface PassageiroRepository extends JpaRepository<Passageiro, UUID> {
    
}
