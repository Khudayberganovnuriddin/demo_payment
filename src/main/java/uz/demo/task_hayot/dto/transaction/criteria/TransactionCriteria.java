package uz.demo.task_hayot.dto.transaction.criteria;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Khudayberganov Nuriddin
 * @since : 09/05/25 / 13:15
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransactionCriteria {

  private ZonedDateTime dateFrom;
  private ZonedDateTime dateTo;
  private UUID userId;

  public LocalDateTime getDateFrom() {
    if (dateFrom == null) {
      return null;
    }
    return dateFrom.toLocalDateTime();
  }

  public LocalDateTime getDateTo() {
    if (dateTo == null) {
      return null;
    }
    return dateTo.toLocalDateTime();
  }
}
