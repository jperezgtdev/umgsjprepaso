package com.jp.clasesjp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.clasesjp.dao.IDaoTecnicos;
import com.jp.clasesjp.entity.Tecnicos;

@RestController
@RequestMapping(value = "/api")
public class IndexController {
	
	@Autowired
	private IDaoTecnicos daoTecnicos;
	
	@GetMapping(value = "/tecnicos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Tecnicos> getTecnicos() {
		return daoTecnicos.findAll();
	}
	
	@PostMapping(value = "/tecnicos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Tecnicos saveTecnico(@RequestBody Tecnicos tecnico) {
		return daoTecnicos.save(tecnico);
	}

}
