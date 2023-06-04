package com.example.projectrestapi.dto.lessonDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LessonRespons {
    private Long id;
    private String lessonName;
    private  String Description;

    public LessonRespons(Long id, String lessonName, String description) {
        this.id = id;
        this.lessonName = lessonName;
        Description = description;
    }
}
