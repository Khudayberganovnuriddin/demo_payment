package uz.demo.task_hayot.property;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Khudayberganov Nuriddin
 * @since : 21/06/24 / 20:46
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "cors")
public class CorsProperty {

  private List<String> allowedHeaders;
  private List<String> allowedOrigins;
  private List<String> allowedMethods;
  private List<String> exposedHeaders;
  private String urlPattern;
  private boolean allowCredentials;
}
