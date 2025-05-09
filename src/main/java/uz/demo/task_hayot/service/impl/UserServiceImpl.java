package uz.demo.task_hayot.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import uz.demo.task_hayot.converter.response.UserResponseConverter;
import uz.demo.task_hayot.dto.base.IdResponse;
import uz.demo.task_hayot.dto.base.Response;
import uz.demo.task_hayot.dto.user.request.UserCreateRequest;
import uz.demo.task_hayot.dto.user.request.UserUpdateRequest;
import uz.demo.task_hayot.dto.user.response.UserCreateResponse;
import uz.demo.task_hayot.dto.user.response.UserResponse;
import uz.demo.task_hayot.entity.User;
import uz.demo.task_hayot.enums.UserStatus;
import uz.demo.task_hayot.repository.UserRepository;
import uz.demo.task_hayot.service.contract.UserService;

/**
 * @author Khudayberganov Nuriddin
 * @since : 09/05/25 / 11:58
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {

  UserRepository repository;
  UserResponseConverter responseConverter;

  @Override
  public Response<List<UserResponse>> retrieveUsers() {
    return new Response<>(repository.findAll().stream()
        .map(responseConverter::from)
        .toList());
  }

  @Override
  public Response<UserCreateResponse> createUser(UserCreateRequest request) {
    User user = new User();
    user.setFirstName(request.firstName());
    user.setMiddleName(request.middleName());
    user.setLastName(request.lastName());
    user.setPhoneNumber(request.phoneNumber());
    user.setStatus(UserStatus.ACTIVE);
    User saved = repository.save(user);
    return new Response<>(UserCreateResponse.builder()
        .id(saved.getId())
        .status(saved.getStatus())
        .build());
  }

  @Override
  public Response<IdResponse> updateUser(UUID id, UserUpdateRequest request) {
    AtomicReference<User> atomicReference = new AtomicReference<>();
    repository.findById(id).ifPresent(user -> {
      user.setFirstName(request.firstName());
      user.setMiddleName(request.middleName());
      user.setLastName(request.lastName());
      user.setPhoneNumber(request.phoneNumber());
      user.setStatus(UserStatus.getStatus(request.status()));
      atomicReference.set(repository.save(user));
    });
    return new Response<>(new IdResponse(atomicReference.get().getId()));
  }
}
