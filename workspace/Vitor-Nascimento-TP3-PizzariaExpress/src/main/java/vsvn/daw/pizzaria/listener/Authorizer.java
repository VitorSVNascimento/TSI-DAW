package vsvn.daw.pizzaria.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import vsvn.daw.pizzaria.manageBeans.ClientMB;
import vsvn.daw.pizzaria.manageBeans.EmployeeMB;

public class Authorizer implements PhaseListener{
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	  @Override
	    public void afterPhase(PhaseEvent event) {
	        FacesContext context = event.getFacesContext();
	        String viewId = context.getViewRoot().getViewId();

	        if ("/login.xhtml".equals(viewId) || "/login-client.xhtml".equals(viewId)) {
	            return;
	        }

	        EmployeeMB employeeMB = context.getApplication().evaluateExpressionGet(context, "#{employeeMB}",EmployeeMB.class);
	        
	        ClientMB clientMB = context.getApplication().evaluateExpressionGet(context, "#{clientMB}", ClientMB.class);
	        
	        if (viewId.startsWith("/client-") && !clientMB.isLogado()) { 
	                // Se um funcionário tentar acessar uma página exclusiva de clientes, redirecione para uma página de acesso negado
	                NavigationHandler handler = context.getApplication().getNavigationHandler();
	                handler.handleNavigation(context, null, "login-client?faces-redirect=true");
	                context.renderResponse();
	        }
	        
	        if (viewId.startsWith("/employee-") && !employeeMB.isLogado()){
		            NavigationHandler handler = context.getApplication().getNavigationHandler();
		            handler.handleNavigation(context, null, "login?faces-redirect=true");
		            context.renderResponse();
	        }
	        
	    }

	    @Override
	    public void beforePhase(PhaseEvent event) {
	        // Code for beforePhase if needed
	    }

	    @Override
	    public PhaseId getPhaseId() {
	        return PhaseId.RESTORE_VIEW;
	    }
	   
}
