/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.config;
/*    */ 
/*    */ import java.time.LocalDate;
/*    */ import java.time.ZoneId;
/*    */ import java.util.Date;
/*    */ import javax.persistence.AttributeConverter;
/*    */ import javax.persistence.Converter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Converter(autoApply = true)
/*    */ public class LocalDateConverter
/*    */   implements AttributeConverter<LocalDate, Date>
/*    */ {
/*    */   public Date convertToDatabaseColumn(LocalDate attribute) {
/* 22 */     return (attribute == null) ? null : Date.from(attribute.atStartOfDay(ZoneId.systemDefault()).toInstant());
/*    */   }
/*    */ 
/*    */   
/*    */   public LocalDate convertToEntityAttribute(Date dbData) {
/* 27 */     return (dbData == null) ? null : dbData.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\config\LocalDateConverter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */