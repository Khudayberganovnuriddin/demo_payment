package uz.demo.task_hayot.dto.user.response;

import java.io.Serializable;
import java.util.UUID;
import lombok.Builder;
import uz.demo.task_hayot.enums.UserStatus;

/**
 * @author Khudayberganov Nuriddin
 * @since : 09/05/25 / 11:41
 */
@Builder
public record UserCreateResponse(UUID id, UserStatus status) implements Serializable {

}
