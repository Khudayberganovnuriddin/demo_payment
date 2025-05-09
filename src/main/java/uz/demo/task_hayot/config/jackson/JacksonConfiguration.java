package uz.demo.task_hayot.config.jackson;

import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Khudayberganov Nuriddin
 * @since : 09/05/25 / 15:33
 */
@Configuration
@RequiredArgsConstructor
public class JacksonConfiguration {

  @Bean
  public Jackson2ObjectMapperBuilderCustomizer jacksonCustomizer() {
    String datetimeFormat = "dd.MM.yyyy HH:mm:ss";
    return builder -> builder
        .simpleDateFormat(datetimeFormat)
        .deserializerByType(UUID.class, new UUIDDeserializer())
        .serializerByType(ZonedDateTime.class, new ZonedDateTimeSerializer(datetimeFormat))
        .serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(datetimeFormat))
        .deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(datetimeFormat));
  }

}
