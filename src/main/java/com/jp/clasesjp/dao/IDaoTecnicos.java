package com.jp.clasesjp.dao;

import java.util.List;

import com.jp.clasesjp.entity.Tecnicos;

public interface IDaoTecnicos {
	public List<Tecnicos> findAll();
	public Tecnicos save(Tecnicos tecnico);
}
