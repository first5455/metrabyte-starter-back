package com.example.project.projectdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) { this.projectRepository = projectRepository; }
    public List<ProjectData> getProjectAsc(String sortBy){ return projectRepository.findAll(Sort.by(sortBy).ascending()); }
    public List<ProjectData> getProjectDes(String sortBy){ return projectRepository.findAll(Sort.by(sortBy).descending()); }
    public Optional<ProjectData> getProjectId(Long id){
        boolean exists = projectRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("project with id "+id+" does not exist");
        }
        return projectRepository.findProjectDataById(id);
    }

    public void addNewProject(ProjectData projectData){
        Optional<ProjectData> projectDataOptional = projectRepository
                .findProjectDataByName(projectData.getName());
        if (projectDataOptional.isPresent()){
            throw new IllegalStateException("name already exist");
        }
        projectRepository.save(projectData);
    }

    public void deleteProject(Long projectId){
        boolean exists = projectRepository.existsById(projectId);
        if(!exists){
            throw new IllegalStateException("project with id "+projectId+" does not exist");
        }
        projectRepository.deleteById(projectId);
    }

    @Transactional
    public void updateProject(Long projectId,ProjectData projectData){
        ProjectData project = projectRepository.findById(projectId)
                .orElseThrow(()-> new IllegalStateException("project with id "+projectId+" does not exist"));
        if(projectData.getName()!=null && projectData.getName().length()>0 && !Objects.equals(project.getName(),projectData.getName())){
            project.setName(projectData.getName());
        }
        if(projectData.getDescription()!=null){
            project.setDescription(projectData.getDescription());
        }
        if(projectData.getRating()!=null && projectData.getRating()>0){
            project.setRating(projectData.getRating());
        }
        if(projectData.getDates()!=null){
            project.setDates(projectData.getDates());
        }
    }


}
