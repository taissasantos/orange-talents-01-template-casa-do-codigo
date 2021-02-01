package br.com.zup.casadocodigo.validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casadocodigo.dto.ClienteDTO;
import br.com.zup.casadocodigo.model.Estado;
import br.com.zup.casadocodigo.model.Pais;

@Component
public class EstadoPertencePaisValidator implements Validator {
	
	@PersistenceContext
	private EntityManager manager;
	

	@Override
	public boolean supports(Class<?> clazz) {
		return ClienteDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		ClienteDTO request = (ClienteDTO) target;
		
		Pais pais = manager.find(Pais.class, request.getIdPais());
		Estado estado = manager.find(Estado.class, request.getIdEstado());
		
		if(!estado.pertenceAoPais(pais)) {
			errors.rejectValue("idEstado", null, "Estado não pertence ao pais selecionado");
		}

	}

}
