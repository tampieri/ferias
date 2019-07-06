package com.tampieri.ferias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampieri.ferias.domain.Funcionario;
import com.tampieri.ferias.repositories.EnderecoRepository;
import com.tampieri.ferias.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repo;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public Optional<Funcionario> buscar(Integer id) {
		Optional<Funcionario> obj = repo.findById(id);
		return obj;
	}
	
	public List<Funcionario> findAll() {
		return repo.findAll();
	}

	public Funcionario insert(Funcionario obj) {
		obj.setMatricula(null);
		enderecoRepository.save(obj.getEndereco());
		return repo.save(obj);
	}
}
