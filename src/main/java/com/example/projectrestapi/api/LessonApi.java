package com.example.projectrestapi.api;

import com.example.projectrestapi.dto.lessonDto.LessonRequest;
import com.example.projectrestapi.dto.lessonDto.LessonRespons;
import com.example.projectrestapi.dto.simpleDto.SimpleRespons;

import com.example.projectrestapi.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lessons")
@RequiredArgsConstructor
public class LessonApi {
    private final LessonService lessonService;

    @GetMapping
    public List<LessonRespons> getAllLessons(){
        return lessonService.getAllLessons();
    }
    @PostMapping("/save")
    public LessonRespons saveLesson(@RequestBody LessonRequest lessonRequest){
        return lessonService.saveLesson(lessonRequest);
    }
    @GetMapping("/{id}")
    public LessonRespons getLessonById(@PathVariable Long id){
        return lessonService.getLessonById(id);
    }
    @PutMapping("/{id}")
    public LessonRespons updateCompany(@PathVariable Long id,@RequestBody LessonRequest lessonRespons){
        return lessonService.updateLessonById(id,lessonRespons);
    }
    @DeleteMapping("/{id}")
    public SimpleRespons deleteLeesonById(@PathVariable Long id){
        lessonService.deleteLessonById(id);
        return new SimpleRespons("DELETED","Lesson with "+id+"deleted");
    }
}
