package com.example.project.projectdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectData, Long> {

    @Query("select p from ProjectData p where p.name = ?1")
    Optional<ProjectData> findProjectDataByName(String name);

    @Query("select p from ProjectData p where p.id = ?1")
    Optional<ProjectData> findProjectDataById(Long id);

}
