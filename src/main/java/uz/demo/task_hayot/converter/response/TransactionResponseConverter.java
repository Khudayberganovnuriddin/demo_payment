package uz.demo.task_hayot.converter.response;

import org.springframework.stereotype.Component;
import uz.demo.task_hayot.converter.BasicConverter;
import uz.demo.task_hayot.dto.transaction.response.TransactionResponse;
import uz.demo.task_hayot.entity.Transaction;

/**
 * @author Khudayberganov Nuriddin
 * @since : 09/05/25 / 12:52
 */
@Component
public class TransactionResponseConverter extends BasicConverter<Transaction, TransactionResponse> {

  public TransactionResponseConverter() {
    super(
        transaction -> new TransactionResponse(
            transaction.getId(),
            transaction.getOperationType().name(),
            transaction.getUserId(),
            transaction.getServiceId(),
            transaction.getTransactionAmount(),
            transaction.getTransactionCurrency(),
            transaction.getStatus().name(),
            transaction.getPerformedAt(),
            transaction.getFailedAt()
        ),
        transactionResponse -> new Transaction()
    );
  }
}
