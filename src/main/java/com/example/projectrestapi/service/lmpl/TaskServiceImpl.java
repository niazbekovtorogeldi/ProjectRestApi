package com.example.projectrestapi.service.lmpl;

import com.example.projectrestapi.api.TaskApi;
import com.example.projectrestapi.dto.simpleDto.SimpleRespons;
import com.example.projectrestapi.dto.taskDto.TaskRequest;
import com.example.projectrestapi.dto.taskDto.TaskRespons;
import com.example.projectrestapi.entity.Lesson;
import com.example.projectrestapi.entity.Task;
import com.example.projectrestapi.repository.LessonRepository;
import com.example.projectrestapi.repository.TaskRepository;
import com.example.projectrestapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final LessonRepository lessonRepository;

    @Override
    public TaskRespons saveTask(Long lessonId,TaskRequest taskRequest) {
        Lesson lesson =
                lessonRepository.getLessonById(lessonId).orElseThrow(()
                        -> new NullPointerException("Lesson with id " + lessonId + "  is not found "));
        Task task = new Task();
        task.setTaskName(taskRequest.getTaskName());
        task.setTaskText(taskRequest.getTaskText());
        taskRepository.save(task);
        lessonRepository.save(lesson);
        return new TaskRespons(
                task.getId(),
                task.getTaskName(),
                task.getTaskText(),task.getDeadLine());
    }

    @Override
    public TaskRespons getTaskById(Long id) {
        Task task =
        taskRepository.getTaskById(id).orElseThrow(() ->
                new NullPointerException("Lesson with id " + id + "  is not found "));
        return new TaskRespons(
                task.getId(),
                task.getTaskName(),
                task.getTaskText(),task.getDeadLine());
    }

    @Override
    public List<TaskRespons> getAllTask() {
        return taskRepository.getAllTasks();
    }

    @Override
    public TaskRespons updateTaskById(Long id, TaskRequest taskRequestRequest) {

        Task task = taskRepository.getTaskById(id).orElseThrow(() ->
                new NullPointerException("Lesson with id " + id + "  is not found "));
        task.setTaskName(taskRequestRequest.getTaskName());
        task.setTaskText(taskRequestRequest.getTaskText());
        taskRepository.save(task);
        return new TaskRespons(
                task.getId(),
                task.getTaskName(),
                task.getTaskText(),task.getDeadLine());
    }

    @Override
    public SimpleRespons deleteTaskById(Long id) {
        boolean exist = taskRepository.existsById(id);
        if (!exist) {
            throw new NoSuchElementException
                    ("Student with id: " + id + " is not found");
        }
        taskRepository.deleteById(id);
        return new SimpleRespons("DELETED","Student with id: " + id + " is deleted");

    }
}