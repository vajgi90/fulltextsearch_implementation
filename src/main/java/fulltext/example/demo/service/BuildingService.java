package fulltext.example.demo.service;

import fulltext.example.demo.persistence.Building;
import fulltext.example.demo.repository.BuildingRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BuildingService {

  @Autowired
  BuildingRepository buildingRepository;

  public Building createBuilding(Building building) {
    return buildingRepository.save(building);
  }

  public Building updateBuilding(Long id, Building building) {
    building.setId(id);
    return buildingRepository.save(building);
  }

/*  public List<Building> findByCityPage(String term, PageRequest page) {
    return buildingRepository.findByCity2(term, page);
  }*/

  public void deleteBuilding(Long id) {
    buildingRepository.deleteById(id);
  }

  public Optional<Building> findOne(Long id) {
    return buildingRepository.findById(id);
  }

/*  public List<Building> findAll(Integer pageNumber, Integer pageSize) {
    return buildingRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
  }*/

  public List<Building> findAll() {
  return buildingRepository.findAll();
  }

  public List<Building> findAllByTerms(String term) {
    return buildingRepository.search(Building.class, term, "address", "city");
  }

  public List<String> findAllCities() {
    return buildingRepository.findAllCities();
  }

  public List<Building> findByCity(String city) {
    return buildingRepository.findByCity(city);
  }
}
