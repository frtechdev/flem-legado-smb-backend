/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;
/*     */ 
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao.ColaboradorDAO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.ColaboradorDTO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.DemandanteDTO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.DemandanteMunicipioDTO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.FuncionarioDTO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.MunicipioDTO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Colaborador;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.EscritorioRegional;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.MonitorDemandante;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Municipio;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.URLDecoder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.stream.Collectors;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class ColaboradorService
/*     */ {
/*     */   @Autowired
/*     */   private ColaboradorDAO dao;
/*     */   @Autowired
/*     */   private MonitorDemandanteService monitorDemandanteService;
/*     */   @Autowired
/*     */   private EscritorioRegionalService escritorioRegionalService;
/*     */   @Autowired
/*     */   private MunicipioService municipioService;
/*     */   @Autowired
/*     */   private ColaboradorService colaboradorService;
/*     */   @Autowired
/*     */   private VagaService vagaService;
/*     */   
/*     */   public List<ColaboradorDTO> findByEscritorioRegional(EscritorioRegional escritorio) {
/*  50 */     List<ColaboradorDTO> lista = this.dao.findByEscritorioRegional(escritorio);
/*  51 */     lista.forEach(item -> item.setAssociacoes(obterAssociacoes(item.getId(), null)));
/*  52 */     return lista;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ColaboradorDTO> findByEscritorioRegional(Long idEscritorio) {
/*  60 */     EscritorioRegional escritorio = this.escritorioRegionalService.findById(idEscritorio);
/*  61 */     return findByEscritorioRegional(escritorio);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ColaboradorDTO> findAll() {
/*  68 */     List<ColaboradorDTO> lista = this.dao.findByAtivoTrue();
/*  69 */     lista.forEach(item -> item.setAssociacoes(obterAssociacoes(item.getId(), null)));
/*     */ 
/*     */     
/*  72 */     return lista;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Colaborador findById(Long id) {
/*  80 */     return (Colaborador)this.dao.findOne(id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Colaborador> findByIdIn(List<Long> ids) {
/*  88 */     return this.dao.findByIdIn(ids);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Colaborador findByEmail(String email) {
/*  96 */     return this.dao.findByEmailAndAtivoTrue(email);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<DemandanteMunicipioDTO> obterAssociacoes(Long id, List<Long> idsMunicipios) {
/*     */     List<MonitorDemandante> associacoes;
/* 106 */     Colaborador colaborador = findById(id);
/* 107 */     List<DemandanteMunicipioDTO> listaRetorno = new ArrayList<>();
/*     */     
/* 109 */     if (idsMunicipios != null && !idsMunicipios.isEmpty()) {
/* 110 */       List<Municipio> municipios = this.municipioService.findByIdIn(idsMunicipios);
/* 111 */       associacoes = this.monitorDemandanteService.findByMunicipioInAndColaborador(municipios, colaborador);
/*     */     } else {
/* 113 */       associacoes = this.monitorDemandanteService.findByColaborador(colaborador);
/*     */     } 
/*     */     
/* 116 */     if (associacoes != null && !associacoes.isEmpty()) {
/* 117 */       associacoes.forEach(item -> {
/*     */             DemandanteMunicipioDTO dto = new DemandanteMunicipioDTO(item.getDemandante().getId(), item.getMunicipio().getId(), item.getDemandante().getNome(), item.getMunicipio().getNome());
/*     */             
/*     */             dto.setId(item.getId());
/*     */             listaRetorno.add(dto);
/*     */           });
/*     */     }
/* 124 */     return listaRetorno;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<FuncionarioDTO> findByDemandanteAndMunicipio(Long idMonitor, List<Long> idDemandante, List<Long> idMunicipio) {
/* 134 */     return this.vagaService.findByDemandanteAndMunicipio(idMonitor, idDemandante, idMunicipio);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<FuncionarioDTO> obterFuncionarioPorUnidade(Long monitor, String unidadeDeLotacao, Long idMunicipio, Long idDemandante) throws UnsupportedEncodingException {
/* 146 */     String decodedParam = "";
/* 147 */     if (unidadeDeLotacao != null) {
/* 148 */       decodedParam = URLDecoder.decode(unidadeDeLotacao, "UTF-8");
/*     */     }
/* 150 */     String[] unidades = { decodedParam };
/* 151 */     Long[] municipios = { idMunicipio };
/* 152 */     Long[] demandantes = { idDemandante };
/* 153 */     return this.vagaService.obterBeneficiariosPorUnidadesDeLotacaoAndMunsAndDems(monitor, Arrays.asList(unidades), Arrays.asList(municipios), Arrays.asList(demandantes));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<DemandanteDTO> getDemandantes(Long idMonitor, List<Long> idMunicipios) {
/* 163 */     List<Municipio> municipios = this.municipioService.findByIdIn(idMunicipios);
/* 164 */     Colaborador colaborador = this.colaboradorService.findById(idMonitor);
/* 165 */     List<MonitorDemandante> monitores = this.monitorDemandanteService.findByMunicipioInAndColaborador(municipios, colaborador);
/* 166 */     List<DemandanteDTO> demandantesDTO = new ArrayList<>();
/* 167 */     monitores.forEach(moni -> {
/*     */           DemandanteDTO dto = new DemandanteDTO();
/*     */           dto.setIdDemandante(moni.getDemandante().getId());
/*     */           dto.setNomeDemandante(moni.getDemandante().getNome());
/*     */           dto.setIdMunicipio(moni.getMunicipio().getId());
/*     */           dto.setNomeMunicipio(moni.getMunicipio().getNome());
/*     */           demandantesDTO.add(dto);
/*     */         });
/* 175 */     return demandantesDTO;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<MunicipioDTO> getMunicipios(Long idMonitor) {
/* 183 */     Colaborador colaborador = this.colaboradorService.findById(idMonitor);
/* 184 */     List<MonitorDemandante> monitorDemandante = this.monitorDemandanteService.findByColaborador(colaborador);
/* 185 */     Set<MunicipioDTO> dtos = new HashSet<>();
/* 186 */     if (monitorDemandante != null && !monitorDemandante.isEmpty()) {
/* 187 */       monitorDemandante.forEach(moniDem -> {
/*     */             MunicipioDTO dto = new MunicipioDTO();
/*     */             dto.setId(moniDem.getMunicipio().getId());
/*     */             dto.setNome(moniDem.getMunicipio().getNome());
/*     */             dtos.add(dto);
/*     */           });
/*     */     }
/* 194 */     return (List<MunicipioDTO>)dtos.stream().sorted(Comparator.comparing(MunicipioDTO::getNome)).collect(Collectors.toList());
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\service\ColaboradorService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */