package com.ambula.model;

public class Match {

    private Long id;
    private Integer score;
    private String stadium;

    public Match() {
    }

    public Match(Long id, Integer score, String stadium) {
        this.id = id;
        this.score = score;
        this.stadium = stadium;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }
}