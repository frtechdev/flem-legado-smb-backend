/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.serializer;
/*    */ 
/*    */ import com.fasterxml.jackson.core.JsonGenerator;
/*    */ import com.fasterxml.jackson.core.JsonProcessingException;
/*    */ import com.fasterxml.jackson.databind.JsonSerializer;
/*    */ import com.fasterxml.jackson.databind.SerializerProvider;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class BooleanSerializer
/*    */   extends JsonSerializer<Boolean>
/*    */ {
/*    */   public void serialize(Boolean b, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
/* 13 */     jsonGenerator.writeString(b.booleanValue() ? "Sim" : "Não");
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\serializer\BooleanSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */