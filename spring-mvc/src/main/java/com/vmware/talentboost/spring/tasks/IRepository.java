package com.vmware.talentboost.spring.tasks;

import java.util.List;

import com.vmware.talentboost.spring.tasks.data.Task;

public interface IRepository {

    List<Task> getAllTasks();

    List<Task> getTasksByCompletionStatus(boolean completed);

    Task getTask(int id);

    void addTask(Task task);

    void updateTask(int id, Task task);

    void deleteTask(int id);

}
