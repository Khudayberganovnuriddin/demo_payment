package uz.demo.task_hayot.dto.transaction.request;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Khudayberganov Nuriddin
 * @since : 09/05/25 / 12:28
 */
public record TransactionCreateRequest(UUID userId, UUID serviceId, Double amount,
                                       String currency) implements Serializable {

}
