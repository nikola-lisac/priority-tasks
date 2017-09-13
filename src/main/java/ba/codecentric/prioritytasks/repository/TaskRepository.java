package ba.codecentric.prioritytasks.repository;


import ba.codecentric.prioritytasks.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByCreatedAt(LocalDate date);

    @Modifying
    @Query("UPDATE Task task SET task.completed = 1 WHERE task.id = ?1")
    void updateCompletedById(Integer id);
}
