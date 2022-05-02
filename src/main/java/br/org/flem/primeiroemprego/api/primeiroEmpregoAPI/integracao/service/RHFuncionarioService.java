/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.integracao.service;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.integracao.dao.RHFuncionarioDAO;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.integracao.model.RHFuncionario;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class RHFuncionarioService
/*    */ {
/*    */   @Autowired
/*    */   private RHFuncionarioDAO rhFuncionarioDAO;
/*    */   
/*    */   public RHFuncionario findByMatricula(Integer matricula) {
/* 20 */     RHFuncionario funcionario = this.rhFuncionarioDAO.findByMatricula(matricula);
/* 21 */     if (funcionario == null) {
/* 22 */       throw new MonitoramentoException("Erro: Funcionário não localizado!");
/*    */     }
/* 24 */     return funcionario;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Iterable<RHFuncionario> findAll(Integer matricula) {
/* 32 */     return this.rhFuncionarioDAO.findAll();
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\integracao\service\RHFuncionarioService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */