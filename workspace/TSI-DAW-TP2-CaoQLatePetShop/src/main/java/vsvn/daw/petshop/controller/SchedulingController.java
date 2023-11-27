package vsvn.daw.petshop.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import vsvn.daw.petshop.dao.DAO;
import vsvn.daw.petshop.dao.DogDAO;
import vsvn.daw.petshop.dao.SchedulingDAO;
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
	    
    	model.addAttribute("services_types", servicesList);
	    	

		model.addAttribute("dogs",dogDao.getDogsByOwner((Account)session.getAttribute("user")));
		return "scheduling/scheduling-form";
	}
	
 	@RequestMapping("agendar")
	public String scheduling(@Valid Scheduling scheduling, BindingResult binding,RedirectAttributes attibutes,
			@RequestParam("dog.id") Long dogId, HttpServletRequest req) {
		
		if(binding.hasErrors()) 
			return "scheduling/scheduling-form";
		
		DogDAO dogDao = new DogDAO(Dog.class);
		ServiceDAO serviceDao = new ServiceDAO(Service.class);
		DAO<Scheduling> dao = new DAO<Scheduling>(Scheduling.class);
		
		List<Long> scheduling_service = new ArrayList<Long>();
		
		for(Object o : req.getParameterValues("scheduling_services"))
			scheduling_service.add(Long.parseLong(o.toString())) ;
		
		serviceDao.getByIds(scheduling_service);
		Dog dog = dogDao.getById(dogId);
		scheduling.setDog(dog);
		scheduling.setState("Em aguardo");
		Float total_ammount = 0f;
		
		List<Service> final_services =serviceDao.getByIds(scheduling_service); 
		for(Service s : final_services) 
			total_ammount+=s.getPrice();
		
		if(final_services.size()>=3)
			total_ammount -= total_ammount*0.03f;
		
		scheduling.setAmmount(total_ammount);
		scheduling.setServices(serviceDao.getByIds(scheduling_service));
		
		dao.insert(scheduling);
		attibutes.addFlashAttribute("message","Agendamento realizado com sucesso!");
		return "redirect:scheduling-form";
	}
 	
 	@RequestMapping("servicos-agendados")
 	public String scheduledService(Model model,HttpSession session) {
 		
 		List<Scheduling> schedulings = new SchedulingDAO(Scheduling.class).getScheduled();
 		List<Scheduling> byUser = new ArrayList<Scheduling>();
 		Account acc = (Account)session.getAttribute("user");
 		
 		for(Scheduling s : schedulings)
 			if(s.getDog().getAccount().getId() == acc.getId())
 				byUser.add(s);
 		
 		for(Scheduling s : byUser)
 			System.out.println("aaa == "+s.getId());
 		
 		model.addAttribute("scheduledService",byUser);
 		return "scheduling/scheduledService";
 	}
 	
 	@RequestMapping("agenda-servico-admin")
 	public String scheduledServiceAdmin(HttpSession session) {
 		
 		session.setAttribute("date_scheduling", new ArrayList<Scheduling>());
 		return "scheduling/scheduledServiceAdmin";
 	}
 	
 	
 	@RequestMapping("get-scheduling-admin-byDate")
 	public String getSchedulingAdminByDate(@DateTimeFormat(pattern = "yyyy-MM-dd") Calendar calendar,HttpSession session) {
 		System.out.println("Entrou na lógica");
 		List<Scheduling> schedulings = new SchedulingDAO(Scheduling.class).getScheduledAdmin(calendar);
 		System.out.println("size ==="+schedulings.size());
 		session.setAttribute("date_scheduling", schedulings);
 		return "scheduling/find_by_date";
 	}
 	
 	@ResponseBody
 	@RequestMapping("cancel-scheduling")
 	public void cancelScheduling(Scheduling scheduling) {
 		DAO<Scheduling> dao = new DAO<Scheduling>(Scheduling.class);
 		scheduling = dao.getById(scheduling.getId());
 		scheduling.setState("Cancelado");
 		dao.update(scheduling);
 		
 	}
 	
}
