package com.example.projectrestapi.service;

import com.example.projectrestapi.dto.simpleDto.SimpleRespons;
import com.example.projectrestapi.dto.taskDto.TaskRequest;
import com.example.projectrestapi.dto.taskDto.TaskRespons;

import java.util.List;

public interface TaskService {
    TaskRespons saveTask(Long lessonId,TaskRequest taskRequest);
    TaskRespons getTaskById(Long id);
    List<TaskRespons> getAllTask();
    TaskRespons updateTaskById(Long id,TaskRequest taskRequestRequest);
    SimpleRespons deleteTaskById(Long id);
}
