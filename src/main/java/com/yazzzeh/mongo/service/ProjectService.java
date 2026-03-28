package com.yazzzeh.mongo.service;

import com.yazzzeh.mongo.dtos.ProjectRequest;
import com.yazzzeh.mongo.dtos.ProjectResponse;
import com.yazzzeh.mongo.model.Project;
import com.yazzzeh.mongo.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectResponse registerProject(ProjectRequest request) {

        Project project = Project.builder()
                .projectCode(request.projectCode())
                .projectName(request.projectName())
                .clientName(request.clientName())
                .type(request.type())
                .location(request.location())
                .startDate(request.startDate())
                .status("PLANNING")
                .progressPercentage(0)
                .build();

        projectRepository.save(project);

        log.info("Project registered successfully: {}", project.getProjectCode());

        return mapToResponse(project);
    }

    private ProjectResponse mapToResponse(Project project) {
        return new ProjectResponse(
                project.getId(),
                project.getProjectCode(),
                project.getProjectName(),
                project.getClientName(),
                project.getType(),
                project.getLocation(),
                project.getStartDate(),
                project.getLastUpdateDate(),
                project.getStatus(),
                project.getProgressPercentage()
        );
    }

    public List<ProjectResponse> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public void deleteProjectById(String id) {
        projectRepository.deleteById(id);
    }
}