package ba.codecentric.prioritytasks.controller;

import ba.codecentric.prioritytasks.domain.Task;
import ba.codecentric.prioritytasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController (TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(value = "/tasks")
    public Task saveNewTask (@RequestBody Task task) {
        return taskService.saveTask(task);
    }
}
