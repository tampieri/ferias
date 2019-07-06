package com.tampieri.ferias.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tampieri.ferias.domain.Ferias;
import com.tampieri.ferias.services.FeriasService;

@RestController
@RequestMapping(value="/ferias")
public class FeriasResource {
	
	@Autowired
	private FeriasService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Optional<Ferias> obj = service.buscar(id);		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Ferias>> findAll() {
		List<Ferias> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{matricula}", method=RequestMethod.GET)
	public ResponseEntity<?> findBy(@PathVariable Integer matricula) {
		Optional<Ferias> obj = service.buscarPorMatricula(matricula);		
		return ResponseEntity.ok().body(obj);
	}
	
	/*@RequestMapping(value="/{matricula}/ferias", method=RequestMethod.GET)
	public ResponseEntity<Ferias> findFerias(@PathVariable Integer matricula) {
		Ferias list = service.findByMatricula(matricula);
		return ResponseEntity.ok().body(list);
	}*/
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Ferias obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}

}
