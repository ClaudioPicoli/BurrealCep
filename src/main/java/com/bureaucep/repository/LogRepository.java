package com.bureaucep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bureaucep.entify.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

}
