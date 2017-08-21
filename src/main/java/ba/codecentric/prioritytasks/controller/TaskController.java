package ba.codecentric.prioritytasks.controller;

import ba.codecentric.prioritytasks.domain.Task;
import ba.codecentric.prioritytasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Task> getAllTask() {
        return taskService.getAllTask();
    }

    @GetMapping(value = "/today/tasks")
    public List<Task> getTodayTask() throws Exception {

        List<Task> tasks = taskService.getTodayTask();
        if (tasks.size() == 0) throw new Exception("No task for today");

        return taskService.getTodayTask();
    }

    @GetMapping(value = "/tomorrow/tasks")
    public List<Task> getTomorrowTask() throws Exception {

        List<Task> tasks = taskService.getTomorrowTask();
        if (tasks.size() == 0) throw new Exception("No task for tomorrow");

        return taskService.getTomorrowTask();
    }
}
