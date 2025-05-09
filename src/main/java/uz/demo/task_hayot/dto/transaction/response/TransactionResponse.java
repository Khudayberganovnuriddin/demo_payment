package uz.demo.task_hayot.dto.transaction.response;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Khudayberganov Nuriddin
 * @since : 09/05/25 / 12:28
 */
public record TransactionResponse(UUID id, String operationType, UUID userId, UUID serviceId,
                                  Double transactionAmount, String transactionCurrency,
                                  String status, LocalDateTime performedAt,
                                  LocalDateTime failedAt) implements Serializable {

}
