package com.start.spring.app.service;

import java.util.List;

import com.start.spring.app.domain.Cargo;

public interface CargoService {
	void salvar(Cargo cargo);
	
	void editar(Cargo cargo);
	
	void excluir(Long id);
	
	Cargo buscarPorId(Long id);
	
	List<Cargo> buscarTodos();
}
