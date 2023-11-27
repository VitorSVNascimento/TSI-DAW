package vsvn.daw.petshop.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
		
		if(!new SchedulingDAO(Scheduling.class).verifyDate(scheduling.getSchedulingDate())) {
			attibutes.addFlashAttribute("message","A data selecionada não está disponível");
			return "redirect:scheduling-form";
		}
			
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
 		List<Scheduling> schedulings = new SchedulingDAO(Scheduling.class).getScheduledAdmin(calendar);
 		session.setAttribute("date_scheduling", schedulings);
 		return "scheduling/find_by_date";
 	}
 	
 	@RequestMapping("provided-services-admin")
 	public String getProvidedScheduling(HttpSession session) {
 		session.setAttribute("interval_date_scheduling", new ArrayList<Scheduling>());
 		return "scheduling/provided-service-admin";
 	}

 	@RequestMapping("get-provided-scheduling-admin-byDate-interval")
 	public String getProvidedSchedulingAdminByDateInterval(@RequestParam("initDate") @DateTimeFormat(pattern = "yyyy-MM-dd") String initDate,
 	        @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") String endDate, HttpSession session) {
 		List<Scheduling> schedulings = new SchedulingDAO(Scheduling.class).getProvidedSchedulingAdminByDateInterval(convertStringToCalendar(initDate),convertStringToCalendar(endDate));
 		session.setAttribute("interval_date_scheduling", schedulings);
 		return "scheduling/find_by_date_interval";
 	}
 	
 	@RequestMapping("excecuted-scheduling")
 	public String getExecutedService(HttpSession session) {
 		Account acc = (Account)session.getAttribute("user");
 		List<Scheduling> schedulings = new ArrayList<Scheduling>();
 		for(Scheduling s : new SchedulingDAO(Scheduling.class).getExecutedService())
 			if(s.getDog().getAccount().getId() == acc.getId())
 				schedulings.add(s);
 		System.out.println("scheduling size ===="+ schedulings.size());
 		session.setAttribute("executed_services",schedulings);
 		return "scheduling/executed-service";
 		
 		
 	}
 	
 	@ResponseBody
 	@RequestMapping("cancel-scheduling")
 	public void cancelScheduling(Scheduling scheduling) {
 		setStatusScheduling(scheduling.getId(), "Cancelado");
 	}
 	
 	@ResponseBody
 	@RequestMapping("make-scheduling")
 	public void makeScheduling(Scheduling scheduling) {
 		setStatusScheduling(scheduling.getId(), "Realizado");
 		DAO<Scheduling> dao = new DAO<Scheduling>(Scheduling.class);
 		scheduling = dao.getById(scheduling.getId());
 		Float total = scheduling.getAmmount();
 		if(scheduling.getServices().size() >= 3)
 			total -= total*0.1f;
 			scheduling.setAmmount(total);
 		dao.update(scheduling);
 	}
 	
 	public void setStatusScheduling(Long id, String status) {
 		DAO<Scheduling> dao = new DAO<Scheduling>(Scheduling.class);
 		Scheduling scheduling = dao.getById(id);
 		scheduling.setState(status);
 		dao.update(scheduling);	
 	}
 	
    public static Calendar convertStringToCalendar(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();

        try {
            calendar.setTime(sdf.parse(dateString));
        } catch (ParseException e) {
            e.printStackTrace();
            // Trate a exceção, se necessário
        }

        return calendar;
    }
 	
 	
}
