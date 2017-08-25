package ba.codecentric.prioritytasks.controller;

import ba.codecentric.prioritytasks.domain.Task;
import ba.codecentric.prioritytasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(value = "/tasks")
    public Task saveNewTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @GetMapping(value = "/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping(value = "/tasks/{date}")
    public List<Task> getAllTasks(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) throws Exception {

        List<Task> tasks = taskService.getAllTasks(date);
        if (tasks.isEmpty()) {
            throw new Exception("No more tasks");
        }
        return tasks;
    }

    @DeleteMapping(value = "/tasks/{id}")
    public void completeTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
    }
}
