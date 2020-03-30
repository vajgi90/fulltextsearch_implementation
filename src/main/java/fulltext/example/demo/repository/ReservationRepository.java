package fulltext.example.demo.repository;

import fulltext.example.demo.persistence.Reservation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

  List<Reservation> findByUser_Id(String id);

  List<Reservation> findByMeetingRoom_Id(Long id);
}
