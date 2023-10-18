package com.api.mytasks.controllers;
import com.api.mytasks.entity.Task;
import com.api.mytasks.repository.UserRespository;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
    private final UserRespository repository;

    public TaskController(UserRespository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Task> findAllTasks() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Task findTask(@PathVariable UUID id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public Task insertTask(@RequestBody Task from) {
        return repository.save(from);
    }

    @DeleteMapping(value = "/{id}")
    public Task deleteTask(@PathVariable UUID id) {
        repository.deleteById(id);
        return null;
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable UUID id, @RequestBody Task form) {
        Optional<Task> taskGet = repository.findById(id);

        if (taskGet.isPresent()) {
            Task task = taskGet.get();
            task.setTitle(form.getTitle());
            task.setDescription(form.getDescription());
            task = repository.save(task);
            return task;
        } else {
            return null;
        }

    }

}
