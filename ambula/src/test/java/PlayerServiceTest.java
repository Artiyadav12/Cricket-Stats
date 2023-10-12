import com.ambula.dao.PlayerRepository;
import com.ambula.model.Player;
import com.ambula.service.impl.PlayerService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;



public class PlayerServiceTest {

    @InjectMocks
    private PlayerService playerService;

    @Mock
    private PlayerRepository playerRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreatePlayer() {
        Player player = new Player();
        player.setId(1L);
        when(playerRepository.save(player)).thenReturn(player);

        Player result = playerService.createPlayer(player);

        assertEquals(1L, result.getId());
    }

    @Test
    public void testGetPlayerDetailById() {
        Long playerId = 1L;
        Player player = new Player();
        player.setId(playerId);
        when(playerRepository.findById(playerId)).thenReturn(Optional.of(player));

        Player result = playerService.getPlayerDetailById(playerId);

        assertEquals(playerId, result.getId());
    }

    @Test
    public void testUpdatePlayer() {
        Player player = new Player();
        player.setId(1L);
        when(playerRepository.findById(player.getId())).thenReturn(Optional.of(player));
        when(playerRepository.save(player)).thenReturn(player);

        Player result = playerService.updatePlayer(player);

        assertEquals(1L, result.getId());
    }

    @Test
    public void testDeletePlayer() {
        Long playerId = 1L;

        playerService.deletePlayer(playerId);

        verify(playerRepository, times(1)).deleteById(playerId);
    }

    @Test
    public void testGetPlayersByCountry() {
        String country = "INDIA";
        List<Player> playerList = new ArrayList<>();
        when(playerRepository.findByCountryName(country)).thenReturn(playerList);

        List<Player> result = playerService.getPlayersByCountry(country);

        assertEquals(playerList, result);
    }

    @Test
    public void testGetPlayersWithAverageScoreGreaterThan() {
        int averageScore = 70;
        List<Player> playerList = new ArrayList<>();
        when(playerRepository.getPlayersWithAverageScoreGreaterThan(averageScore)).thenReturn(playerList);

        List<Player> result = playerService.getPlayersWithAverageScoreGreaterThan(averageScore);

        assertEquals(playerList, result);
    }

    @Test
    public void testGetPlayersWithAverageScoreGreaterThanYSorted() {
        int averageScore = 180;
        List<Player> playerList = new ArrayList<>();
        when(playerRepository.getPlayersWithAverageScoreGreaterThanYSorted(averageScore)).thenReturn(playerList);

        List<Player> result = playerService.getPlayersWithAverageScoreGreaterThanYSorted(averageScore);

        assertEquals(playerList, result);
    }
}
