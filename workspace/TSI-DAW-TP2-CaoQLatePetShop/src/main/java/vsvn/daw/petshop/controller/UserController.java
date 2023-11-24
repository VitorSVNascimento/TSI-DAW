package vsvn.daw.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import vsvn.daw.petshop.dao.DAO;
import vsvn.daw.petshop.models.Account;

@Controller
public class UserController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("novoCliente")
	public String formNewClient() {
		return "cliente/novoCliente";
	}
	
	@RequestMapping("adicionaCliente")
	public String insert(Account user) {
		DAO<Account> dao = new DAO<>(Account.class);
		dao.insert(user);
		return "cliente/adicionado";
	}
	
}
