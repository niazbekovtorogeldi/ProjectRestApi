package com.example.projectrestapi.service.lmpl;

import com.example.projectrestapi.dto.lessonDto.LessonRequest;
import com.example.projectrestapi.dto.lessonDto.LessonRespons;
import com.example.projectrestapi.dto.simpleDto.SimpleRespons;
import com.example.projectrestapi.entity.Lesson;
import com.example.projectrestapi.repository.LessonRepository;
import com.example.projectrestapi.service.LessonService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;

    @Override
    public LessonRespons saveLesson(LessonRequest lessonRequest) {
        Lesson lesson = new Lesson();
        lesson.setLessonName(lessonRequest.getLessonName());
        lessonRepository.save(lesson);
        return new LessonRespons(lesson.getId(),lesson.getLessonName(),lesson.getDescription());
    }

    @Override
    public LessonRespons getLessonById(Long id) {
        Lesson lesson =
        lessonRepository.getLessonById(id).orElseThrow(()-> new NullPointerException("Lesson with id"+id+"is not found"));
        return new LessonRespons(lesson.getId(),lesson.getLessonName(),lesson.getDescription());
    }

    @Override
    public List<LessonRespons> getAllLessons() {
        return lessonRepository.getAllLessons();
    }

    @Override
    public LessonRespons updateLessonById(Long id, LessonRequest lessonRequest) {
        Lesson lesson = lessonRepository.findById(id).orElseThrow(()->new NullPointerException("lesson with id"+id+"is not found"));
        lesson.setLessonName(lessonRequest.getLessonName());
        lessonRepository.save(lesson);
        return new LessonRespons(lesson.getId(), lesson.getLessonName(),lesson.getDescription());
    }

    @Override
    public SimpleRespons deleteLessonById(Long id) {
        boolean exist = lessonRepository.existsById(id);
        if(!exist){
            throw new NoSuchElementException("Lesson with id"+id+"is not fount");
        }
        lessonRepository.deleteById(id);
        return new SimpleRespons("deletet"+id,".");
    }

}
