package ba.codecentric.prioritytasks.repository;


import ba.codecentric.prioritytasks.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByCreatedAt(LocalDate date);
}
