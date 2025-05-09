package uz.demo.task_hayot.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import uz.demo.task_hayot.entity.Transaction;

/**
 * @author Khudayberganov Nuriddin
 * @since : 09/05/25 / 12:30
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID>,
    JpaSpecificationExecutor<Transaction> {

}
