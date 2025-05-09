package uz.demo.task_hayot.repository.criteria;

import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import uz.demo.task_hayot.dto.transaction.criteria.TransactionCriteria;
import uz.demo.task_hayot.entity.Transaction;
import uz.demo.task_hayot.repository.TransactionRepository;
import uz.demo.task_hayot.repository.TransactionSpecs;

/**
 * @author Khudayberganov Nuriddin
 * @since : 09/05/25 / 13:13
 */
@Repository
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TransactionCriteriaRepository {

  TransactionRepository repository;

  public List<Transaction> retrieveTransactions(TransactionCriteria criteria) {
    Specification<Transaction> specs = TransactionSpecs.filterByPerformedAt(criteria.getDateFrom(),
            criteria.getDateTo())
        .and(TransactionSpecs.filterByUserId(criteria.getUserId()));
    return repository.findAll(specs);
  }
}
