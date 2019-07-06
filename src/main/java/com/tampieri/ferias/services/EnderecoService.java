package com.tampieri.ferias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampieri.ferias.domain.Endereco;
import com.tampieri.ferias.repositories.EnderecoRepository;
import com.tampieri.ferias.services.exceptions.ObjectNotFoundException;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repo;

	public List<Endereco> findAll() {
		return repo.findAll();
	}

	public Endereco insert(Endereco obj) {
		return null;
	}

	public Endereco buscar(Integer id) {
		Optional<Endereco> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Endereco.class.getName()));
	}
}
