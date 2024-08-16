package com.start.spring.app.dao;

import java.util.List;

import com.start.spring.app.domain.Departamento;

public interface DepartamentoDao {
	void save(Departamento departamento);
	
	void update(Departamento departamento);
	
	void delete(Long id);
	
	Departamento findById(Long id);
	
	List<Departamento> findAll();
}
