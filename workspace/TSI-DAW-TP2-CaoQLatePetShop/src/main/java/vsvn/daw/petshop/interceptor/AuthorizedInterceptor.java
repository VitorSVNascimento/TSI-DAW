package vsvn.daw.petshop.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthorizedInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception{
		
		String uri = req.getRequestURI();
		
		if(uri.endsWith("login-page") || uri.endsWith("login-validate") || uri.endsWith("novaConta") || uri.endsWith("adicionarConta")
			|| uri.endsWith("validate-email") || uri.endsWith("formulario-admin")|| 
		 uri.endsWith("admin-validate")	|| uri.contains("resources") )
			return true;
		
		//Páginas do administrador
		if(req.getSession().getAttribute("employee") != null && (uri.endsWith("admin-page") || uri.endsWith("employee-logout")
				|| uri.endsWith("service-page") || uri.endsWith("registrar-servico") || uri.endsWith("agenda-servico-admin") 
				|| uri.endsWith("get-scheduling-admin-byDate")))
			return true;
		
		//Páginas do usuário
		if(req.getSession().getAttribute("user") != null && (!uri.endsWith("admin-page") || !uri.endsWith("employee-logout")
				|| !uri.endsWith("service-page") || !uri.endsWith("registrar-servico") || !uri.endsWith("agenda-servico-admin")
				|| !uri.endsWith("get-scheduling-admin-byDate")))
			return true;
		
		resp.sendRedirect("login-page");
		return false;
		
	}
	
}
