package uz.demo.task_hayot.config.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeSerializer extends JsonSerializer<ZonedDateTime> {

  private final DateTimeFormatter formatter;

  public ZonedDateTimeSerializer(String pattern) {
    this.formatter = DateTimeFormatter.ofPattern(pattern);
  }

  @Override
  public void serialize(ZonedDateTime value, JsonGenerator gen, SerializerProvider serializers)
      throws IOException {
    gen.writeString(formatter.format(value));
  }
}
