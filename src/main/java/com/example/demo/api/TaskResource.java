package com.example.demo.api;


import com.example.demo.models.Task;
import com.example.demo.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class TaskResource {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getTasks () {
        return ResponseEntity.ok(taskService.getTasks());
    }

    @PostMapping("/task/add")
    public ResponseEntity<Task> saveTask(@RequestBody Task task){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/task/add").toUriString());
        return ResponseEntity.created(uri).body(taskService.saveTask(task));
    }

    @PutMapping("/task/edit/{id}")
    public ResponseEntity<Task> editTask(@RequestBody Task taskUpdate){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/task/edit/{id}").toUriString());
        return ResponseEntity.created(uri).body(taskService.editTask(taskUpdate));
    }
}
