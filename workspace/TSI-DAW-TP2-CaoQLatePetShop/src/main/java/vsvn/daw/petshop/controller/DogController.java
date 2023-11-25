package vsvn.daw.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import vsvn.daw.petshop.dao.DAO;
import vsvn.daw.petshop.models.Account;
import vsvn.daw.petshop.models.Dog;

@Controller
public class DogController {

	@RequestMapping("formulario-cachorro")
	public String formDog() {
		return "dog/formulario-cachorro";
	}
	
	@RequestMapping("registrar-cachorro")
	public String registerDog(Dog dog,HttpSession session) {
		
		Account acc = (Account)session.getAttribute("user");
		dog.setAccount(acc);
		
		DAO<Dog> dao = new DAO<Dog>(Dog.class);
		dao.insert(dog);
		return "dog/adicionado";
		
	}
	
}
