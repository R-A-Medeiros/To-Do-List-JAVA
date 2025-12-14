package com.example.todolist.services;

import com.example.todolist.models.TaskModel;
import com.example.todolist.repositories.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class TaskService {

    @Autowired
    private ITaskRepository taskRepository;

    public TaskModel save(TaskModel taskModel) {
        taskModel = taskRepository.save(taskModel);
        return taskModel;
    }

    public Boolean validarDataAtual (TaskModel taskModel) {
        var currentDate = LocalDateTime.now();

        return currentDate.isAfter(taskModel.getStartAt()) || currentDate.isAfter(taskModel.getEndAt());
    }

    public Boolean validarDataInicio (TaskModel taskModel) {
        var currentDate = LocalDate.now();

        if (taskModel.getStartAt().isAfter(taskModel.getEndAt())) {
           return true;
        }

        return false;
    }
}

