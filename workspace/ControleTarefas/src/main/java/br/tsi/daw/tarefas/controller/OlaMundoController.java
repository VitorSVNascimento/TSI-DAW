package br.tsi.daw.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {
	
	@RequestMapping("olaMundoSpring")
	public String olaMundo() {
		System.out.println("Executando esse trem");
		return "ola";
			
	}
	
	
}
