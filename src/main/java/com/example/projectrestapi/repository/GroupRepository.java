package com.example.projectrestapi.repository;

import com.example.projectrestapi.dto.groupDto.GroupRespons;
import com.example.projectrestapi.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    @Query("select new com.example.projectrestapi.dto.groupDto.GroupRespons(c.id,c.groupName,c.imageLink,c.description)from Group c")
    List<GroupRespons>getAllGroups();

    Optional<Group>getGroupsById(Long id);
    @Query("select new com.example.projectrestapi.dto" +
            ".groupDto.GroupRespons(g.groupName,COUNT(s.id)) " +
            "from Group g JOIN" +
            " g.students gs JOIN " +
            "Student s where gs.id=s.id" +
            " and g.id=:courseId group by g "  )
    List<GroupRespons>getAllFromGroupStudentCount(@Param("courseId") Long courseId);
}
