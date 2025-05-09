package uz.demo.task_hayot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import uz.demo.task_hayot.enums.OperationType;
import uz.demo.task_hayot.enums.TransactionStatus;

/**
 * @author Khudayberganov Nuriddin
 * @since : 06/05/25 / 11:30
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions",
indexes = {@Index(name = "TransactionIndexBySenderId", columnList = "sender_id")})
public class Transaction extends AbstractAuditingEntity<UUID> {

  @Id
  @Column(unique = true)
  private UUID id = UUID.randomUUID();

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private OperationType operationType;

  private UUID userId;
  private UUID serviceId;

  @Column(nullable = false)
  private Double transactionAmount;

  @Column(nullable = false, length = 3)
  private String transactionCurrency;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private TransactionStatus status;

  private LocalDateTime performedAt;

  private LocalDateTime failedAt;

  @Override
  public UUID getId() {
    return id;
  }
}
