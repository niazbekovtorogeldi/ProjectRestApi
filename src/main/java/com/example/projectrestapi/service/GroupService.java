package com.example.projectrestapi.service;

import com.example.projectrestapi.dto.groupDto.GroupRequest;
import com.example.projectrestapi.dto.groupDto.GroupRespons;
import com.example.projectrestapi.dto.simpleDto.SimpleRespons;

import java.util.List;

public interface GroupService {
    GroupRespons saveGroup(Long courseId,GroupRequest groupRequest);
    GroupRespons getGroupById(Long id);
    List<GroupRespons> getAllGroups();
    GroupRespons updateGroups(Long id,GroupRequest groupRequest);
    SimpleRespons deleteGroupById(Long id);
    List <GroupRespons>getAllStudentCountFromCourse(Long courseId);

    SimpleRespons assignGroupToCourse(Long courseId,Long groupId);
}
