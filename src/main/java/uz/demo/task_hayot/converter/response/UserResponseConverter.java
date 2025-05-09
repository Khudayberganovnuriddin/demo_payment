package uz.demo.task_hayot.converter.response;

import org.springframework.stereotype.Component;
import uz.demo.task_hayot.converter.BasicConverter;
import uz.demo.task_hayot.dto.user.response.UserResponse;
import uz.demo.task_hayot.entity.User;

/**
 * @author Khudayberganov Nuriddin
 * @since : 09/05/25 / 11:59
 */
@Component
public class UserResponseConverter extends BasicConverter<User, UserResponse> {

  public UserResponseConverter() {
    super(
        user -> new UserResponse(
            user.getId(),
            user.getFirstName(),
            user.getMiddleName(),
            user.getLastName(),
            user.getPhoneNumber(),
            user.getStatus()
        ),
        userResponse -> new User()
    );
  }

}
