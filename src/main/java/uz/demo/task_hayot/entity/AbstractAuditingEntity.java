package uz.demo.task_hayot.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author Khudayberganov Nuriddin
 * @since : 09/05/25 / 12:09
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditingEntity<T> implements Serializable {

  @Serial
  private static final long serialVersionUID = -1533148217905778091L;

  public abstract T getId();

}
