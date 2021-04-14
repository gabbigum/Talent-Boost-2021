package com.vmware.talentboost.spring.tasks.controller;

import com.vmware.talentboost.spring.tasks.data.Task;
import com.vmware.talentboost.spring.tasks.data.TaskStatus;
import com.vmware.talentboost.spring.tasks.impl.TaskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.OnError;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskManager taskManager;

    /**
     * Merges all completed and uncompleted tasks.
     * @return list of tasks
     */
    @GetMapping("/tasks")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Task> getTasks() {
        return taskManager.getAllTasks(null);
    }

    @GetMapping("/tasks/{taskId}")
    @ResponseStatus(code = HttpStatus.OK)
    public Task getTaskById(@PathVariable int taskId) {
        Task task = taskManager.getTask(taskId);
        return task == null ? null : taskManager.getTask(taskId);
    }

    @PostMapping("/tasks")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void postTask(@RequestBody Task task) {
        taskManager.addTask(task);
    }

    @PutMapping("/tasks/{taskId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void updateTask(@RequestBody Task task, @PathVariable int taskId) {
        taskManager.updateTask(taskId, task);
    }

    @DeleteMapping("/tasks/{taskId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable int taskId) {
        taskManager.deleteTask(taskId);
    }
}
