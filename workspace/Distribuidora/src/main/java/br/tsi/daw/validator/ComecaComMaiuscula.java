package br.tsi.daw.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("comecaComMaiuscula")
public class ComecaComMaiuscula implements Validator {
	public void validate(FacesContext fc, UIComponent component, Object value)
			throws ValidatorException {
		String valor = value.toString();
		if (!valor.matches("[A-Z].*")) {
			throw new ValidatorException(new FacesMessage(
					"Deveria começar com letra maiúscula"));
		}
	}
}
