package com.example.projectrestapi.api;

import com.example.projectrestapi.dto.simpleDto.SimpleRespons;
import com.example.projectrestapi.dto.taskDto.TaskRequest;
import com.example.projectrestapi.dto.taskDto.TaskRespons;
import com.example.projectrestapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskApi {
    private final TaskService taskService;

    @GetMapping
    public List<TaskRespons> getAllTasks(){
      return   taskService.getAllTask();
    }

    @PostMapping("/save/{taskId}")
    public TaskRespons saveTasks(@PathVariable Long taskId, @RequestBody TaskRequest taskRequest) {
        return taskService.saveTask(taskId,taskRequest);
    }
    @GetMapping("/{id}")
    public TaskRespons getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }
    @PutMapping("/{id}")
    public TaskRespons ubdateTask(@PathVariable Long id,@RequestBody TaskRequest taskRequest){
        return taskService.updateTaskById(id,taskRequest);

    }
    @DeleteMapping("{id}")
    public SimpleRespons deleteTaskById(@PathVariable Long id){
        taskService.deleteTaskById(id);
        return new SimpleRespons("DELETED","Task with "+id+"deleted");
    }

}
