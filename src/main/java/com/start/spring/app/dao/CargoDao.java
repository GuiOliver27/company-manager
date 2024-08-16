package com.start.spring.app.dao;

import java.util.List;

import com.start.spring.app.domain.Cargo;

public interface CargoDao {
	void save(Cargo cargo);
	
	void update(Cargo cargo);
	
	void delete(Long id);
	
	Cargo findById(Long id);
	
	List<Cargo> findAll();
}
