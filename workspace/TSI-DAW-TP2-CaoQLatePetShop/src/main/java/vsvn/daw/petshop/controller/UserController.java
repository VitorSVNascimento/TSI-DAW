package vsvn.daw.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import vsvn.daw.petshop.dao.AccountDAO;
import vsvn.daw.petshop.dao.ConfirmationTokenDAO;
import vsvn.daw.petshop.dao.DAO;
import vsvn.daw.petshop.email.PetShopEMail;
import vsvn.daw.petshop.models.Account;
import vsvn.daw.petshop.models.ConfirmationToken;

@Controller
public class UserController {
	
	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("novaConta")
	public String formNewClient() {
		return "account/novaConta";
	}
	
	@RequestMapping("adicionarConta")
	public String insert(Account user) {
		AccountDAO dao = new AccountDAO(Account.class);
		dao.insert(user);
		
		String token_string = PetShopEMail.sendConfirmationLinkToUser(user.getName(), user.getEmail());
		
		ConfirmationToken token = new ConfirmationToken();
		Account account = dao.getByCpf(user.getCpf());
		System.out.println("Aloooo = " + account.getId());
		token.setAccount(account);
		token.setToken(token_string);
		
		DAO<ConfirmationToken> tokenDAO = new DAO<ConfirmationToken>(ConfirmationToken.class);
		tokenDAO.insert(token);
		
		return "account/adicionado";
	}
	
//	http://127.0.0.1/validate-email?token=%s
	@RequestMapping("validate-email")
	public String validateAccountEmail(@RequestParam String token) {
		ConfirmationTokenDAO dao = new ConfirmationTokenDAO(ConfirmationToken.class);
		ConfirmationToken tokenData = dao.getByToken(token);
		Account acc = tokenData.getAccount();
		acc.setValid(true);
		
		DAO<Account> accDAO = new DAO<Account>(Account.class);
		accDAO.update(acc);
		return "account/validado";
		
	}
	
	@RequestMapping("login-page")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping("login-validate")
	public String loginValidate(Account account,HttpSession session) {
		account = new AccountDAO(Account.class).loginVerify(account); 
		if(account  == null) {
			System.out.println("Account nula");
			return "redirect:login-page";
			
		}
		session.setAttribute("user", account);
		return "redirect:index";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.setAttribute("user",null);
		session.setAttribute("employee",null);
		session.invalidate();
		return "redirect:login-page";
	}
	
}
