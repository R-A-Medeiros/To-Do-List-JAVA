package com.example.todolist.controllers;

import com.example.todolist.models.TaskModel;
import com.example.todolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/tasks")
    public ResponseEntity<TaskModel> create(@RequestBody TaskModel taskModel) {
        var task = this.taskService.save(taskModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }
}
