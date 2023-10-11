package br.tsi.daw.tarefas.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping("listaTarefa")
	public String lista(Model model) {
		DAO<Tarefa> dao = new DAO<Tarefa>(Tarefa.class);
		model.addAttribute("tarefas", dao.listaTodos());
		return "tarefas/lista";
	}
	
	@RequestMapping("mostraTarefa")
	public String mostra(Tarefa tarefa,Model model) {
		
		DAO<Tarefa> dao = new DAO<>(Tarefa.class);
		model.addAttribute("tarefa", dao.buscaPorId(tarefa.getId()));
		return "tarefas/mostra";
	}
	
	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {
		DAO<Tarefa> dao = new DAO<Tarefa>(Tarefa.class);
		dao.remove(tarefa);
		return "redirect:listaTarefa";
	}
	
	
	@RequestMapping("alterarTarefa")
	public String altera(Tarefa tarefa) {
		DAO<Tarefa> dao = new DAO<Tarefa>(Tarefa.class);
		dao.altera(tarefa);
		return "redirect:listaTarefa";
	}
	
//	@ResponseBody
//	@RequestMapping("finalizaTarefa")
//	public void finaliza(Tarefa tarefa) {
//		
//		DAO<Tarefa> dao = new DAO<Tarefa>(Tarefa.class);
//		tarefa = (Tarefa) dao.buscaPorId(tarefa.getId());
//		tarefa.setFinalizado(true);
//		tarefa.setDataFinalizacao(Calendar.getInstance());
//		dao.altera(tarefa);
//		return;
//		
//	}
	
	@RequestMapping("finalizaTarefa")
	public String finaliza(Tarefa tarefa,Model model) {
		
		DAO<Tarefa> dao = new DAO<Tarefa>(Tarefa.class);
		tarefa = (Tarefa) dao.buscaPorId(tarefa.getId());
		tarefa.setFinalizado(true);
		tarefa.setDataFinalizacao(Calendar.getInstance());
		dao.altera(tarefa);
		model.addAttribute("tarefa", tarefa);
		return "tarefas/finalizada";
		
	}
	
	@ResponseBody
	@RequestMapping("removeAjax")
	public void removeAjax(Tarefa tarefa) {
		DAO<Tarefa> dao = new DAO<Tarefa>(Tarefa.class);
		tarefa = dao.buscaPorId(tarefa.getId());
		dao.remove(tarefa);
		
	}
}
