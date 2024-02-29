package com.example.projectmanagerbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectmanagerbackend.domain.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project findByProjectId(String projectId);
    
} 
