package com.anuj.algotracker.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anuj.algotracker.dto.ProblemRequest;
import com.anuj.algotracker.dto.ProblemResponse;
import com.anuj.algotracker.entity.Difficulty;
import com.anuj.algotracker.entity.Problem;
import com.anuj.algotracker.entity.ProblemStatus;
import com.anuj.algotracker.service.ProblemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/problems")
public class ProblemController {

    private final ProblemService problemService;
    private ModelMapper modelMapper;

    public ProblemController(ProblemService problemService, ModelMapper modelMapper) {
        this.problemService = problemService;
        this.modelMapper = modelMapper;
    }

    // Create
    @PostMapping
    public Problem createProblem(@Valid @RequestBody ProblemRequest request) {
        return problemService.createProblem(request);
    }

    @PostMapping("/bulk")
    public List<ProblemResponse> createProblemList(@Valid @RequestBody List<ProblemRequest> request) {
        return problemService.createProblemList(request);
    }

    // Read all
    @GetMapping
    public List<ProblemResponse> getAllProblems() {
        return problemService.getAllProblemsForCurrentUser();
    }

    // Read by ID
    @GetMapping("/{id}")
    public Problem getProblemById(@PathVariable Long id) {
        return problemService.getProblemByIdForCurrentUser(id);
    }

    // Update
    @PutMapping("/{id}")
    public Problem updateProblem(@PathVariable Long id,
            @Valid @RequestBody ProblemRequest request) {
        return problemService.updateProblem(id, request);
    }

    // Delete by id
    @DeleteMapping("/{id}")
    public void deleteProblem(@PathVariable Long id) {
        problemService.deleteProblem(id);
    }

    // Filter by difficulty
    @GetMapping("/difficulty/{difficulty}")
    public List<Problem> getByDifficulty(@PathVariable Difficulty difficulty) {
        return problemService.getProblemsByDifficulty(difficulty);
    }

    // Filter by status
    @GetMapping("/status/{status}")
    public List<Problem> getByStatus(@PathVariable ProblemStatus status) {
        return problemService.getProblemsByStatus(status);
    }

    // Filter by topic
    @GetMapping("/topic/{topic}")
    public List<Problem> getByTopic(@PathVariable String topic) {
        return problemService.getProblemsByTopic(topic);
    }
}
