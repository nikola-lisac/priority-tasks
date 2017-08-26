package ba.codecentric.prioritytasks.service;

import ba.codecentric.prioritytasks.domain.Task;
import ba.codecentric.prioritytasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class TaskService {

  private final TaskRepository taskRepository;

  @Autowired
  public TaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public Task saveTask(Task task) {
    return taskRepository.save(task);
  }

  public List<Task> getAllTasks() {
    return taskRepository.findAll();
  }

  public List<Task> getAllTasks(Date date) {
    return taskRepository.findByCreatedAt(date);
  }

  @Transactional
  public void updateComplete(Integer id) {
    taskRepository.updateCompletedById(id);
  }
}
