package com.example.projectrestapi.repository;

import com.example.projectrestapi.dto.companyDto.CompanyRequest;
import com.example.projectrestapi.dto.companyDto.CompanyRespons;
import com.example.projectrestapi.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
    @Query("select new com.example.projectrestapi.dto.companyDto.CompanyRespons(c.id,c.name,c.country,c.address,c.phoneNumber)from Company c")
    List<CompanyRespons>getAllCompanies();

    Optional<CompanyRespons> getCompanyById(Long id);
    @Query("select g.groupName from Company c join c.courses cc join cc.groups g where c.id=:companyId")
    List<String> groupName(@Param("companyId")Long companyId);
    @Query("select cc.courseName from Company c join c.courses cc where c.id=:companyId")
    List<String> courseName(@Param("companyId")Long companyId);
    @Query("select i.firstName from Company c join c.instructors i where c.id=:companyId")
    List<String> instructorName(@Param("companyId")Long companyId);
    @Query("select count(s.id) from Company c join c.courses cc join cc.groups g join g.students s where c.id=:companyId")
    int studentCount(@Param("companyId") Long companyId);
    @Query("select s.firstName from Company c join c.courses cc join cc.groups g join g.students s  where  s.studyFormat  ='on' and s.studyFormat='off'  ")
    List<String> studentInfo(@Param("companyId") Long companyId);





}
