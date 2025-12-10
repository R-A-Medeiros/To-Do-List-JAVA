package com.example.todolist.services;

import com.example.todolist.models.TaskModel;
import com.example.todolist.repositories.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private ITaskRepository taskRepository;

    public TaskModel save(TaskModel taskModel) {
        taskModel = taskRepository.save(taskModel);
        return taskModel;
    }
}
