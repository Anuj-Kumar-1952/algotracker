package com.anuj.algotracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anuj.algotracker.entity.Difficulty;
import com.anuj.algotracker.entity.Problem;
import com.anuj.algotracker.entity.ProblemStatus;
import com.anuj.algotracker.entity.User;

public interface ProblemRepository extends JpaRepository<Problem, Long> {

    List<Problem> findByDifficulty(Difficulty difficulty);

    List<Problem> findByStatus(ProblemStatus status);

    List<Problem> findByTopic(String topic);

    List<Problem> findByUser(User user);

    Optional<Problem> findByIdAndUser(Long id, User user);

}