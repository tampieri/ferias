package com.tampieri.ferias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampieri.ferias.domain.Equipe;
import com.tampieri.ferias.repositories.EquipeRepository;
import com.tampieri.ferias.services.exceptions.ObjectNotFoundException;

@Service
public class EquipeService {

	@Autowired
	private EquipeRepository repo;

	public Equipe buscar(Integer id) {
		Optional<Equipe> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Equipe.class.getName()));
	}

	public List<Equipe> findAll() {
		return repo.findAll();
	}

	public Equipe insert(Equipe obj) {
		obj.setId(null);
		return repo.save(obj);
	}
}
