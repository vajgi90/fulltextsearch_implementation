package fulltext.example.demo.utils;

import fulltext.example.demo.persistence.Building;
import fulltext.example.demo.persistence.MeetingRoom;
import fulltext.example.demo.persistence.Reservation;
import fulltext.example.demo.persistence.Role;
import fulltext.example.demo.persistence.User;
import fulltext.example.demo.repository.BuildingRepository;
import fulltext.example.demo.repository.MeetingRoomRepository;
import fulltext.example.demo.repository.ReservationRepository;
import fulltext.example.demo.repository.UserRepository;
import java.time.LocalDateTime;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@AllArgsConstructor
public class InitDataLoader {

  private final BuildingRepository buildingRepository;
  private final ReservationRepository reservationRepository;
  private final UserRepository userRepository;
  private final MeetingRoomRepository meetingRoomRepository;

  @PostConstruct
  public void init() {
    final var building1 = buildingRepository.save(Building.builder()
        .id(1L)
        .city("Budapest")
        .address("Kelemen Jancsi utca 11 2/6")
        .buildingName("Kék épület")
        .build());
    final var building2 = buildingRepository.save(Building.builder()
        .id(2L)
        .city("Kecskemét")
        .address("Kis István utca 131")
        .buildingName("Sarki zöld épület")
        .build());
    final var building3 = buildingRepository.save(Building.builder()
        .id(3L)
        .city("Salgótarján")
        .address("Szegedi út 125")
        .buildingName("Piac melletti épület")
        .build());
    final var building4 = buildingRepository.save(Building.builder()
        .id(4L)
        .city("Göd")
        .address("Vörös utca 38-40")
        .buildingName("Marika ABC melletti épület")
        .build());
    final var building5 = buildingRepository.save(Building.builder()
        .id(5L)
        .city("Győr")
        .address("Győri utca 28 3/28")
        .buildingName("Kék osztriga bár melletti épület")
        .build());
    final var building6 = buildingRepository.save(Building.builder()
        .id(6L)
        .city("Budapest")
        .address("Kelemen Ákos utca 12 2/6")
        .buildingName("Kék kakas")
        .build());

    userRepository.save(User.builder()
        .id("10769150350006150715113082367")
        .username("misi@gmail.com")
        .role(Role.ADMIN)
        .accountNonExpired(true)
        .accountNonLocked(true)
        .enabled(true)
        .build());
    userRepository.save(User.builder()
        .id("10769150350006150715113077777")
        .username("isti@gmail.com")
        .role(Role.USER)
        .accountNonExpired(true)
        .accountNonLocked(true)
        .enabled(true)
        .build());
    userRepository.save(User.builder()
        .id("99999150350006150715113077777")
        .username("klau@gmail.com")
        .role(Role.USER)
        .accountNonExpired(true)
        .accountNonLocked(true)
        .enabled(true)
        .build());
    userRepository.save(User.builder()
        .id("8888150350006150715113077777")
        .username("htpeti@gmail.com")
        .role(Role.READER)
        .accountNonExpired(true)
        .accountNonLocked(true)
        .enabled(true)
        .build());
    userRepository.save(User.builder()
        .id("11111110350006150715113077777")
        .username("berentep@gmail.com")
        .role(Role.ADMIN)
        .accountNonExpired(true)
        .accountNonLocked(true)
        .enabled(true)
        .build());
    userRepository.save(User.builder()
        .id("99999910350006150715113077777")
        .username("schlange@gmail.com")
        .role(Role.READER)
        .accountNonExpired(true)
        .accountNonLocked(true)
        .enabled(true)
        .build());

/*    reservationRepository.save(Reservation.builder()
        .id(1L)
        .user(userRepository.findById("99999150350006150715113077777").orElse(null))
        .meetingRoom(meetingRoomRepository.findById(1l).orElse(null))
        .title("Napi meeting")
        .summary("Megbeszéljük ki mivel haladt tegnap és mivel fog ma foglalkozni.")
        .startingTime(LocalDateTime.of(2020, 2, 17, 16, 00))
        .endingTime(LocalDateTime.of(2020, 2, 17, 18, 00)).build());
    reservationRepository.save(Reservation.builder()
        .id(2L)
        .user(userRepository.findById("99999150350006150715113077777").orElse(null))
        .meetingRoom(meetingRoomRepository.findById(2l).orElse(null))
        .title("Flow tárgyalás")
        .summary("Új ügyfelek felkutatása.")
        .startingTime(LocalDateTime.now())
        .endingTime(LocalDateTime.now()).build());
    reservationRepository.save(Reservation.builder()
        .id(3L)
        .user(userRepository.findById("10769150350006150715113077777").orElse(null))
        .meetingRoom(meetingRoomRepository.findById(1l).orElse(null))
        .title("Húsvét")
        .summary("húsvéti program megbeszélése Pennywise-al")
        .startingTime(LocalDateTime.now())
        .endingTime(LocalDateTime.now()).build());
    reservationRepository.save(Reservation.builder()
        .id(4L)
        .user(userRepository.findById("10769150350006150715113077777").orElse(null))
        .meetingRoom(meetingRoomRepository.findById(2l).orElse(null))
        .title("Karácsony")
        .summary("Megbeszéljük hogy mikor tartsuk illetve ki melyik zenekart szeretné ")
        .startingTime(LocalDateTime.now())
        .endingTime(LocalDateTime.now()).build());
    reservationRepository.save(Reservation.builder()
        .id(5L)
        .user(userRepository.findById("10769150350006150715113082367").orElse(null))
        .meetingRoom(meetingRoomRepository.findById(2l).orElse(null))
        .title("Tesla")
        .summary("Tesla gyár látogatásának időpontja")
        .startingTime(LocalDateTime.now())
        .endingTime(LocalDateTime.now()).build());*/

    meetingRoomRepository.save(MeetingRoom.builder()
        .id(1l)
        .name("Ügyfél fogadó")
        .numberOfSeats(5)
        .building(building1)
        .projector(false).build());
    meetingRoomRepository.save(MeetingRoom.builder()
        .id(2l)
        .name("Igazgatói tárgyaló")
        .numberOfSeats(20)
        .building(building2)
        .projector(true).build());
    meetingRoomRepository.save(MeetingRoom.builder()
        .id(3l)
        .name("Kék ajtós iroda")
        .numberOfSeats(10)
        .building(building3)
        .projector(true).build());
    meetingRoomRepository.save(MeetingRoom.builder()
        .id(4l)
        .name("Piros ajtós iroda")
        .numberOfSeats(2)
        .building(building4)
        .projector(false).build());
    meetingRoomRepository.save(MeetingRoom.builder()
        .id(5l)
        .name("Zöld iroda")
        .numberOfSeats(8)
        .projector(false)
        .building(building5)
        .build());
  }
}
