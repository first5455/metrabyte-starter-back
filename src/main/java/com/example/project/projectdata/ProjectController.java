package com.example.project.projectdata;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<ProjectData> getProject(@RequestParam(defaultValue = "id") String sort,@RequestParam(defaultValue = "asc") String type){
        if(type.equals("des")){
            return projectService.getProjectDes(sort);
        }
        else{
            return projectService.getProjectAsc(sort);
        }

    }

    @GetMapping(params = "projectId")
    public Optional<ProjectData> getProjectById(@RequestParam Long projectId){
        return projectService.getProjectId(projectId);
    }

    @PostMapping
    public void registerNewProject(@RequestBody ProjectData project){
        projectService.addNewProject(project);
    }

    @DeleteMapping
    public void deleteProject(@RequestParam Long projectId){
        projectService.deleteProject(projectId);
    }

    @PutMapping
    public void updateProject(@RequestParam Long projectId,@RequestBody ProjectData projectData){
        projectService.updateProject(projectId,projectData);
    }
}
