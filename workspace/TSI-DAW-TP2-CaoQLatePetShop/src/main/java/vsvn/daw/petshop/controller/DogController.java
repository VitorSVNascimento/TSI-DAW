package vsvn.daw.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import vsvn.daw.petshop.dao.DAO;
import vsvn.daw.petshop.dao.DogDAO;
import vsvn.daw.petshop.models.Account;
import vsvn.daw.petshop.models.Dog;

@Controller
public class DogController {

	@RequestMapping("formulario-cachorro")
	public String formDog() {
		return "dog/formulario-cachorro";
	}
	
	@RequestMapping("registrar-cachorro")
	public String registerDog(@Valid Dog dog,HttpSession session,
			 BindingResult binding,RedirectAttributes attibutes) {
		if(binding.hasFieldErrors())
			return "dog/formulario-cachorro";
		DogDAO dogDao = new DogDAO(Dog.class);
		
		Account acc = (Account)session.getAttribute("user");
		for(Dog d : dogDao.getDogsByOwner(acc))
			if(d.getName().equalsIgnoreCase(dog.getName())) {
				attibutes.addFlashAttribute("message",String.format("O Cachorro %s já está registrado", dog.getName()));
				return "redirect:formulario-cachorro";
			}
				
		dog.setAccount(acc);
		
		DAO<Dog> dao = new DAO<Dog>(Dog.class);
		dao.insert(dog);
		attibutes.addFlashAttribute("message",String.format("O Cachorro %s foi registrado com sucesso", dog.getName()));
		return "redirect:formulario-cachorro";
		
	}
	
}
