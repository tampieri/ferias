package com.tampieri.ferias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tampieri.ferias.domain.Signin;

public interface SigninRepository extends JpaRepository<Signin, Integer>{

}
