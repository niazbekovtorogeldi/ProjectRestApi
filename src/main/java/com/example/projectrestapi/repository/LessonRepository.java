package com.example.projectrestapi.repository;

import com.example.projectrestapi.dto.lessonDto.LessonRequest;
import com.example.projectrestapi.dto.lessonDto.LessonRespons;
import com.example.projectrestapi.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LessonRepository extends JpaRepository<Lesson ,Long> {
    @Query("select new com.example.projectrestapi.dto.lessonDto.LessonRespons(l.id,l.lessonName,l.Description)from Lesson l")
    List<LessonRespons> getAllLessons();

    Optional<Lesson> getLessonById(Long id);

}