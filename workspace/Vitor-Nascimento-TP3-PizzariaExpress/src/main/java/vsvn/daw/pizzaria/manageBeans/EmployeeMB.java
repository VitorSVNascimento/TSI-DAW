package vsvn.daw.pizzaria.manageBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import vsvn.daw.pizzaria.dao.EmployeeDAO;
import vsvn.daw.pizzaria.models.Employee;

@SessionScoped
@ManagedBean
public class EmployeeMB {
	private Employee employee = new Employee();

	public String loga() {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		Employee logedEmployee = employeeDAO.findEmployee(employee);
		if (logedEmployee == null) {
			System.out.println("olaaa");
			employee = new Employee();
			return "login?faces-redirect=true";
			
		}
		employee = logedEmployee;
		
		if (logedEmployee.getUserType().equals("admin"))
			return "employee-admin-page?faces-redirect=true";
		
		return "employee-coz-not-serverd?faces-redirect=true";
		
	}
	
	public boolean isLogado() {
		return employee.getUsername() != null;
	}
	
	public boolean isCozinha() {
		if ( employee.getUserType() == null || employee.getUserType().isBlank() || !employee.getUserType().equals("cozinha"))
			return false;
		return true;
	}
	public boolean isAdm() {
		if ( employee.getUserType() == null || employee.getUserType().isBlank() || !employee.getUserType().equals("admin"))
			return false;
		return true;
	}
	
	public String logout() {
		employee = new Employee();
		return "login?faces-redirect=true";
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
