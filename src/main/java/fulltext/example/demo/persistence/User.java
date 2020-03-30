package fulltext.example.demo.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "_user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

  private static final String DEFAULT_TRUE = "BOOLEAN default true";

  @Id
  @Column(length = 100)
  private String id;
  @Column(unique = true, length = 100)
  private String username;
  @Transient
  @JsonIgnore
  private String password;
  @Enumerated(EnumType.STRING)
  private Role role;
  @Transient
  @JsonIgnore
  private Map<String, Object> attributes;
  @Column(columnDefinition = DEFAULT_TRUE)
  private boolean enabled;
  @Column(columnDefinition = DEFAULT_TRUE)
  private boolean accountNonExpired;
  @Column(columnDefinition = DEFAULT_TRUE)
  private boolean accountNonLocked;
  @Column(columnDefinition = DEFAULT_TRUE)
  private boolean credentialsNonExpired;

}
