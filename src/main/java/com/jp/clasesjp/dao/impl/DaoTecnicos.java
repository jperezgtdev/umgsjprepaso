package com.jp.clasesjp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.jp.clasesjp.dao.IDaoTecnicos;
import com.jp.clasesjp.entity.Tecnicos;

import lombok.extern.slf4j.Slf4j;

@Repository
@Transactional
@Slf4j
public class DaoTecnicos implements IDaoTecnicos {
	
	@PersistenceContext
	private EntityManager em;
	
	@Value("${feign.url}")
	private String url;

	@Transactional(readOnly = true)
	@Override
	public List<Tecnicos> findAll() {
		try {
			List<Tecnicos> listaTecnicos = em.createQuery("from Tecnicos").getResultList();
			return listaTecnicos;
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Error fallo la conexion a base de datos");
			return null;
		}
	}

	@Override
	public Tecnicos save(Tecnicos tecnico) {
		try {
			Gson gson = new Gson();
			String json = gson.toJson(tecnico);
			log.info("Data enviada:   " + json);
			em.persist(tecnico);
			return tecnico;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al procesar tecnico " + tecnico.toString());
			return null;
		}
	}

}
