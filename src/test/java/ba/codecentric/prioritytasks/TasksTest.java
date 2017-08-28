package ba.codecentric.prioritytasks;

import ba.codecentric.prioritytasks.controller.TaskController;
import ba.codecentric.prioritytasks.domain.Task;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Date;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TasksTest {

    @Mock
    private TaskController taskService;

    private static Validator validator;

    private MockMvc mockMvc;

    private final Logger log = Logger.getLogger(TasksTest.class);

    @Test
    public void getTasks() {
        when(taskService.getAllTasks()).thenReturn(new ArrayList<>());
    }

    @Test
    public void saveNewTasks() {
        Task task = getTask();
        task.setId(null);
        when(taskService.saveNewTask(task)).thenReturn(task);
    }

    @Test
    public void postponeTasks() throws Exception {
        Task task = getTask();
        when(taskService.postponeTasks(task.getId())).thenReturn(new Task());
    }

    private Task getTask() {
        Task task = new Task();
        task.setId(1);
        task.setCreatedAt(new Date());
        task.setName("Do something");
        task.setCompleted(false);
        return task;
    }
}
