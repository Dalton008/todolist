package main.service;

import main.model.Task;

import java.util.List;
import java.util.Map;

public interface TaskManagerService
{
    void addTask(Task task);

    Iterable<Task> getTasks();

    Task getTask(Long id);

    List<Task> getTasks(Integer page, Integer pageSize, Map<String, Boolean> sortBy, Map<String, Object> filters);

    Task updateTask(Task task);

    void removeTask(Long id);

}
