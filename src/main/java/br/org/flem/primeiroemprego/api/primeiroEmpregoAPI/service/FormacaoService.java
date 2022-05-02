package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;

import org.springframework.stereotype.Service;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.FormacaoDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Formacao;

/**
 *
 * @author wfsilva
 */
@Service
public class FormacaoService {
   
    
    public FormacaoDTO parseEntityToDTO(Formacao entity) {
    	return new FormacaoDTO(entity.getId(), entity.getNome());
    }
}
