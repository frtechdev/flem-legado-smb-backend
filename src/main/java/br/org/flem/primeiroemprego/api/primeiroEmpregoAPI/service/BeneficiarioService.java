package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.AbstractHelper;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao.BeneficiarioDAO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.BeneficiarioDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.BeneficiarioQuestionarioDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Beneficiario;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.User;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.util.SMBUtil;

/**
 *
 * @author tscortes
 */
@Service
public class BeneficiarioService extends AbstractHelper{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6460276020336286183L;

	@Autowired
	private BeneficiarioDAO beneficiarioDAO;

	@Autowired
	private FormacaoService formacaoService;
	
	@Autowired
    private ModelMapper modelMapper;

	public Beneficiario findById(Long id) {
		return beneficiarioDAO.findOne(id);
	}

	public BeneficiarioDTO dtoFindById(Long id) {
		return parseEntityToDTO(beneficiarioDAO.findOne(id));
	}

	public BeneficiarioDTO parseEntityToDTO(Beneficiario entity) {
		return new BeneficiarioDTO(entity.getId(), entity.getNome(), entity.getSexo(),
				formacaoService.parseEntityToDTO(entity.getFormacao()));
	}
	
	public BeneficiarioQuestionarioDTO obterBeneficiarioDTOLogado() {
		User user = getUserLogged();
		SMBUtil.throwException(user == null || user.getCodigoDominio() == null, "UsuÃ¡rio nÃ£o localizado");
		return findByMatriculaFlem(user.getCodigoDominio());
	}
	
	public Beneficiario obterBeneficiarioLogado() {
		User user = getUserLogged();
		SMBUtil.throwException(user == null || user.getCodigoDominio() == null, "UsuÃ¡rio nÃ£o localizado");
		return beneficiarioDAO.findByMatriculaFlem(""+user.getCodigoDominio());
	}
	
	public BeneficiarioQuestionarioDTO findByMatriculaFlem(Integer matricula) {
		SMBUtil.throwException(matricula == null, "Matricula Ã© obrigatÃ³rio");
		return toBeneficiarioQuestionarioDTO(beneficiarioDAO.findByMatriculaFlem(""+matricula));
	}
	
	private BeneficiarioQuestionarioDTO toBeneficiarioQuestionarioDTO(Beneficiario beneficiario) {
		if( beneficiario == null)
			return null;
		return modelMapper.map(beneficiario, BeneficiarioQuestionarioDTO.class);	
	}
}