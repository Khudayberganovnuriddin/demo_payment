package uz.demo.task_hayot.controller;

import java.util.List;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.demo.task_hayot.dto.user.request.UserUpdateRequest;
import uz.demo.task_hayot.dto.base.IdResponse;
import uz.demo.task_hayot.dto.base.Response;
import uz.demo.task_hayot.dto.user.request.UserCreateRequest;
import uz.demo.task_hayot.dto.user.response.UserCreateResponse;
import uz.demo.task_hayot.dto.user.response.UserResponse;
import uz.demo.task_hayot.service.contract.UserService;

/**
 * @author Khudayberganov Nuriddin
 * @since : 09/05/25 / 11:20
 */
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController {

  UserService userService;

  @GetMapping
  public Response<List<UserResponse>> getUsers() {
    return userService.retrieveUsers();
  }

  @PostMapping
  public Response<UserCreateResponse> create(@RequestBody UserCreateRequest request) {
    return userService.createUser(request);
  }

  @PutMapping(value = "/{id}")
  public Response<IdResponse> update(@PathVariable UUID id, @RequestBody UserUpdateRequest request) {
    return userService.updateUser(id, request);
  }
}
