package br.tsi.distribuidora.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.tsi.distribuidora.mb.UsuarioMB;


public class Autorizador implements PhaseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();
		
		if("/login.xhtml".equals(context.getViewRoot().getViewId())) 
			return;
		
		UsuarioMB usuarioMB = context.getApplication().evaluateExpressionGet(
					context, "#{usuarioMB}", UsuarioMB.class
				);
		
		if(!usuarioMB.isLogado()) {
			NavigationHandler handler = context.getApplication().getNavigationHandler();
			handler.handleNavigation(context, null, "login?faces-redirect=true");
			context.renderResponse();
		}
		
	}
	
	@Override
	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return PhaseId.RESTORE_VIEW;
	}

}
