package com.example.projectrestapi.service.lmpl;

import com.example.projectrestapi.dto.groupDto.GroupRequest;
import com.example.projectrestapi.dto.groupDto.GroupRespons;
import com.example.projectrestapi.dto.simpleDto.SimpleRespons;
import com.example.projectrestapi.entity.Course;
import com.example.projectrestapi.entity.Group;
import com.example.projectrestapi.repository.CourseRepository;
import com.example.projectrestapi.repository.GroupRepository;
import com.example.projectrestapi.service.GroupService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final CourseRepository courseRepository;

    @Override
    public GroupRespons saveGroup(Long courseId,GroupRequest groupRequest) {

        Group group = new Group();
        group.setGroupName(groupRequest.getGroupName());
        group.setDescription(groupRequest.getDescription());
        group.setImageLink(groupRequest.getImageLink());
        groupRepository.save(group);
        return new GroupRespons(group.getId(),
                group.getGroupName(),
                group.getImageLink(),
                group.getDescription());
    }
    @Override
    public GroupRespons getGroupById(Long id) {
        Group group =
        groupRepository.getGroupsById(id).orElseThrow(()->new NullPointerException("Group with id:"+id+"is not found"));

        return new GroupRespons(group.getId(),group.getGroupName(),group.getImageLink(),group.getDescription());
    }

    @Override
    public List<GroupRespons> getAllGroups() {
        return groupRepository.getAllGroups();
    }

    @Override
    public GroupRespons updateGroups(Long id, GroupRequest groupRequest) {
        Group group = groupRepository.findById(id).orElseThrow(()-> new NullPointerException("Group with id :"+id+"is not found"));
        group.setGroupName(groupRequest.getGroupName());
        group.setImageLink(groupRequest.getImageLink());
        group.setDescription(groupRequest.getDescription());
        groupRepository.save(group);

        return new GroupRespons(group.getId(),group.getGroupName(),group.getImageLink(),group.getDescription());

    }

    @Override
    public SimpleRespons deleteGroupById(Long id) {
        boolean exist= groupRepository.existsById(id);
        if(!exist){
            throw  new NoSuchElementException("Group with id "+id+"is not found");
        }
        groupRepository.deleteById(id);
        return new SimpleRespons("deletet"+id,".");
    }

    @Override
    public List<GroupRespons> getAllStudentCountFromCourse(Long courseId) {
        return groupRepository.getAllFromGroupStudentCount(courseId);
    }

    @Override
    public SimpleRespons assignGroupToCourse(Long courseId, Long groupId) {
        Course course =
                courseRepository.getCourseById(courseId).orElseThrow(()
                        -> new NullPointerException("Course with id " + courseId + "  is not found "));
        Group group =
                groupRepository.getGroupsById(groupId).orElseThrow(()
                        -> new NullPointerException("Group with id " + groupId+ "  is not found "));
        course.getGroups().add(group);
        courseRepository.save(course);
        group.getCourses().add(course);
        courseRepository.save(course);
        return new SimpleRespons(
                "assign","group with id "
                +groupId+" assign to course with id "+courseId);

    }
}
