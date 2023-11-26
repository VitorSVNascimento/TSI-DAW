package vsvn.daw.petshop.controller;

import java.util.ArrayList;
import java.util.List;

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
import vsvn.daw.petshop.dao.ServiceDAO;
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
	    List<Service> servicesList = dao.getAll();
	    
	    if(servicesList!=null) {
	    	model.addAttribute("services_type", servicesList);
	    	
	    }else {
	    	model.addAttribute("services_type", dao.getAll());
	    }
		model.addAttribute("dogs",dogDao.getDogsByOwner((Account)session.getAttribute("user")));
		return "scheduling/scheduling-form";
	}
	
	@RequestMapping("agendar")
	public String scheduling(@Valid Scheduling scheduling, BindingResult binding,RedirectAttributes attibutes,
			@RequestParam("dog.id") Long dogId,@RequestParam(value = "services", required = false) Long[] selectedServices) {
		
		if(binding.hasErrors()) 
			return "scheduling/scheduling-form";
		
		DogDAO dogDao = new DogDAO(Dog.class);
		ServiceDAO serviceDao = new ServiceDAO(Service.class);
		DAO<Scheduling> dao = new DAO<Scheduling>(Scheduling.class);
		List<Long> checkbox = new ArrayList<>();
		for(Long sid : selectedServices)
			checkbox.add(sid);
		
		Dog dog = dogDao.getById(dogId);
		scheduling.setServices(serviceDao.getByIds(checkbox));
		scheduling.setDog(dog);
		scheduling.setState("Em aguardo");
		
		for(Service s : scheduling.getServices())
			System.out.println(s.getName());
		
		dao.insert(scheduling);
		attibutes.addFlashAttribute("message","Agendamento realizado com sucesso!");
		return "scheduling/scheduling-form";
	}
}
