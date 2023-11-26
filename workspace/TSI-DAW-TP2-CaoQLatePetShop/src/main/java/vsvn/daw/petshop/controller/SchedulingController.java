package vsvn.daw.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import vsvn.daw.petshop.dao.DAO;
import vsvn.daw.petshop.dao.DogDAO;
import vsvn.daw.petshop.models.Account;
import vsvn.daw.petshop.models.Dog;
import vsvn.daw.petshop.models.Scheduling;
import vsvn.daw.petshop.models.Service;

@Controller
public class SchedulingController {

	@RequestMapping("scheduling-form")
	public String schedulingPage(Model model,HttpSession session) {
		DAO<Service> dao = new DAO<Service>(Service.class);
		DogDAO dogDao = new DogDAO(Dog.class);
		
	    Scheduling scheduling = new Scheduling();
	    model.addAttribute("scheduling", scheduling);
		
		model.addAttribute("services", dao.getAll());
		model.addAttribute("dogs",dogDao.getDogsByOwner((Account)session.getAttribute("user")));
		return "scheduling/scheduling-form";
	}
	
	@RequestMapping("agendar")
	public String scheduling(@Valid Scheduling scheduling, BindingResult binding,RedirectAttributes attibutes,
			@RequestParam("dog.id") Long dogId) {
		
		if(binding.hasErrors()) 
			return "scheduling/scheduling-form";
		DogDAO dogDao = new DogDAO(Dog.class);
		Dog dog = dogDao.getById(dogId);
		DAO<Scheduling> dao = new DAO<Scheduling>(Scheduling.class);
		for(Service s : scheduling.getServices())
			System.out.println(s.getName());
		
		scheduling.setDog(dog);
		dao.insert(scheduling);
		attibutes.addFlashAttribute("message","Agendamento realizado com sucesso!");
		return "redirect:scheduling-form";
	}
}
