package com.api.mytasks.services;

import com.api.mytasks.entity.Task;
import com.api.mytasks.repository.TaskRespository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {
    private final TaskRespository repository;

    public TaskService(TaskRespository repository) {
        this.repository = repository;
    }

    public List<Task> findAllTasks() {
        return repository.findAll();
    }

    public Task findTask(@PathVariable UUID id) {
        return repository.findById(id).get();
    }

    public Task insertTask(@RequestBody Task from) {
        from.setCreation(LocalDateTime.now());
        return repository.save(from);
    }

    public void deleteTask(@PathVariable UUID id) {
        repository.deleteById(id);
    }

    public Task updateTask(@PathVariable UUID id, @RequestBody Task form) {
        Optional<Task> taskGet = repository.findById(id);

        if (taskGet.isPresent()) {
            Task task = taskGet.get();
            task.setTitle(form.getTitle());
            task.setDescription(form.getDescription());
            task.setLastUpdate(LocalDateTime.now());
            task = repository.save(task);
            return task;
        } else {
            return null;
        }
    }

}

