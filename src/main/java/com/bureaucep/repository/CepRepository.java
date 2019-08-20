package com.bureaucep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bureaucep.entify.Cep;

@Repository
public interface CepRepository extends JpaRepository<Cep, String> {

}
