package br.com.zup.casadocodigo.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casadocodigo.dto.ClienteDTO;

@Component
public class VerificaTipoDocumento implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ClienteDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		if(errors.hasErrors()) {
			return;
		}
		
		ClienteDTO clienteDto = (ClienteDTO) target;
		if(!clienteDto.documentoValido()) {
			errors.rejectValue("documento", null, "Documento deve ser CPF ou CNPJ");
		}

	}

}
