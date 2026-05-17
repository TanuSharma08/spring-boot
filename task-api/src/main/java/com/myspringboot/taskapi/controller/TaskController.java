package com.myspringboot.taskapi.controller;

import com.myspringboot.taskapi.entity.Task;
import com.myspringboot.taskapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Create
    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    // Read All
    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    // Read By Id
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task){
        return taskService.updateTask(id, task);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id){
        return taskService.deleteTask(id);
    }
}

