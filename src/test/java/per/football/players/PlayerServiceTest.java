package per.football.players;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import per.football.players.Entity.Player;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {
    PlayerService playerService;

    @Mock
    PlayerRepository playerRepository;

    @Mock
    Properties properties;

    @BeforeEach
    void setUp() {
        playerService = new PlayerService(playerRepository, properties);
    }

    @Test
    void findAll() {
        when(playerRepository.findAll()).thenReturn(TestModels.getPlayers());
        List<Player> list = Lists.newArrayList(playerService.findAll());
        assertEquals(1, list.size());
    }

    @Test
    void save() {

        // Given
        Player player = TestModels.getPlayer();
        when(playerRepository.save(any())).thenReturn(player);

        // When
        Player saved = playerService.save(player);

        // Then
        verify(playerRepository).save(player);

        assertEquals(player, saved);
    }

    @Test
    void create() {
    }

    @Test
    void findById() {
    }

    @Test
    void updateById() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void getPassers() {
    }
}