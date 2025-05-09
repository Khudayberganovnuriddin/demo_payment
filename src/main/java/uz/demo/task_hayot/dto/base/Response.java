package uz.demo.task_hayot.dto.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * @author Khudayberganov Nuriddin
 * @since : 09/05/25 / 11:28
 */
@Getter
@Setter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Response<T> {

  T data;
  String error;
  Long timestamp;

  public Response(T data) {
    this.data = data;
    this.error = "";
    this.timestamp = System.currentTimeMillis();
  }

  public Response(String error, T data) {
    this.error = error;
    this.data = data;
    this.timestamp = System.currentTimeMillis();
  }
}
