package br.com.bureaucep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bureaucep.model.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

}
