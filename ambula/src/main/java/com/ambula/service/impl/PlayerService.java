package com.ambula.service.impl;

import com.ambula.dao.PlayerRepository;
import com.ambula.model.Player;
import com.ambula.service.IPlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService implements IPlayerService {

    Logger logger = LoggerFactory.getLogger(PlayerService.class);
    @Autowired
    PlayerRepository playerRepository;


    @Override
    public Player createPlayer(Player player) {
        logger.info("Inside create player method for saving player "+player.getId());
        try {
            playerRepository.save(player);
        } catch (Exception e) {
            logger.error("Exception occurred while saving players in DB",e);
            return null;
        }
        return player;
    }


    @Override
    public Player getPlayerDetailById(Long id) {

        Player player = new Player();
        try {
            Optional<Player> playerDetailOptional = playerRepository.findById(id);
            if (playerDetailOptional.isPresent())
                player = playerDetailOptional.get();
        } catch (Exception e) {
            logger.error("Exception occurred while fetching player from DB for id "+id,e);
            return player;
        }
        return player;
    }

    @Override
    public Player updatePlayer(Player player) {


        logger.info("Inside update player method for saving player "+player.getId());
        try {
            Optional<Player> optionalPlayer = playerRepository.findById(player.getId());
            if (optionalPlayer.isPresent())
                playerRepository.save(player);
        } catch (Exception e) {
            logger.error("Exception occurred while updating players in DB",e);
            return null;
        }
        return player;
    }

    @Override
    public void deletePlayer(Long id) {

        try {
            playerRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Exception occurred while deleting player from DB for id "+id,e);
        }
    }

    @Override
    public List<Player> getPlayersByCountry(String country) {
        List<Player> playerList=new ArrayList<>();
        try {
            playerList=playerRepository.findByCountryName(country);
        } catch (Exception e) {
            logger.error("Exception occurred while fetching player from DB for country "+country,e);
            return playerList;
        }
        return playerList;
    }

    @Override
    public List<Player> getPlayersWithAverageScoreGreaterThan(int averageScore) {

        List<Player> player = new ArrayList<>();
        try {
            player = playerRepository.getPlayersWithAverageScoreGreaterThan(averageScore);
        } catch (Exception e) {
            logger.error("Exception occurred while fetching PlayersWithAverageScoreGreaterThan from DB",e);
            return player;
        }
        return player;
    }

    @Override
    public List<Player> getPlayersWithAverageScoreGreaterThanYSorted(int averageScore) {

        List<Player> player = new ArrayList<>();
        try {
            player = playerRepository.getPlayersWithAverageScoreGreaterThanYSorted(averageScore);
        } catch (Exception e) {
            logger.error("Exception occurred while fetching PlayersWithAverageScoreGreaterThanYSorted",e);
            return player;
        }
        return player;

    }
}
