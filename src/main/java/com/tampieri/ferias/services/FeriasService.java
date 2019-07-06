package com.tampieri.ferias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tampieri.ferias.domain.Ferias;
import com.tampieri.ferias.repositories.FeriasRepository;
import com.tampieri.ferias.services.exceptions.DataIntegrityException;
import com.tampieri.ferias.services.exceptions.ObjectNotFoundException;

@Service
public class FeriasService {

	@Autowired
	private FeriasRepository repo;

	public Optional<Ferias> buscar(Integer id) {
		Optional<Ferias> obj = repo.findById(id);
		return obj;
	}

	public List<Ferias> findAll() {
		return repo.findAll();
	}
	
	public Ferias find(Integer id) {
		Optional<Ferias> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Ferias.class.getName()));
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir Ferias");
		}
	}
	
	public Optional<Ferias> buscarPorMatricula(Integer matricula) {
		
		Optional<Ferias> obj = repo.findById(matricula);
		return obj;
	}

	/*public Ferias findByMatricula(Integer matricula) {
		return repo.findFerias(matricula);
	}*/

	public Ferias insert(Ferias obj) {
		obj.setId(null);
		return repo.save(obj);
	}
}
