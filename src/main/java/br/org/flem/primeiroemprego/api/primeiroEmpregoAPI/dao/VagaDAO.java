package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Beneficiario;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Demandante;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Municipio;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Vaga;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections.DemandanteMunicipioProj;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections.DemandanteProj;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections.FuncionarioProj;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections.MunicipioProj;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface VagaDAO extends JpaRepository<Vaga, Long>, JpaSpecificationExecutor<Vaga> {
  @Query(" select va.egresso.dataAdmissao as dataAdmissao, dem.nome as nomeDemandante, va.egresso.nome as nomeFuncionario, va.municipio.nome as nomeMunicipio,  dem.id as idDemandante, va.egresso.id as idFuncionario, va.municipio.id as idMunicipio  from Vaga va join va.demandante dem where va.demandante in ( ?1 ) and (va.situacao.categoria.id = 3 or va.situacao.categoria.id = 6) order by va.egresso.nome")
  List<FuncionarioProj> findByDemandanteIn(List<Demandante> paramList);
  
  @Query(" select va.egresso.dataAdmissao as dataAdmissao, dem.nome as nomeDemandante, va.egresso.nome as nomeFuncionario, va.municipio.nome as nomeMunicipio,  dem.id as idDemandante, va.egresso.id as idFuncionario, va.municipio.id as idMunicipio  from Vaga va join va.demandante dem where va.municipio in ( ?1 ) and (va.situacao.categoria.id = 3 or va.situacao.categoria.id = 6) order by va.egresso.nome")
  List<FuncionarioProj> findByMunicipioIn(List<Municipio> paramList);
  
  @Query(" select va.egresso.cpf as cpf, va.egresso.dataAdmissao as dataAdmissao, va.egresso.formacao.nome as formacao, dem.nome as nomeDemandante, va.egresso.nome as nomeFuncionario, va.municipio.nome as nomeMunicipio,  dem.id as idDemandante, va.egresso.id as idFuncionario, va.municipio.id as idMunicipio, va.egresso.matriculaFlem as matricula, va.egresso.sexo as sexo, va.unidadeDeLotacao as unidadeDeLotacao  from Vaga va join va.demandante dem where va.municipio in ( ?1 ) and va.demandante in ( ?2 ) and (va.situacao.categoria.id = 3 or va.situacao.categoria.id = 6) order by va.egresso.nome")
  List<FuncionarioProj> findByMunicipioInAndDemandanteIn(List<Municipio> paramList, List<Demandante> paramList1);
  
  Vaga findByEgresso(Beneficiario paramBeneficiario);
  
  @Query(" select distinct va.unidadeDeLotacao from Vaga va order by va.unidadeDeLotacao")
  List<String> obterTodasUnidadeLotacao();
  
  @Query(" select distinct va.unidadeDeLotacao from Vaga va where va.demandante.id in ( ?1 ) order by va.unidadeDeLotacao")
  List<String> obterUnidadeLotacaoByDemandantes(List<Long> paramList);
  
  @Query(" select distinct va.unidadeDeLotacao from Vaga va where va.demandante.id in ( ?1 ) and va.municipio.id in ( ?2 ) order by va.unidadeDeLotacao")
  List<String> obterUnidadeLotacaoByDemandantesAndMunicipios(List<Long> paramList1, List<Long> paramList2);
  
  @Query("SELECT count(distinct dem.id) as countDemandantes, mun.id as id, mun.nome as nome FROM Vaga vag INNER JOIN vag.municipio mun INNER JOIN vag.demandante dem group by mun.nome, mun.id order by mun.nome ")
  List<MunicipioProj> findAllMunicipiosVaga();
  
  @Query("SELECT distinct dem.id as id, dem.nome as nome, dem.sigla as sigla FROM Vaga vag INNER JOIN vag.municipio mun INNER JOIN vag.demandante dem order by dem.nome")
  List<DemandanteProj> findAllDemandatesVaga();
  
  @Query("SELECT distinct dem.id as idDemandante, mun.id as idMunicipio, dem.nome as nomeDemandante, mun.nome as nomeMunicipio FROM Vaga vag INNER JOIN vag.municipio mun INNER JOIN vag.demandante dem WHERE vag.municipio in (?1) and not exists( select 1 from MonitorDemandante md where md.demandante = dem and md.municipio = mun) order by dem.nome ")
  List<DemandanteMunicipioProj> findByVagaMunicipioNaoAssociados(List<Municipio> paramList);
  
  @Query("SELECT distinct dem.id as idDemandante, mun.id as idMunicipio, dem.nome as nomeDemandante, mun.nome as nomeMunicipio FROM Vaga vag INNER JOIN vag.municipio mun INNER JOIN vag.demandante dem WHERE vag.municipio in (?1) order by dem.nome")
  List<DemandanteMunicipioProj> findByVagaMunicipio(List<Municipio> paramList);
}


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dao\VagaDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */