package ba.codecentric.prioritytasks.repository;


import ba.codecentric.prioritytasks.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query(value = "SELECT t FROM Task t WHERE t.createdAt=?1 AND t.completed=false")
    List<Task> findByCreatedAt(Date date);
}
