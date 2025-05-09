package uz.demo.task_hayot.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.demo.task_hayot.entity.User;

/**
 * @author Khudayberganov Nuriddin
 * @since : 09/05/25 / 11:42
 */
public interface UserRepository extends JpaRepository<User, UUID> {

}
