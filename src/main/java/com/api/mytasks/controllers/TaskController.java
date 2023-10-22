package com.api.mytasks.controllers;

import com.api.mytasks.entity.Task;
import com.api.mytasks.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> findAllTasks() {
        return taskService.findAllTasks();
    }

    @GetMapping(value = "/{id}")
    public Task findTask(@PathVariable UUID id) {
        return taskService.findTask(id);
    }

    @PostMapping
    public Task insertTask(@RequestBody Task from) {
        return taskService.insertTask(from);
    }

    @DeleteMapping(value = "/{id}")
    public Task deleteTask(@PathVariable UUID id) {
        return taskService.deleteTask(id);
    }

    @PutMapping(value = "/{id}")
    public Task updateTask(@PathVariable UUID id, @RequestBody Task from) {
        return taskService.updateTask(id, from);
    }

}
