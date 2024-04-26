package com.api.controller;

import com.api.entity.Task;
import com.api.exception.ResourceNotFoundException;
import com.api.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class TaskControllerTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskController taskController;

    private Task testTask;
    private List<Task> taskList;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        testTask = new Task(1L, "Test Task", "This is a test task.", false, LocalDateTime.now(), LocalDateTime.now());
        taskList = new ArrayList<>();
        taskList.add(testTask);
    }

    @Test
    public void testCreateTask() {
        Task newTask = new Task(null, "New Task", "This is a new task.", false, null, null);
        when(taskRepository.save(newTask)).thenReturn(newTask);

        ResponseEntity<Task> response = taskController.createTask(newTask);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newTask.getTitle(), response.getBody().getTitle());
        assertEquals(newTask.getDescription(), response.getBody().getDescription());
    }

    @Test
    public void testGetTaskById() {
        when(taskRepository.findById(1L)).thenReturn(Optional.of(testTask));

        ResponseEntity<Task> response = taskController.getTaskById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(testTask, response.getBody());
    }

    @Test
    public void testGetTaskByIdNotFound() {
        when(taskRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> taskController.getTaskById(2L));
    }

    @Test
    public void testGetAllTasks() {
        when(taskRepository.findAll()).thenReturn(taskList);

        ResponseEntity<List<Task>> response = taskController.getAllTasks();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(taskList, response.getBody());
    }

    @Test
    public void testUpdateTask() {
        Task updatedTask = new Task(1L, "Updated Task", "This is an updated task.", true, LocalDateTime.now(), LocalDateTime.now());
        when(taskRepository.findById(1L)).thenReturn(Optional.of(testTask));
        when(taskRepository.save(any(Task.class))).thenReturn(updatedTask);

        ResponseEntity<Task> response = taskController.updateTask(1L, updatedTask);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedTask, response.getBody());
    }

    @Test
    public void testUpdateTaskNotFound() {
        Task updatedTask = new Task(2L, "Updated Task", "This is an updated task.", true, LocalDateTime.now(), LocalDateTime.now());
        when(taskRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> taskController.updateTask(2L, updatedTask));
    }

    @Test
    public void testDeleteTask() {
        when(taskRepository.findById(1L)).thenReturn(Optional.of(testTask));
        doNothing().when(taskRepository).delete(testTask);

        ResponseEntity<Void> response = taskController.deleteTask(1L);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(taskRepository, times(1)).delete(testTask);
    }

    @Test
    public void testDeleteTaskNotFound() {
        when(taskRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> taskController.deleteTask(2L));
    }
}