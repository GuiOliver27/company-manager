package com.start.spring.app.dao;

import org.springframework.stereotype.Repository;

import com.start.spring.app.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

}
