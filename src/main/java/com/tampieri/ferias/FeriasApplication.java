package com.tampieri.ferias;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tampieri.ferias.domain.Equipe;
import com.tampieri.ferias.domain.Funcionario;
import com.tampieri.ferias.repositories.EquipeRepository;

@SpringBootApplication
public class FeriasApplication implements CommandLineRunner{

	@Autowired
	private EquipeRepository equipeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(FeriasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Equipe equ1 = new Equipe(null, "Desenvolvimento");
		Equipe equ2 = new Equipe(null, "Tester");
		
		equipeRepository.saveAll(Arrays.asList(equ1, equ2));
		
		
	}

}
