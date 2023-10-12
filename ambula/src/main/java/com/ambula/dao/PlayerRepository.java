package com.ambula.dao;

import com.ambula.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query("SELECT * FROM player GROUP BY player_id HAVING AVG(score) > :averageScore")
    List<Player> getPlayersWithAverageScoreGreaterThan(Integer averageScore);
    @Query("SELECT * FROM player where country:country")
    List<Player> findByCountryName(String country);

    @Query("SELECT * FROM player GROUP BY player_id HAVING AVG(score) > : averageScore ORDER BY AVG(score) DESC, MAX(age) DESC")
    List<Player> getPlayersWithAverageScoreGreaterThanYSorted(int averageScore);
}
