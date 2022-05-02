package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface MyCrudRepository<T extends BaseModel<I>, I extends java.io.Serializable> extends CrudRepository<T, I>, JpaSpecificationExecutor<T> {}


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\base\MyCrudRepository.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */