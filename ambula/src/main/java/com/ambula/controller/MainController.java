package com.ambula.controller;

import com.ambula.model.Player;
import com.ambula.service.IPlayerService;
import com.ambula.service.impl.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ambula/**/")
public class MainController {


    @Autowired
    IPlayerService iPlayerService;

    @PostMapping(value = "/players")
    public Player createPlayer(@RequestBody Player player,@RequestParam boolean isAdmin) {
        if(isAdmin)
        return iPlayerService.createPlayer(player);
        return null;
    }
    @PutMapping(value ="/players/{id}")
    public Player updatePlayer(@RequestBody Player player,@RequestParam boolean isAdmin) {
        if(isAdmin)
        return iPlayerService.updatePlayer(player);
        return null;
    }
    @DeleteMapping(value ="/players/{id}")
    public void deletePlayer(@PathVariable Long id,@RequestParam boolean isAdmin) {
        if(isAdmin)
        iPlayerService.deletePlayer(id);
    }
    @GetMapping(value = "getPlayer")
    public Player getPlayerDetailById(@RequestParam(name = "id") Long id) {
        return iPlayerService.getPlayerDetailById(id);
    }

    @GetMapping(value ="/players/average/{x}")
    public List<Player> getPlayersWithAverageScoreGreaterThanX(@PathVariable int averageScore) {
        return iPlayerService.getPlayersWithAverageScoreGreaterThan(averageScore);
    }
    @GetMapping(value ="/players/country/{country}")
    public List<Player> getPlayersByCountry(@PathVariable String country) {
        return iPlayerService.getPlayersByCountry(country);
    }
    @GetMapping(value ="/players/sorted/{y}")
    public List<Player> getPlayersWithAverageScoreGreaterThanYSorted(@PathVariable int averageScore) {
        return iPlayerService.getPlayersWithAverageScoreGreaterThanYSorted(averageScore);
    }


}
