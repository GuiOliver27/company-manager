package com.start.spring.app.web.controller;

import java.beans.PropertyEditorSupport;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.start.spring.app.domain.Cargo;
import com.start.spring.app.domain.Departamento;
import com.start.spring.app.service.CargoService;
import com.start.spring.app.service.DepartamentoService;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	private CargoService cargoService;

	@Autowired
	private DepartamentoService departamentoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {
		return "/cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar() {
		return "/cargo/lista";
	}

	@PostMapping("/salvar")
	public String salvar(Cargo cargo, RedirectAttributes attr) {
    Departamento departamento = departamentoService.buscarPorId(cargo.getDepartamento().getId());
    cargo.setDepartamento(departamento);
    cargoService.salvar(cargo);
    attr.addFlashAttribute("success", "Cargo inserido com sucesso.");
    return "redirect:/cargos/cadastrar";
}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(Departamento.class, new PropertyEditorSupport() {
        @Override
        public void setAsText(String text) {
            Long id = Long.valueOf(text);
            Departamento departamento = departamentoService.buscarPorId(id);
            setValue(departamento);
        }
    });
}



	@ModelAttribute("departamentos")
	public List<Departamento> listadeDepartamentos(){
		return departamentoService.buscarTodos();
	}
}
