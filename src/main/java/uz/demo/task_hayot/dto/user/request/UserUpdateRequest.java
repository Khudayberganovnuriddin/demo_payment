package uz.demo.task_hayot.dto.user.request;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Khudayberganov Nuriddin
 * @since : 09/05/25 / 11:55
 */
@JsonPropertyOrder({"phoneNumber", "firstName", "middleName", "lastName", "status"})
public record UserUpdateRequest(String phoneNumber, String firstName, String middleName,
                                String lastName, String status) {

}
