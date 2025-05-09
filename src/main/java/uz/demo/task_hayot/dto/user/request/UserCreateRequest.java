package uz.demo.task_hayot.dto.user.request;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Khudayberganov Nuriddin
 * @since : 09/05/25 / 11:36
 */
@JsonPropertyOrder({"firstName", "middleName", "lastName", "phoneNumber"})
public record UserCreateRequest(String firstName, String middleName, String lastName,
                                String phoneNumber) {

}
