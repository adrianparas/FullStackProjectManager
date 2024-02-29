package com.example.projectmanagerbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectmanagerbackend.domain.Project;
import com.example.projectmanagerbackend.repository.ProjectRepository;
import java.util.List;

@Service
public class ProjectService {
    
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdate(Project project) {
        return projectRepository.save(project);
    }

    public Project findProjectById(String projectId) throws Exception {
        Project project = projectRepository.findByProjectId(projectId.toUpperCase());
        if(project == null) {
            throw new Exception("Project does not exist");
        }
        return project;
    }

    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    public void deleteProjectById(String projectId) throws Exception {
        Project project = projectRepository.findByProjectId(projectId);
        if(project == null) {
            throw new Exception("Project doesn't exist");
        }
        projectRepository.delete(project);
    }
}
