package com.example.projectrestapi.api;

import com.example.projectrestapi.dto.groupDto.GroupRequest;
import com.example.projectrestapi.dto.groupDto.GroupRespons;
import com.example.projectrestapi.dto.simpleDto.SimpleRespons;
import com.example.projectrestapi.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupApi {
    private final GroupService service;


    @GetMapping
    public List<GroupRespons> getAllGroup() {
        return service.getAllGroups();

    }

    @PostMapping("/save/{courseId}")
    public GroupRespons saveGroup(@PathVariable Long courseId, @RequestBody GroupRequest groupRequest) {
        return service.saveGroup(courseId, groupRequest);
    }

    @GetMapping("/{id}")
    public GroupRespons getGroupById(@PathVariable Long id) {

        return service.getGroupById(id);
    }

    @PutMapping("/{id}")
    public GroupRespons updateGroup(@PathVariable Long id, @RequestBody GroupRequest groupRequest) {
        return service.updateGroups(id, groupRequest);

    }

    @DeleteMapping("/{id}")
    public SimpleRespons deleteGroupById(@PathVariable Long id) {
        service.deleteGroupById(id);
        return new SimpleRespons("DELETED", "Group with " + id + "  deleted");
    }

    @PostMapping({"/{courseId}/{groupId}"})
    public SimpleRespons assignGroupToCourse(@PathVariable Long courseId, @PathVariable Long groupId) {
        service.assignGroupToCourse(courseId, groupId);
        return new SimpleRespons(
                "assign", "instructor with id "
                + courseId + " assign to company with id " + groupId);
    }
}