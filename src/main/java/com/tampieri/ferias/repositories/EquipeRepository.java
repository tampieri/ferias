package com.tampieri.ferias.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tampieri.ferias.domain.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Integer>{

}
