package fulltext.example.demo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public interface CustomBuildingRepository<T> {

  List<T> search(Class<T> clazz, String terms, String... fields);

}
