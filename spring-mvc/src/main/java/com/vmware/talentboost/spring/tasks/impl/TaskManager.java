package com.vmware.talentboost.spring.tasks.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.vmware.talentboost.spring.tasks.IRepository;
import com.vmware.talentboost.spring.tasks.ITaskManager;
import com.vmware.talentboost.spring.tasks.data.Task;
import com.vmware.talentboost.spring.tasks.data.TaskStatus;

@Component
public class TaskManager implements ITaskManager {

    private final IRepository repository;

    public TaskManager(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Task> getAllTasks(TaskStatus status) {
        if (status != null) {
            return repository.getTasksByCompletionStatus(status == TaskStatus.COMPLETED);
        } else {
            return repository.getAllTasks();
        }
    }

    @Override
    public Task getTask(int id) {
        return repository.getTask(id);
    }

    @Override
    public void addTask(final Task task) {
        repository.addTask(task);
    }

    @Override
    public void updateTask(int id, Task task) {
        repository.updateTask(id, task);
    }

    @Override
    public void deleteTask(int id) {
        repository.deleteTask(id);
    }
}
