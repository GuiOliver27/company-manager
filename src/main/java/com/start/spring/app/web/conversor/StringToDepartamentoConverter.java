package com.start.spring.app.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.start.spring.app.domain.Departamento;
import com.start.spring.app.service.DepartamentoService;

@SuppressWarnings("null")
@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento> {

    @Autowired
    private DepartamentoService service;

    @Override
    public Departamento convert(String text) {
        if (text.isEmpty()) {
            return null;
        }

        Long id = Long.valueOf(text);
        return service.buscarPorId(id);
    }
    
}
