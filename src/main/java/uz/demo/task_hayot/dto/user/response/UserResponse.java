package uz.demo.task_hayot.dto.user.response;

import java.io.Serializable;
import java.util.UUID;
import uz.demo.task_hayot.enums.UserStatus;

/**
 * @author Khudayberganov Nuriddin
 * @since : 09/05/25 / 11:48
 */
public record UserResponse(UUID id, String firstName, String middleName, String lastName,
                           String phoneNumber, UserStatus status) implements Serializable {

}
