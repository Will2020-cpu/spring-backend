package com.example.demo.service;

import com.example.demo.models.Task;
import com.example.demo.repository.TaskRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service @RequiredArgsConstructor @Transactional @Slf4j
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepo taskRepo;

    @Override
    public Task saveTask(Task task) {
        log.info("Save task {}",task.getTitle());
        taskRepo.save(task);
        return task;
    }

    @Override
    public Task editTask(Long id, Task task) {
        return null;
    }

    @Override
    public List<Task> getTasks() {
        log.info("Show all tasks");
        return taskRepo.findAll();
    }
}
