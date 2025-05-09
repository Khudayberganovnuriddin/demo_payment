package uz.demo.task_hayot.dto.transaction.response;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Khudayberganov Nuriddin
 * @since : 09/05/25 / 12:28
 */
public record TransactionResponse(UUID id, UUID userId, String operationType, UUID serviceId,
                                  String senderCard, String senderCardExpiry,
                                  Double transactionAmount,
                                  String transactionCurrency,
                                  String status, LocalDateTime performedAt, LocalDateTime failedAt) implements Serializable {

}
