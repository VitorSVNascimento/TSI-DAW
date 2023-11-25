package vsvn.daw.petshop.controller;

import java.security.Provider.Service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
public class ServiceControler {
	
	@RequestMapping("service-page")
	public String servicePaga(){
		return "service/servico";
	}
	
//	@RequestMapping("registrar-servico")
//	public String registerService(@Valid Service service) {
//	}
	
}
