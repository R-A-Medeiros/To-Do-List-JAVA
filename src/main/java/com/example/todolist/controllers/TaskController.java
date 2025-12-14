package com.example.todolist.controllers;

import com.example.todolist.models.TaskModel;
import com.example.todolist.services.TaskService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/tasks")
    public ResponseEntity<?> create(@RequestBody TaskModel taskModel, HttpServletRequest request) {

        taskModel.setIdUser((UUID) request.getAttribute("idUser"));

        if (this.taskService.validarDataAtual(taskModel)) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("A data de início / data de término deve ser maior do que a data atual.");
        }

        if  (this.taskService.validarDataInicio(taskModel)) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("A data de início deve ser menor do que a data de término.");
        }

        var task = this.taskService.save(taskModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }
}
