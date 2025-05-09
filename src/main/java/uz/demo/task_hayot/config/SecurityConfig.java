package uz.demo.task_hayot.config;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import uz.demo.task_hayot.property.CorsProperty;

/**
 * @author Khudayberganov Nuriddin
 * @since : 09/05/25 / 14:04
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SecurityConfig {

  CorsProperty corsProperty;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http
        .cors(cors -> cors.configurationSource(corsConfigurationSource()))
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(httpReq -> httpReq.anyRequest().permitAll())
        .sessionManagement(sessionManagement -> sessionManagement
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .build();
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    return urlBasedCorsConfigurationSource();
  }

  private UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource() {
    var source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration(corsProperty.getUrlPattern(), buildConfig());
    return source;
  }

  private CorsConfiguration buildConfig() {
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.setAllowedHeaders(corsProperty.getAllowedHeaders());
    corsConfiguration.setAllowedOrigins(corsProperty.getAllowedOrigins());
    corsConfiguration.setAllowedMethods(corsProperty.getAllowedMethods());
    corsConfiguration.setAllowCredentials(corsProperty.isAllowCredentials());
    corsConfiguration.setExposedHeaders(corsProperty.getExposedHeaders());
    return corsConfiguration;
  }
}
