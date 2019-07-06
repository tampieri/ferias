package com.tampieri.ferias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tampieri.ferias.domain.Ferias;

@Repository
public interface FeriasRepository extends JpaRepository<Ferias, Integer> {

	/*@Transactional(readOnly = true)
	@Query("SELECT obj FROM Ferias obj where obj.funcionario.matricula = :matricula")
	public Ferias findFerias(@Param("matricula") Integer matricula);*/

}
