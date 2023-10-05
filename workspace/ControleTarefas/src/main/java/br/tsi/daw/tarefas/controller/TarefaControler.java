package br.tsi.daw.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.tsi.daw.tarefas.model.Tarefa;
import br.tsi.daw.tarefas.model.dao.DAO;

@Controller
public class TarefaControler {
	
	@RequestMapping("novaTarefa")
	public String forAddTarefa() {
		return "tarefas/novaTarefa";
	}
	
	@RequestMapping("adicionaTarefa")
	public String adiciona(Tarefa tarefa) {
		DAO dao = new DAO<>(Tarefa.class);
		dao.adiciona(tarefa);
		return "tarefas/adicionada";
	}
}
