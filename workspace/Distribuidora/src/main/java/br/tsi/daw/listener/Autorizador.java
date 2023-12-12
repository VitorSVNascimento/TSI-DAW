package br.tsi.daw.listener;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.tsi.daw.managebeans.UsuarioMB;


public class Autorizador implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent event) {		
		FacesContext context = event.getFacesContext();
		
		if ("/login.xhtml".equals(context.getViewRoot().getViewId())) {
			return;
		}
		
		UsuarioMB usuarioMB = context.getApplication().evaluateExpressionGet
				(context, "#{usuarioMB}", UsuarioMB.class);
		
		if (!usuarioMB.isLogado()) {
			NavigationHandler handler = context.getApplication().getNavigationHandler();
			
			handler.handleNavigation(context, null, "login?faces-redirect=true");
			
			context.renderResponse();
		}
	}

	@Override
	public void beforePhase(PhaseEvent event) {		

	}

	@Override
	public PhaseId getPhaseId() {		
		return PhaseId.RESTORE_VIEW;
	}
}
