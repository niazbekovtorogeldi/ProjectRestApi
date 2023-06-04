package com.example.projectrestapi.repository;

import com.example.projectrestapi.dto.taskDto.TaskRespons;
import com.example.projectrestapi.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    @Query("select new com.example.projectrestapi.dto.taskDto.TaskRespons(t.id,t.taskName,t.taskText,t.deadLine)from Task  t")
    List<TaskRespons>getAllTasks();
    Optional<Task>getTaskById(Long id);
}
