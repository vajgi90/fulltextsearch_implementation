package fulltext.example.demo.repository;

import fulltext.example.demo.persistence.MeetingRoom;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Long> {

  List<MeetingRoom> findByBuilding_Id(Long id);
}
