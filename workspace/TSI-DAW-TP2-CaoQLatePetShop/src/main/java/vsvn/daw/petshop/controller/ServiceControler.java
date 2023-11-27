package vsvn.daw.petshop.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import vsvn.daw.petshop.dao.DAO;
import vsvn.daw.petshop.models.Service;

@Controller
public class ServiceControler {
	
	@RequestMapping("service-page")
	public String servicePage(){
		return "service/servico";
	}
	
	@RequestMapping("registrar-servico")
	public String registerService(@Valid Service service, BindingResult binding,RedirectAttributes attibutes) {
		if(binding.hasFieldErrors()) 
			return "service/servico";
		
		
		DAO<Service> dao = new DAO<Service>(Service.class);
		List<Service> services = dao.getAll();
		for (Service s : services)
			if(s.getName().equalsIgnoreCase(service.getName())) {
				attibutes.addFlashAttribute("message","Esse serviço já está registrado!");
				return "redirect:service-page"; 
			}
				
		dao.insert(service);
		attibutes.addFlashAttribute("message","Novo serviço registrado!");
		return "redirect:service-page"; 
		
	}
	
}
