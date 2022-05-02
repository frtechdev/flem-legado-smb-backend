/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.config;
/*    */ 
/*    */ import java.sql.Timestamp;
/*    */ import java.time.LocalDateTime;
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
/*    */ @Converter(autoApply = true)
/*    */ public class LocalDateTimeConverter
/*    */   implements AttributeConverter<LocalDateTime, Date>
/*    */ {
/*    */   public Date convertToDatabaseColumn(LocalDateTime attribute) {
/* 21 */     return (attribute == null) ? null : Timestamp.valueOf(attribute);
/*    */   }
/*    */ 
/*    */   
/*    */   public LocalDateTime convertToEntityAttribute(Date dbData) {
/* 26 */     return (dbData == null) ? null : dbData.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\config\LocalDateTimeConverter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */