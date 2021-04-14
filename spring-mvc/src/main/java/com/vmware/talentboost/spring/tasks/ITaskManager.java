package com.vmware.talentboost.spring.tasks;

import java.util.List;

import com.vmware.talentboost.spring.tasks.data.Task;
import com.vmware.talentboost.spring.tasks.data.TaskStatus;

public interface ITaskManager {

    List<Task> getAllTasks(TaskStatus status);

    Task getTask(int id);

    void addTask(Task task);

    void updateTask(int id, Task task);

    void deleteTask(int id);

}
