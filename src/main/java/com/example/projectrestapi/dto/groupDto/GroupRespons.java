package com.example.projectrestapi.dto.groupDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupRespons {
    private Long id;
    private String groupName;
    private String imageLink;
    private String description;

    public GroupRespons(Long id, String groupName, String imageLink, String description) {
        this.id = id;
        this.groupName = groupName;
        this.imageLink = imageLink;
        this.description = description;
    }
}
