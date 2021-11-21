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
    public Task editTask(Task taskUpdate) {
        Long num = taskUpdate.getId();
        if(taskRepo.findById(num).isPresent()){
            Task taskToUpdate =  new Task();
            taskToUpdate.setId(taskUpdate.getId());
            taskToUpdate.setTitle(taskUpdate.getTitle());
            taskToUpdate.setStatus(taskUpdate.getStatus());
            taskToUpdate.setPriority(taskUpdate.getPriority());
            taskToUpdate.setCreated_at(taskUpdate.getCreated_at());
            taskToUpdate.setUpdate_at(taskUpdate.getUpdate_at());
            taskRepo.save(taskToUpdate);
            return taskToUpdate;
        }
        return  null;
    }

    @Override
    public List<Task> getTasks() {
        log.info("Show all tasks");
        return taskRepo.findAll();
    }
}
