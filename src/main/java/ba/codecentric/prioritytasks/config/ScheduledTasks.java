package ba.codecentric.prioritytasks.config;

import ba.codecentric.prioritytasks.domain.Task;
import ba.codecentric.prioritytasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ScheduledTasks {

    private TaskService taskService;

    @Autowired
    public ScheduledTasks(TaskService taskService) {
        this.taskService = taskService;
    }

    @Scheduled(cron = "0 0 12 * * ?")
    public void postponeAndDeleteTasks() throws Exception {

        LocalDate date = LocalDate.now();

        for (Task task : taskService.getAllCompletedTasks()) {
            taskService.deleteTask(task.getId());
        }

        for (Task task : taskService.getAllTasks(date)) {
            taskService.postponeTasks(task.getId());
        }

    }

}
