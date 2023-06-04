package com.example.projectrestapi.dto.lessonDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LessonRequest {
    private String lessonName;
    private  String Description;
}
