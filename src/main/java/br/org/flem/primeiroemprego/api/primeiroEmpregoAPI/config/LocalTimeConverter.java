/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.config;
/*    */ 
/*    */ import java.sql.Time;
/*    */ import java.time.LocalTime;
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
/*    */ @Converter(autoApply = true)
/*    */ public class LocalTimeConverter
/*    */   implements AttributeConverter<LocalTime, Time>
/*    */ {
/*    */   public Time convertToDatabaseColumn(LocalTime localTime) {
/* 20 */     return (localTime == null) ? null : Time.valueOf(localTime);
/*    */   }
/*    */ 
/*    */   
/*    */   public LocalTime convertToEntityAttribute(Time time) {
/* 25 */     return (time == null) ? null : time.toLocalTime();
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\config\LocalTimeConverter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */