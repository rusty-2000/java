package com.api.controller;

//Java code for the RESTful API

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.entity.Task;
import com.api.exception.ResourceNotFoundException;
import com.api.repository.TaskRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@Api(tags = "Task Management")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;
    
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @ApiOperation(value = "Create a new task")
    @PostMapping
    public ResponseEntity<Task> createTask(@ApiParam(value = "Task details", required = true) @RequestBody Task task) {
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        Task savedTask = taskRepository.save(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get a task by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@ApiParam(value = "Task ID", required = true) @PathVariable Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
        return ResponseEntity.ok(task);
    }

    @ApiOperation(value = "Get all tasks")
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = (List<Task>) taskRepository.findAll();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @ApiOperation(value = "Update a task")
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@ApiParam(value = "Task ID", required = true) @PathVariable Long id,
                                           @ApiParam(value = "Task details", required = true) @RequestBody Task task) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));

        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setCompleted(task.isCompleted());
        existingTask.setUpdatedAt(LocalDateTime.now());

        Task updatedTask = taskRepository.save(existingTask);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a task")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@ApiParam(value = "Task ID", required = true) @PathVariable Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
        taskRepository.delete(task);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}