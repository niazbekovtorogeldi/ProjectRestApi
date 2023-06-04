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
@Table(name = "instructors")
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instructor_gen")
    @SequenceGenerator(name = "instructor_gen", sequenceName = "instructor_seq", allocationSize = 1)
    private Long id;
    @Value("first_name")
    private String firstName;
    @Value("last_name")
    private String lastName;
    @Value("phone_number")
    private String phoneNumber;
    private String specialization;
    @ManyToMany(mappedBy = "instructors",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    private List<Company>companies;
    @OneToMany(mappedBy = "instructors",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    private List<Course>courses;

}
