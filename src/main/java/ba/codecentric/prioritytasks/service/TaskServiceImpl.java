package ba.codecentric.prioritytasks.service;

import ba.codecentric.prioritytasks.domain.Task;
import ba.codecentric.prioritytasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService{

    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl (TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task saveTask (Task task) {
        return taskRepository.save(task);
    }
}
