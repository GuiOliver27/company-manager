package com.start.spring.app.dao;

import java.util.List;

import com.start.spring.app.domain.Funcionario;

public interface FuncionarioDao {
	void save(Funcionario funcionario);
	
	void update(Funcionario funcionario);
	
	void delete(Long id);
	
	Funcionario findById(Long id);
	
	List<Funcionario> findAll();
}
