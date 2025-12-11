package com.anuj.algotracker.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.anuj.algotracker.dto.ProblemRequest;
import com.anuj.algotracker.dto.ProblemResponse;
import com.anuj.algotracker.entity.Difficulty;
import com.anuj.algotracker.entity.Problem;
import com.anuj.algotracker.entity.ProblemStatus;
import com.anuj.algotracker.repository.ProblemRepository;

@Service
public class ProblemService {

    private final ProblemRepository problemRepository;
    private final CurrentUserService currentUserService;
    private final ModelMapper modelMapper;

    public ProblemService(ProblemRepository problemRepository,
            CurrentUserService currentUserService,
            ModelMapper modelMapper) {
        this.problemRepository = problemRepository;
        this.currentUserService = currentUserService;
        this.modelMapper = modelMapper;
    }

    public Problem createProblem(ProblemRequest request) {
        var currentUser = currentUserService.getCurrentUser();

        Problem problem = new Problem();
        problem.setTitle(request.getTitle());
        problem.setDescription(request.getDescription());
        problem.setDifficulty(request.getDifficulty());
        problem.setTopic(request.getTopic());
        problem.setLink(request.getLink());
        problem.setStatus(
                request.getStatus() != null ? request.getStatus() : ProblemStatus.TODO);
        problem.setUser(currentUser);

        return problemRepository.save(problem);
    }

    public List<ProblemResponse> createProblemList(List<ProblemRequest> requests) {
        var currentUser = currentUserService.getCurrentUser();

        List<Problem> problems = requests.stream()
                .map(req -> {
                    Problem problem = new Problem();
                    problem.setTitle(req.getTitle());
                    problem.setDescription(req.getDescription());
                    problem.setDifficulty(req.getDifficulty());
                    problem.setTopic(req.getTopic());
                    problem.setLink(req.getLink());
                    problem.setStatus(req.getStatus() != null ? req.getStatus() : ProblemStatus.TODO);
                    problem.setUser(currentUser);
                    return problem;
                })
                .toList();

        List<Problem> savedProblems = problemRepository.saveAll(problems);

        return savedProblems.stream()
                .map(problem -> modelMapper.map(problem, ProblemResponse.class))
                .toList();
    }

    public List<ProblemResponse> getAllProblemsForCurrentUser() {
        var currentUser = currentUserService.getCurrentUser();
        return problemRepository.findByUser(currentUser).stream()
                .map(problem -> modelMapper.map(problem, ProblemResponse.class))
                .toList();
    }

    public Problem getProblemByIdForCurrentUser(Long id) {
        var currentUser = currentUserService.getCurrentUser();
        return problemRepository.findByIdAndUser(id, currentUser)
                .orElseThrow(() -> new RuntimeException("Problem not found for this user with id: " + id));
    }

    public Problem updateProblem(Long id, ProblemRequest request) {
        Problem existing = getProblemByIdForCurrentUser(id);

        existing.setTitle(request.getTitle());
        existing.setDescription(request.getDescription());
        existing.setDifficulty(request.getDifficulty());
        existing.setTopic(request.getTopic());
        existing.setLink(request.getLink());
        if (request.getStatus() != null) {
            existing.setStatus(request.getStatus());
        }

        return problemRepository.save(existing);
    }

    public void deleteProblem(Long id) {
        Problem existing = getProblemByIdForCurrentUser(id);
        problemRepository.delete(existing);
    }

    public List<Problem> getProblemsByDifficulty(Difficulty difficulty) {
        return this.problemRepository.findByDifficulty(difficulty);
    }

    public List<Problem> getProblemsByStatus(ProblemStatus status) {
        return this.problemRepository.findByStatus(status);
    }

    public List<Problem> getProblemsByTopic(String topic) {
        return this.problemRepository.findByTopic(topic);
    }

}
