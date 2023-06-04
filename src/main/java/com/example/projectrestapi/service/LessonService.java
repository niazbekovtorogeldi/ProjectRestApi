package com.example.projectrestapi.service;

import com.example.projectrestapi.dto.lessonDto.LessonRequest;
import com.example.projectrestapi.dto.lessonDto.LessonRespons;
import com.example.projectrestapi.dto.simpleDto.SimpleRespons;

import java.util.List;

public interface LessonService {
    LessonRespons saveLesson(LessonRequest lessonRequest);
    LessonRespons getLessonById(Long id);
    List<LessonRespons> getAllLessons();
    LessonRespons updateLessonById(Long id, LessonRequest lessonRequest);
    SimpleRespons deleteLessonById(Long id);
}
