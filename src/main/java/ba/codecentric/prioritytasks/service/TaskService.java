package ba.codecentric.prioritytasks.service;

import ba.codecentric.prioritytasks.domain.Task;
import ba.codecentric.prioritytasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        List<Task> tttt = taskRepository.findAll();
        return taskRepository.findAll();
    }

    public List<Task> getAllTasks(LocalDate date) {
        return taskRepository.findByCreatedAt(date);
    }

    public Task getTask(Integer taskId) throws Exception {

        Task task = taskRepository.findOne(taskId);

        if (task == null) {
            throw new Exception("No task with that ID");
        }

        LocalDate date = LocalDate.now().plusDays(1);
       task.setCreatedAt(date);

        return taskRepository.save(task);
    }
}
