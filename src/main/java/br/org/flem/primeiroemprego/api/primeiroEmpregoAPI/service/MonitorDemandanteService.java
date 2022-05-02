/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;
/*     */ 
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseSpecification;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.CriteriaOpereration;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.SearchCriteria;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao.MonitorDemandanteDAO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.DemandanteMunicipioDTO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.FuncionarioDTO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Colaborador;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Demandante;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.MonitorDemandante;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Municipio;
/*     */ import java.time.LocalDateTime;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.jpa.domain.Specification;
/*     */ import org.springframework.data.jpa.domain.Specifications;
/*     */ import org.springframework.security.core.context.SecurityContextHolder;
/*     */ import org.springframework.security.core.userdetails.UserDetails;
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
/*     */ public class MonitorDemandanteService
/*     */ {
/*     */   @Autowired
/*     */   private MonitorDemandanteDAO dao;
/*     */   @Autowired
/*     */   private ColaboradorService colaboradorService;
/*     */   @Autowired
/*     */   private DemandanteService demandanteService;
/*     */   @Autowired
/*     */   private MunicipioService municipioService;
/*     */   @Autowired
/*     */   private VagaService vagaService;
/*     */   
/*     */   public Iterable<MonitorDemandante> findAll() {
/*  46 */     return this.dao.findAll();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<MonitorDemandante> findByColaborador(Colaborador colaborador) {
/*  54 */     return this.dao.findByMonitorOrderByMunicipioNomeAsc(colaborador);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MonitorDemandante findByMunicipioAndDemandante(Municipio municipio, Demandante demandante) {
/*  63 */     return this.dao.findByMunicipioAndDemandante(municipio, demandante);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MonitorDemandante findByMunicipioAndDemandanteAndColaborador(Municipio municipio, Demandante demandante, Colaborador colaborador) {
/*  73 */     return this.dao.findByMunicipioAndDemandanteAndMonitor(municipio, demandante, colaborador);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<MonitorDemandante> findByMunicipioInAndColaboradorNot(List<Municipio> municipio, Colaborador colaborador) {
/*  82 */     return this.dao.findByMunicipioInAndMonitorNot(municipio, colaborador);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<MonitorDemandante> findByMunicipioInAndColaborador(List<Municipio> municipio, Colaborador colaborador) {
/*  91 */     return this.dao.findByMunicipioInAndMonitor(municipio, colaborador);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<MonitorDemandante> findByDemandanteInAndMonitor(List<Demandante> demandantes, Colaborador colaborador) {
/* 101 */     return this.dao.findByDemandanteInAndMonitor(demandantes, colaborador);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void associar(Long idMonitor, List<DemandanteMunicipioDTO> selecionados) throws MonitoramentoException {
/* 110 */     if (idMonitor != null) {
/* 111 */       Colaborador monitorSelecionado = this.colaboradorService.findById(idMonitor);
/* 112 */       if (selecionados != null && !selecionados.isEmpty()) {
/* 113 */         selecionados.forEach(sel -> {
/*     */               MonitorDemandante monitorDemandante = new MonitorDemandante();
/*     */               monitorDemandante.setMonitor(monitorSelecionado);
/*     */               Demandante demandante = this.demandanteService.findById(sel.getIdDemandante());
/*     */               Municipio municipio = this.municipioService.findById(sel.getIdMunicipio());
/*     */               monitorDemandante.setDemandante(demandante);
/*     */               monitorDemandante.setMunicipio(municipio);
/*     */               save(monitorDemandante);
/*     */             });
/*     */       }
/*     */     } else {
/* 124 */       throw new MonitoramentoException("Monitor não informado");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void desassociar(Long id) {
/* 132 */     MonitorDemandante ass = (MonitorDemandante)this.dao.findOne(id);
/* 133 */     if (ass != null) {
/* 134 */       this.dao.delete(ass);
/*     */     } else {
/* 136 */       throw new MonitoramentoException("Associação não localizada");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void preSave(MonitorDemandante monitorDemandante) {
/* 144 */     monitorDemandante.setDataAtualizacao(LocalDateTime.now());
/* 145 */     monitorDemandante.setDataCriacao(LocalDateTime.now());
/* 146 */     monitorDemandante.setUsuarioAtualizacao(getCurrentUser());
/* 147 */     monitorDemandante.setUsuarioCriacao(getCurrentUser());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private MonitorDemandante save(MonitorDemandante monitorDemandante) {
/* 155 */     MonitorDemandante obj = findByMunicipioAndDemandanteAndColaborador(monitorDemandante.getMunicipio(), monitorDemandante.getDemandante(), monitorDemandante.getMonitor());
/* 156 */     if (obj != null) {
/* 157 */       return obj;
/*     */     }
/* 159 */     preSave(monitorDemandante);
/* 160 */     return (MonitorDemandante)this.dao.save(monitorDemandante);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<FuncionarioDTO> findByMunicipio(List<Long> idMunicipio) {
/* 169 */     return this.vagaService.findByMunicipio(idMunicipio);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<FuncionarioDTO> findByDemandante(List<Long> idDemandante) {
/* 178 */     return this.vagaService.findByDemandante(idDemandante);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<FuncionarioDTO> findByDemandanteAndMunicipio(List<Long> idDemandante, List<Long> idMunicipio) {
/* 188 */     return this.vagaService.findByDemandanteAndMunicipio(null, idDemandante, idMunicipio);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String getCurrentUser() {
/*     */     String username;
/* 196 */     Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
/*     */     
/* 198 */     if (principal instanceof UserDetails) {
/* 199 */       username = ((UserDetails)principal).getUsername();
/*     */     } else {
/* 201 */       username = principal.toString();
/*     */     } 
/* 203 */     return username;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<MonitorDemandante> findByMonitorAndDemandanteAndMunicipio(List<Long> idMonitores, List<Long> idDdemandantes, List<Long> idMunicipios) {
/* 212 */     List<Demandante> demandantes = this.demandanteService.findByIdIn(idDdemandantes);
/* 213 */     List<Municipio> municipios = this.municipioService.findByIdIn(idMunicipios);
/* 214 */     List<Colaborador> monitores = this.colaboradorService.findByIdIn(idMonitores);
/* 215 */     return this.dao.findAll((Specification)filtro(monitores, demandantes, municipios));
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
/*     */   
/*     */   private Specifications filtro(List<Colaborador> monitores, List<Demandante> demandantes, List<Municipio> municipios) {
/* 228 */     return Specifications.where((Specification)new BaseSpecification(new SearchCriteria("demandante", CriteriaOpereration.IN, demandantes))).and((Specification)new BaseSpecification(new SearchCriteria("monitor", CriteriaOpereration.IN, monitores))).and((Specification)new BaseSpecification(new SearchCriteria("municipio", CriteriaOpereration.IN, municipios)));
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\service\MonitorDemandanteService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */