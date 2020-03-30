package fulltext.example.demo.repository;


import fulltext.example.demo.CustomBuildingRepository;
import fulltext.example.demo.persistence.Building;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long>,
    CustomBuildingRepository {

  @Query("select distinct city from Building b")
  List<String> findAllCities();

  List<Building> findByCity(String city);

  @Query(value = "SELECT * FROM buildings WHERE MATCH (city, address) AGAINST (*?1* IN NATURAL LANGUAGE MODE);",nativeQuery = true)
  List<Building> findByTerm(String term);

}
