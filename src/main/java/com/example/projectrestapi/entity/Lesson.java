package com.example.projectrestapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lesson_gen")
    @SequenceGenerator(name = "lesson_gen", sequenceName = "lesson_seq", allocationSize = 1)
    private Long id;
    @Value("lesson_name")
    private String lessonName;
    private String Description;
    @OneToMany(mappedBy = "lessons", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    private List<Course> courses;
}
