package com.ambula.model;

import javax.persistence.Id;
import javax.persistence.Table;

@Table
public class Player {
@Id
    private Long id;
    private String name;
    private String DateOfBirth;
    private Long matchId;

    private String country;

    private Integer score;

    public Player() {
    }

    public Player(Long id, String name, String dateOfBirth, Long matchId,String country,Integer score) {
        this.id = id;
        this.name = name;
        DateOfBirth = dateOfBirth;
        this.matchId = matchId;
        this.country=country;
        this.score=score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}