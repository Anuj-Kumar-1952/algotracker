package com.anuj.algotracker.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import com.anuj.algotracker.entity.Difficulty;
import com.anuj.algotracker.entity.ProblemStatus;
@Data
public class ProblemRequest {

    @NotBlank
    private String title;

    private String description;

    @NotNull
    private Difficulty difficulty;

    @NotBlank
    private String topic;

    private String link;

    private ProblemStatus status;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
