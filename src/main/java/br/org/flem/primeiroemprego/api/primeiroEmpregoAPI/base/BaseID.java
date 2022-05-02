package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public interface BaseID<ID extends Serializable> extends Serializable {
  ID getId();
  
  void setId(ID paramID);
}


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\base\BaseID.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */