package uz.demo.task_hayot.service.contract;

import java.util.List;
import java.util.UUID;
import uz.demo.task_hayot.dto.base.IdResponse;
import uz.demo.task_hayot.dto.base.Response;
import uz.demo.task_hayot.dto.user.request.UserCreateRequest;
import uz.demo.task_hayot.dto.user.request.UserUpdateRequest;
import uz.demo.task_hayot.dto.user.response.UserCreateResponse;
import uz.demo.task_hayot.dto.user.response.UserResponse;

/**
 * @author Khudayberganov Nuriddin
 * @since : 09/05/25 / 11:21
 */
public interface UserService {

  Response<List<UserResponse>> retrieveUsers();


  Response<UserCreateResponse> createUser(UserCreateRequest request);

  Response<IdResponse> updateUser(UUID id, UserUpdateRequest request);
}
