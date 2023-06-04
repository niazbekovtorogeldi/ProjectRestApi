package com.example.projectrestapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Entity
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
public class Group {
    @Id
    @GeneratedValue(generator = "group_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "group_gen",sequenceName = "group_seq",allocationSize = 1)
    private Long id;
    private String groupName;
    private String imageLink;
    private String description;
    @ManyToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private List<Course>courses;
    @OneToMany(mappedBy = "group",cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,CascadeType.REMOVE})
    private List<Student>students;
    public Group(String groupName, String imageLink, String description, List<Course> courses) {
        this.groupName = groupName;
        this.imageLink = imageLink;
        this.description = description;
        this.courses = courses;
    }
}







