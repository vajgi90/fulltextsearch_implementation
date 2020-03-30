package fulltext.example.demo.controller;

import fulltext.example.demo.Term;
import fulltext.example.demo.persistence.Building;
import fulltext.example.demo.service.BuildingService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/buildings")
@AllArgsConstructor
public class BuildingResource {

  @Autowired
  private BuildingService buildingService;

  @PostMapping
  public List<Building> findAllByTerm(@RequestBody Term search) {
    return buildingService.findAllByTerms(search.term);
  }

  @GetMapping
  public List<Building> findAll() {
    return buildingService.findAll();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Building> updateBuilding(@PathVariable Long id,
      @RequestBody Building building) {
    buildingService.updateBuilding(id, building);
    return ResponseEntity.accepted().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteBuilding(@PathVariable Long id) {
    buildingService.deleteBuilding(id);
    return ResponseEntity.noContent().build();
  }
}
