package fulltext.example.demo.controller;

import fulltext.example.demo.persistence.Reservation;
import fulltext.example.demo.persistence.ReservationInput;
import fulltext.example.demo.service.ReservationService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/reservations")
@AllArgsConstructor
public class ReservationResource {

  private ReservationService reservationService;

  @GetMapping
  public ResponseEntity<List<Reservation>> findAll() {
    List<Reservation> reservations = reservationService.findAll();
    return new ResponseEntity<>(reservations, HttpStatus.OK);
  }

  @GetMapping("/{userId}/users")
  public ResponseEntity<List<Reservation>> findByUserId(@PathVariable String userId) {
    return new ResponseEntity<>(reservationService.findReservationsByUserId(userId), HttpStatus.OK);
  }

  @GetMapping("/{meetingRoomId}/meetingrooms")
  public ResponseEntity<List<Reservation>> findByMeetingRoomId(@PathVariable Long meetingRoomId) {
    return new ResponseEntity<>(reservationService.findReservationsByMeetingRoomId(meetingRoomId),
        HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Reservation> findOne(@PathVariable Long id) {
    return reservationService.findOne(id).map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Reservation> createReservation(@RequestBody ReservationInput reservation) {
    return new ResponseEntity<>(reservationService.createReservation(reservation),
        HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Reservation> updateReservation(@PathVariable Long id,
      @RequestBody ReservationInput reservation) {
    reservationService.updateReservation(id, reservation);
    return ResponseEntity.accepted().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
    reservationService.deleteReservation(id);
    return ResponseEntity.noContent().build();
  }
}