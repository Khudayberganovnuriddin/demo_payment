package uz.demo.task_hayot.repository;

import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.data.jpa.domain.Specification;
import uz.demo.task_hayot.entity.Transaction;

/**
 * @author Khudayberganov Nuriddin
 * @since : 09/05/25 / 13:19
 */
public final class TransactionSpecs {

  private TransactionSpecs() throws IllegalAccessException {
    throw new IllegalAccessException("Can't be initialized");
  }

  public static Specification<Transaction> filterByPerformedAt(LocalDateTime dateFrom,
      LocalDateTime dateTo) {
    return (root, query, cb) -> dateFrom != null && dateTo != null
        ? cb.between(root.get("performedAt"), dateFrom, dateTo)
        : cb.conjunction();
  }

  public static Specification<Transaction> filterBySenderId(UUID userId) {
    return (root, query, cb) -> userId != null
        ? cb.equal(root.get("userId"), userId)
        : cb.conjunction();
  }
}
