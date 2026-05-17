package com.myspringboot.taskapi.service;

import com.myspringboot.taskapi.entity.Task;
import com.myspringboot.taskapi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Create
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // Read All
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Read By Id
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    // Update
    public Task updateTask(Long id, Task updateTask) {

        Task existingTask = taskRepository.findById(id).orElse(null);

        if (existingTask != null) {
            existingTask.setTitle(updateTask.getTitle());
            existingTask.setDescription(updateTask.getDescription());
            existingTask.setStatus(updateTask.getStatus());

            return taskRepository.save(existingTask);
        }
        return null;
    }

    // Delete
    public String deleteTask(Long id) {
        taskRepository.deleteById(id);
        return "Task Deleted Successfully";
    }
}


