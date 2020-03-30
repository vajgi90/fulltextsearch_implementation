package fulltext.example.demo.persistence;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationInput {

  private String userId;

  private Long meetingRoomId;

  private Long startingTime;

  private Long endingTime;

  private String title;

  private String summary;

  public Reservation toSaveEntity(User user, MeetingRoom meetingRoom) {
    Reservation reservation = new Reservation();
    reservation.setUser(user);
    reservation.setMeetingRoom(meetingRoom);
    BeanUtils.copyProperties(this, reservation);
    return reservation;
  }

  public Reservation toUpdateEntity(Long id, User user, MeetingRoom meetingRoom) {
    Reservation reservation = new Reservation();
    reservation.setId(id);
    reservation.setUser(user);
    reservation.setMeetingRoom(meetingRoom);
    BeanUtils.copyProperties(this, reservation);
    return reservation;
  }
}
