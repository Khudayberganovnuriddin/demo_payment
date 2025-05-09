package uz.demo.task_hayot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import java.io.Serial;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import uz.demo.task_hayot.enums.UserStatus;

/**
 * @author Khudayberganov Nuriddin
 * @since : 06/05/25 / 11:24
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends AbstractAuditingEntity<UUID> {

  @Serial
  private static final long serialVersionUID = 5474966026969092558L;

  @Id
  @Column(unique = true)
  private UUID id = UUID.randomUUID();

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "middle_name")
  private String middleName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "balance")
  private Double balance = 0.0;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  private UserStatus status = UserStatus.INACTIVE;

  @Override
  public UUID getId() {
    return id;
  }
}
