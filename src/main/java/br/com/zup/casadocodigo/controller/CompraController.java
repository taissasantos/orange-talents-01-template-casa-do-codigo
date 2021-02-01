package br.com.zup.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.dto.ClienteDTO;
import br.com.zup.casadocodigo.validator.EstadoPertencePaisValidator;
import br.com.zup.casadocodigo.validator.VerificaTipoDocumento;

@RestController
public class CompraController {
	
	@Autowired
	private EstadoPertencePaisValidator estadoPertencePaisValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(new VerificaTipoDocumento(),estadoPertencePaisValidator );
	}
	
	@PostMapping(value = "/finalizar")
	public String criaCompra(@RequestBody @Valid ClienteDTO clienteDto){
		return clienteDto.toString();
		
	}

}
