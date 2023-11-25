package vsvn.daw.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import vsvn.daw.petshop.dao.EmployeeDAO;
import vsvn.daw.petshop.models.Employee;

@Controller
public class AdminController {
	
	@RequestMapping("formulario-admin")
	public String employeeForm() {
		return "admin/formulario-admin";
	}
	
	@RequestMapping("admin-validate")
	public String adminValidate(Employee employee,HttpSession session) {
		employee = new EmployeeDAO(Employee.class).loginVerify(employee); 
		if(employee  == null) {
			System.out.println("Account nula");
			return "redirect:formulario-admin";
			
		}
		session.setAttribute("employee", employee);
		return "redirect:admin-page";
	}
	
	@RequestMapping("employee-logout")
	public String employeeLogout(HttpSession session) {
		session.setAttribute("employee",null);
		session.setAttribute("user",null);
		session.invalidate();
		return "redirect:formulario-admin";
	}
	
	@RequestMapping("admin-page")
	public String adminPage() {
		return "admin/admin";
	}
	
	
}
