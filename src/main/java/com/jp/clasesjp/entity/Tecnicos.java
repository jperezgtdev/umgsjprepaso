package com.jp.clasesjp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tecnicos")
public class Tecnicos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtecnicos")
	private int idtecnicos;
	
	private String primernombre;
}
