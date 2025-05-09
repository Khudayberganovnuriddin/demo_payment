package uz.demo.task_hayot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class TaskHayotApplication {

  public static void main(String[] args) {
    SpringApplication.run(TaskHayotApplication.class, args);
  }

}
