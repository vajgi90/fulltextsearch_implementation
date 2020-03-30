package fulltext.example.demo;

import fulltext.example.demo.persistence.Building;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

public class CustomBuildingRepositoryImpl<T> implements CustomBuildingRepository<T> {

  @PersistenceContext
  private EntityManager em;

  @Override
  public List<T> search(Class<T> clazz, String terms, String... fields) {
    FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(em);

    QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
        .buildQueryBuilder().forEntity(clazz).get();
    org.apache.lucene.search.Query luceneQuery = queryBuilder
        .keyword()
        .wildcard()
        .onFields(fields)
        .matching(terms)
        .createQuery();

    // wrap Lucene query in a javax.persistence.Query
    javax.persistence.Query jpaQuery =
        fullTextEntityManager.createFullTextQuery(luceneQuery, Building.class);

    // execute search
    return jpaQuery.getResultList();
  }
}
