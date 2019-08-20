package br.com.bureaucep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bureaucep.model.Cep;

@Repository
public interface CepRepository extends JpaRepository<Cep, String> {

}
