package fulltext.example.demo.service;

import fulltext.example.demo.persistence.MeetingRoom;
import fulltext.example.demo.persistence.Reservation;
import fulltext.example.demo.persistence.ReservationInput;
import fulltext.example.demo.persistence.User;
import fulltext.example.demo.repository.MeetingRoomRepository;
import fulltext.example.demo.repository.ReservationRepository;
import fulltext.example.demo.repository.UserRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@AllArgsConstructor
@Transactional
public class ReservationService {

  private ReservationRepository reservationRepository;
  private UserRepository userRepository;
  private MeetingRoomRepository meetingRoomRepository;

  public List<Reservation> findAll() {
    return reservationRepository.findAll();
  }

  public List<Reservation> findReservationsByUserId(String id) {
    return reservationRepository.findByUser_Id(id);
  }

  public List<Reservation> findReservationsByMeetingRoomId(Long id) {
    return reservationRepository.findByMeetingRoom_Id(id);
  }

  public Optional<Reservation> findOne(Long id) {
    return reservationRepository.findById(id);
  }

  public Reservation createReservation(ReservationInput reservationInput) {
    validateReservation(reservationInput);
    User user = userRepository.findById(reservationInput.getUserId()).orElseThrow(() -> new RuntimeException("User not found in DB"));
    MeetingRoom mRoom = meetingRoomRepository.findById(reservationInput.getMeetingRoomId()).orElseThrow(() -> new RuntimeException("MeetingRoom not found in DB"));
    Reservation reservation = reservationInput.toSaveEntity(user, mRoom);
    return reservationRepository.save(reservation);
  }

  public void deleteReservation(Long id) {
    reservationRepository.deleteById(id);
  }

  public Reservation updateReservation(Long id, ReservationInput reservationInput) {
    if (reservationRepository.findById(id).isPresent()) {
      validateReservation(reservationInput);
      User user = userRepository.findById(reservationInput.getUserId())
          .orElseThrow(() -> new RuntimeException("User not found in DB"));
      MeetingRoom mRoom = meetingRoomRepository.findById(reservationInput.getMeetingRoomId())
          .orElseThrow(() -> new RuntimeException("MeetingRoom not found in DB"));
      Reservation reservation = reservationInput.toUpdateEntity(id, user, mRoom);
      return reservationRepository.save(reservation);
    }
    throw new RuntimeException("Reservation not found in DB");
  }

  private void validateReservation(ReservationInput input) {
    if (StringUtils.isEmpty(input.getUserId())) {
      throw new RuntimeException("User Id is neccessary to make a reservation!");
    }
    if (Objects.isNull(input.getMeetingRoomId())) {
      throw new RuntimeException("MeetingRoom Id is neccessary to make a reservation!");
    }
    if (Objects.isNull(input.getStartingTime())) {
      throw new RuntimeException("Start time is neccessary to make a reservation!");
    }
    if (Objects.isNull(input.getEndingTime())) {
      throw new RuntimeException("End time is neccessary to make a reservation!");
    }
    if (StringUtils.isEmpty(input.getTitle())) {
      throw new RuntimeException("Title is neccessary to make a reservation!");
    }
  }
}
