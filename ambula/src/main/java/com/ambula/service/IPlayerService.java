package com.ambula.service;

import com.ambula.model.Player;

import java.util.List;

public interface IPlayerService {
    Player createPlayer(Player player);

    Player updatePlayer(Player player);

    void deletePlayer(Long id);

    Player getPlayerDetailById(Long id);

    List<Player> getPlayersWithAverageScoreGreaterThan(int averageScore);

    List<Player> getPlayersByCountry(String country);

    List<Player> getPlayersWithAverageScoreGreaterThanYSorted(int averageScore);
}
