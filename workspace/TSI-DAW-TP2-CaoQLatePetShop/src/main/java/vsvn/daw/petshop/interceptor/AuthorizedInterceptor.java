package vsvn.daw.petshop.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthorizedInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception{
		
		String uri = req.getRequestURI();
		
		if(uri.endsWith("login-page") || uri.endsWith("login-validate") || uri.endsWith("novaConta") || uri.endsWith("adicionarConta")
			|| uri.endsWith("validate-email")	|| uri.contains("resources"))
			return true;
		
		if(req.getSession().getAttribute("user") != null)
			return true;
		
		resp.sendRedirect("login-page");
		return false;
		
	}
	
}
