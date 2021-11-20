package com.example.demo.service;

import com.example.demo.models.Task;

import java.util.List;

public interface TaskService {
    Task saveTask(Task task);
    Task editTask(Long id, Task task);
    List<Task> getTasks();
}
