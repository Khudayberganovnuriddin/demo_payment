package uz.demo.task_hayot.service.contract;

import java.util.List;
import uz.demo.task_hayot.dto.base.IdResponse;
import uz.demo.task_hayot.dto.transaction.criteria.TransactionCriteria;
import uz.demo.task_hayot.dto.transaction.request.TransactionCreateRequest;
import uz.demo.task_hayot.dto.transaction.response.TransactionResponse;

/**
 * @author Khudayberganov Nuriddin
 * @since : 09/05/25 / 12:26
 */
public interface TransactionService {

  List<TransactionResponse> retrieveTransactions(TransactionCriteria criteria);

  IdResponse create(TransactionCreateRequest request);
}
