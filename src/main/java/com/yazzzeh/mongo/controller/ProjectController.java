package com.yazzzeh.mongo.controller;

import com.yazzzeh.mongo.dtos.ProjectRequest;
import com.yazzzeh.mongo.dtos.ProjectResponse;
import com.yazzzeh.mongo.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectResponse registerProject(@RequestBody ProjectRequest projectRequest) {
        return projectService.registerProject(projectRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProjectResponse> getAllProjects() {
        return projectService.getAllProjects();
    }

    @DeleteMapping("/{id}")
    String deleteProjectById(@PathVariable String id) {
        projectService.deleteProjectById(id);
        return "the project is deleted successfully";
    }
}